/*
 * This class (Ring_NotLMagnet.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles;

import md.zazpro.mod.common.baubles.base.RingBaseMagnet;
import md.zazpro.mod.integration.Botania;
import md.zazpro.mod.integration.ModUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import java.util.Iterator;

public class Ring_NotLMagnet extends RingBaseMagnet {

    public Ring_NotLMagnet(String name, int range) {
        super(name, range);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onWornTick(ItemStack item, EntityLivingBase e) {

        if (!(e instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) e;
        World world = player.world;
        
        if (world.isRemote || player.isDead) 
        {
        	return;
        }
        
        int cooldown = getCooldown(item);

        if (cooldown <= 0) {
            Iterator<Entity> iterator = getEntitiesInRange(EntityItem.class, world, player).iterator();
            while (iterator.hasNext())
            {
                EntityItem itemToGet = (EntityItem) iterator.next();
                
                if (itemToGet.isDead || itemToGet.lifespan == Integer.MAX_VALUE)
                {
                	continue;
                }
                
                if (ModUtils.Botania && !Botania.hasSolegnoliaAround(itemToGet))
                {
                	continue;
                }
                
                itemToGet.onCollideWithPlayer(player);
            }
            
            iterator = getEntitiesInRange(EntityXPOrb.class, world, player).iterator();
            while (iterator.hasNext()) 
            {
                EntityXPOrb xpToGet = (EntityXPOrb) iterator.next();
                if (!xpToGet.isDead) 
                {
                	xpToGet.onCollideWithPlayer(player);
                }
            }
        } 
        else
        {
        	setCooldown(item, cooldown - 1);
        }
    }

}
