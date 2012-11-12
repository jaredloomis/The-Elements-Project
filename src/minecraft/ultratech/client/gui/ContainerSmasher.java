package ultratech.client.gui;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Slot;
import ultratech.common.tileentities.TileCollider;
import ultratech.common.tileentities.TileMatterBuilder;

public class ContainerSmasher extends Container
{
	protected TileCollider tile_entity;

	public ContainerSmasher(TileCollider tile_entity, InventoryPlayer player_inventory)
	{
		this.tile_entity = tile_entity;

		//@param slot, this is the slot declaration, and you can declare a new Slot and this has 4 params
		//@sub-param tile_entity, this is you TileTutorial
		//@sub-param 0, this is the slot id,
		//@sub-param 76, this is the x position on the screen for the slot
		//@sub-param 27, this is the y position on the screen for the slot
		addSlotToContainer(new Slot(tile_entity, 0, 44, 26));
		addSlotToContainer(new Slot(tile_entity, 1, 115, 43));
		addSlotToContainer(new Slot(tile_entity, 2, 115, 26));
		addSlotToContainer(new Slot(tile_entity, 3, 115, 9));

        
		bindPlayerInventory(player_inventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tile_entity.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer player_inventory)
	{
		/*player inventory*/
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(/*inventory:*/player_inventory,/*id:*/ j + i * 9 + 9,/*x:*/ 8 + j * 18,/*y:*/ 84 + i * 18));
			}
		}

		/*Player toolbar*/
		for(int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(player_inventory, i, 8 + i * 18, 142));
		}
	}
}