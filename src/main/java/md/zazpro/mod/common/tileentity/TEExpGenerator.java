/*
 * This class (TEExpGenerator.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.tileentity;

import md.zazpro.mod.common.config.ConfigurationHandler;
import md.zazpro.mod.common.energy.BaubleBSUContainer;
import md.zazpro.mod.common.energy.TileBSUHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TEExpGenerator extends TileBSUHandler implements IInventory, ITickable {
    public int lvl;
    private int maxBSU = 1000000;
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);
    private String customName;

    public TEExpGenerator() {
        storage.setCapacity(maxBSU);
    }

    @Override
    public void update() {
        if (!this.world.isRemote) {
            if (storage.getBSUStored() <= storage.getMaxBSUStored()) {
                storage.modifyBSUStored(storage.receiveBSU((int) Math.round((lvl * ConfigurationHandler.TEExpGenRate)), false));
                this.markDirty();
            }
            if (this.validateItem(this.getStackInSlot(0)) && this.getStackInSlot(1) == ItemStack.EMPTY) {
                BaubleBSUContainer item = ((BaubleBSUContainer) this.getStackInSlot(0).getItem());
                storage.modifyBSUStored(-storage.extractBSU(item.getMaxBSUTransfer(this.getStackInSlot(0)), false));
                item.receiveBSU(this.getStackInSlot(0), item.getMaxBSUTransfer(this.getStackInSlot(0)), false);
                if (item.getBSUStored(this.getStackInSlot(0)) == item.getMaxBSUStored(this.getStackInSlot(0))) {
                    this.setInventorySlotContents(1, this.getStackInSlot(0));
                    this.setInventorySlotContents(0, ItemStack.EMPTY);
                }
                this.markDirty();
            }
        }
    }

    public boolean validateItem(ItemStack itemStack) {
        if (itemStack != ItemStack.EMPTY && itemStack.getItem() instanceof BaubleBSUContainer) {
            BaubleBSUContainer item = (BaubleBSUContainer) itemStack.getItem();
            if (item.getBSUStored(itemStack) < item.getMaxBSUStored(itemStack))
                return true;
        }
        return false;
    }

    public String getCustomName() {
        return this.customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Override
    public String getName() { return this.hasCustomName() ? this.customName : "container.exp_gen_tile_entity"; }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.equals("");
    }

    @Override
    public ITextComponent getDisplayName() {
        return ITextComponent.Serializer.fromJsonLenient(this.hasCustomName() ? (this.getName()) : I18n.format(this.getName()));
    }

    @SideOnly(Side.CLIENT)
    public int getBsuScaled(int i) {
        return this.getBsuStored() * i / this.getBsuMax();
    }

    public int getBsuStored() {
        return storage.getBSUStored();
    }

    public void setBsuStored(int bsu) {
        storage.setBSUStored(bsu);
    }

    public int getLvlStored() {
        return this.lvl;
    }

    public void setLvlStored(int lvl) {
        this.lvl = lvl;
    }

    public int getBsuMax() {
        return this.maxBSU;
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory())
            return ItemStack.EMPTY;
        return this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
    	ItemStack itemstack = ItemStack.EMPTY;
        if (this.getStackInSlot(index) != ItemStack.EMPTY) {
            if (this.getStackInSlot(index).getCount() <= count) {
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, ItemStack.EMPTY);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).getCount()  <= 0) {
                    this.setInventorySlotContents(index, ItemStack.EMPTY);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return itemstack;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory())
            return;

        if (stack != ItemStack.EMPTY && stack.getCount() > this.getInventoryStackLimit())
            stack.setCount(this.getInventoryStackLimit());

        if (stack != ItemStack.EMPTY && stack.getCount() == 0)
            stack = ItemStack.EMPTY;

        this.inventory.set(index, stack);
        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0:
                return storage.getBSUStored();

            case 1:
                return this.lvl;
            default:
                return 0;
        }
    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.getSizeInventory(); i++)
            this.setInventorySlotContents(i, ItemStack.EMPTY);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) != ItemStack.EMPTY) {
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                this.getStackInSlot(i).writeToNBT(stackTag);
                list.appendTag(stackTag);
            }
        }
        nbt.setTag("Items", list);
        nbt.setInteger("LVL", this.lvl);

        if (this.hasCustomName()) {
            nbt.setString("CustomName", this.getCustomName());
        }
        return (nbt);
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            this.setInventorySlotContents(slot, new ItemStack(stackTag));
        }
        this.lvl = nbt.getInteger("LVL");
        if (nbt.hasKey("CustomName", 8)) {
            this.setCustomName(nbt.getString("CustomName"));
        }
    }

    public void setField(int id, int value) {
        switch (id) {
            case 0:
                //this.bsu = value;
            case 1:
                this.lvl = value;
                break;
        }
    }

	@Override
	public boolean isEmpty() {
		return false;
	}
}
