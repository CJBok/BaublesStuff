/*
 * This class (BaubleBase.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles.base;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import md.zazpro.mod.BaublesStuff;
import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.client.gui.BSGuiHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * This class was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 * <p>
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.md
 * Created by zazpro on 5/16/2016.
 */
public abstract class BaubleBase extends Item implements IBauble {

    public BaubleBase() {

    }

    public BaubleBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	ItemStack itemStack = player.getHeldItem(hand);
    	
        if (!world.isRemote) {
        	
        	if (player.isSneaking()) {
        		//player.openGui(BaublesStuff.instance, BSGuiHandler.BAUBLE_ITEM_GUI, world, 0, 0, 0);
        	}
        	
            IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
            for (int i = 0; i < baubles.getSlots(); i++)
                if (baubles.getStackInSlot(i) == null && baubles.isItemValidForSlot(i, itemStack, player)) {
                    baubles.setStackInSlot(i, itemStack.copy());
                    if (!player.capabilities.isCreativeMode) {
                    	player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                    onEquipped(itemStack, player);
                    break;
                }
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }
}