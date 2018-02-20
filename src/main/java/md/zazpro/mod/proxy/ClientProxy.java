/*
 * This class (ClientProxy.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.proxy;

import md.zazpro.mod.client.events.KeyHandler;
import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.items.ItemsRender;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ItemsRender.renderPreInit();
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        BlockRegister.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    
    @Override
    public void registerModels() {
    	ItemsRender.registerModels();
    }
}
