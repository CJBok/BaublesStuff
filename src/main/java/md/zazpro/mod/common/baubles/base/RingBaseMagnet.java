/*
 * This class (RingBaseMagnet.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles.base;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public abstract class RingBaseMagnet extends BaubleBase {

    public int range;

    public RingBaseMagnet(String name, int range) {
        super(name);
        MinecraftForge.EVENT_BUS.register(this);
        this.range = range;
    }
    
    @Override
    public void addInformation(ItemStack itemStack, World worldIn, java.util.List<String> list, ITooltipFlag flag) {
    	
    	if (itemStack.getTagCompound() != null && itemStack.getTagCompound().getBoolean("active")) {
    		list.add("Active");
    	}
    	
    }

    public static int getCooldown(ItemStack itemStack) {
        return itemStack.getTagCompound().getInteger("cooldown");
    }

    public static void setCooldown(ItemStack itemStack, int cooldown) {
        itemStack.getTagCompound().setInteger("cooldown", cooldown);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }

    @Override
    public void onEquipped(ItemStack arg0, EntityLivingBase arg1) {
    }

    @Override
    public void onUnequipped(ItemStack arg0, EntityLivingBase arg1) {
    }

    @Override
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
        if (!(par3Entity instanceof EntityPlayer)) {
            return;
        }

        if (par1ItemStack.getTagCompound() == null) {
            par1ItemStack.setTagCompound(new NBTTagCompound());
            par1ItemStack.getTagCompound().setInteger("cooldown", 0);
            par1ItemStack.getTagCompound().setBoolean("active", true);
        }
    }


    public List<Entity> getEntitiesInRange(Class<? extends Entity> entityType, World world, EntityPlayer player) {
        return world.getEntitiesWithinAABB(entityType, 
        		new AxisAlignedBB(player.posX - this.range, 
        						  player.posY - this.range, 
        						  player.posZ - this.range, 
        						  player.posX + this.range, 
        						  player.posY + this.range, 
        						  player.posZ + this.range)
        		);
    }

    @SubscribeEvent
    public void onTossItem(ItemTossEvent event) {
        IBaublesItemHandler inv = BaublesApi.getBaublesHandler(event.getPlayer());
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack itemStack = inv.getStackInSlot(i);
            if (itemStack != null && itemStack.getTagCompound() != null && itemStack.getItem() instanceof RingBaseMagnet) {
                setCooldown(itemStack, 100);
            }
        }
    }
}
