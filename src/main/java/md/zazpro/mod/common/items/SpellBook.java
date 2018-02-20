/*
 * This class (SpellBook.java) was created by <zazpro>. It's distributed as
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
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class SpellBook extends Item {

    public SpellBook() {
        super();
        MinecraftForge.EVENT_BUS.register(this);
        this.setUnlocalizedName("Spell_Book");
        setRegistryName("Spell_Book");
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTab.tabBaublesStuff);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }

//Change this to make the item not stay in the crafting grid

    @Override
    public void addInformation(ItemStack itemStack, World worldIn, java.util.List list, ITooltipFlag tooltipFlag) {
        list.add(I18n.format("tooltip.items.Pigman"));
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        return itemstack.copy();
    }

    @Override
    public boolean hasContainerItem(ItemStack itemstack) {
        return true;
    }

    @SubscribeEvent
    public void onKill(LivingDropsEvent event) {
        if (event.getEntity() instanceof EntityPigZombie) {
            if (randInt(1, 20) == 1)
                event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX,
                        event.getEntity().posY, event.getEntity().posZ, new ItemStack(ItemsAndUpgrades.Spell_Book)));
        }
    }


}
