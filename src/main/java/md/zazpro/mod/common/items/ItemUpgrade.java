/*
 * This class (ItemUpgrade.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.items;

import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.interfaces.IUpgrade;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUpgrade extends Item implements IUpgrade {
    public Object s;

    public ItemUpgrade(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setMaxDamage(0);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }

    public ItemUpgrade(String name, Object tooltip) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setMaxDamage(0);
        setCreativeTab(CreativeTab.tabBaublesStuff);
        s = tooltip;
    }

    @Override
    public void addInformation(ItemStack itemStack, World worldIn,
                               java.util.List list, ITooltipFlag p_77624_4_) {
        if (s!=null)
        list.add(s);
    }
}
