package ultratech.client.gui;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Slot;
import ultratech.common.tileentities.TileBattery;

public class ContainerBattery extends ContainerUT
{
	protected TileBattery tile_entity;
	public int inventorySize;

	public ContainerBattery(TileBattery tile_entity, InventoryPlayer player_inventory)
	{
		super(tile_entity.getSizeInventory());
		this.tile_entity = tile_entity;
		
		addSlotToContainer(new Slot(tile_entity, 0, 10, 27));
		addSlotToContainer(new Slot(tile_entity, 1, 50, 27));
		addSlotToContainer(new Slot(tile_entity, 2, 90, 27));
		addSlotToContainer(new Slot(tile_entity, 3, 130, 27));
		
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