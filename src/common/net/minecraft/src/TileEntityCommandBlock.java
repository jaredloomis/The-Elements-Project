package net.minecraft.src;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.server.MinecraftServer;

public class TileEntityCommandBlock extends TileEntity implements ICommandSender
{
    private String field_82354_a = "";

    public void func_82352_b(String par1Str)
    {
        this.field_82354_a = par1Str;
        this.onInventoryChanged();
    }

    @SideOnly(Side.CLIENT)
    public String func_82353_c()
    {
        return this.field_82354_a;
    }

    public void func_82351_a(World par1World)
    {
        if (!par1World.isRemote)
        {
            MinecraftServer var2 = MinecraftServer.getServer();

            if (var2 != null && var2.func_82356_Z())
            {
                ICommandManager var3 = var2.getCommandManager();
                var3.executeCommand(this, this.field_82354_a);
            }
        }
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        return "@";
    }

    public void sendChatToPlayer(String par1Str) {}

    /**
     * Returns true if the command sender is allowed to use the given command.
     */
    public boolean canCommandSenderUseCommand(int par1, String par2Str)
    {
        return par1 <= 2;
    }

    /**
     * Translates and formats the given string key with the given arguments.
     */
    public String translateString(String par1Str, Object ... par2ArrayOfObj)
    {
        return par1Str;
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setString("Command", this.field_82354_a);
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.field_82354_a = par1NBTTagCompound.getString("Command");
    }

    public ChunkCoordinates func_82114_b()
    {
        return new ChunkCoordinates(this.xCoord, this.yCoord, this.zCoord);
    }

    /**
     * Overriden in a sign to provide the text.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound var1 = new NBTTagCompound();
        this.writeToNBT(var1);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 2, var1);
    }
}
