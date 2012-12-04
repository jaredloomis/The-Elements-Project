package ultratech.client.gui;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import ultratech.common.tileentities.TileFission;
import ultratech.common.tileentities.TileMatterBuilder;

public class ContainerFission extends ContainerUT
{
	protected TileFission tile_entity;
	public int inventorySize;

	public ContainerFission(TileFission tile_entity, InventoryPlayer player_inventory)
	{
		super(tile_entity.getSizeInventory());
		this.tile_entity = tile_entity;
		
		addSlotToContainer(new Slot(tile_entity, 0, 44, 26));
		//addSlotToContainer(new Slot(tile_entity, 1, 115, 43));
		addSlotToContainer(new Slot(tile_entity, 2, 115, 26));
		//addSlotToContainer(new Slot(tile_entity, 3, 115, 9));
		
		inventorySize = player_inventory.getSizeInventory();
		
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