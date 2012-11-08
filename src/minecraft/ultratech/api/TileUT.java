package ultratech.api;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileUT extends TileEntity 
{
	
	private byte direction;
	private short state;
	private String owner;

	public byte getDirection() 
	{
		return direction;
	}
	
	public void setDirection(byte direction) 
	{
		this.direction = direction;
	}
	
	public short getState() 
	{
		return state;
	}
	
	public void setState(short state) 
	{
		this.state = state;
	}
	
	public String getOwner() 
	{
		return owner;
	}
	
	public void setOwner(String owner) 
	{
		this.owner = owner;
	}
	
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return owner.equals(player.username);
	}
	
	public void readFromNBT(NBTTagCompound nbtTagCompound) 
	{
        super.readFromNBT(nbtTagCompound);
        
        direction = nbtTagCompound.getByte("direction");
        state = nbtTagCompound.getShort("state");
        owner = nbtTagCompound.getString("owner");
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound) 
    {
        super.writeToNBT(nbtTagCompound);
        
        nbtTagCompound.setByte("direction", direction);
        nbtTagCompound.setShort("state", state);
        if(owner != null && owner != "") {
        	nbtTagCompound.setString("owner", owner);
        }
    }
    
}
