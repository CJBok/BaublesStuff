/*
 * This class (BaublesStuff.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod;

import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.achievements.AchievementEvents;
import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.config.ConfigurationHandler;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import md.zazpro.mod.common.network.PacketHandler;
import md.zazpro.mod.common.recipe.CommonRecipes;
import md.zazpro.mod.common.recipe.RecipeBeltCore;
import md.zazpro.mod.common.recipe.RecipePendantCore;
import md.zazpro.mod.common.recipe.RecipeRingCore;
import md.zazpro.mod.common.tileentity.TEBookGenerator;
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import md.zazpro.mod.common.tileentity.TEExtractor;
import md.zazpro.mod.integration.ModUtils;
import md.zazpro.mod.proxy.CommonProxy;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MODID, version = ModInfo.VERSION, name = ModInfo.NAME, guiFactory = ModInfo.GUI_FACTORY_CLASS, updateJSON = ModInfo.UPDATE_LINK, dependencies = "required-after:baubles;after:botania")
public class BaublesStuff {

    //Mod Instance
    @Instance("baublesstuff")
    public static BaublesStuff instance;

    //Mod Integrations var


    //Proxy
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	//Configs
        ConfigurationHandler.loadConfig(event.getSuggestedConfigurationFile());
        
        //Mod detection
        ModUtils.Botania = Loader.isModLoaded("botania");

        //Network
        PacketHandler.preInit();

        //Creative Tab
        CreativeTab.TabRegister();
        
        //Events Register
    	MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new AchievementEvents());
        MinecraftForge.EVENT_BUS.register(new ItemsAndUpgrades());
        MinecraftForge.EVENT_BUS.register(new BlockRegister());

        //Achievements
        //BaublesStuffAchievement.loadAchievements();
        //BaublesStuffAchievement.registerPage();

        //Recipes
        CommonRecipes.register();

        //Proxy preInit
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //TE Register
        GameRegistry.registerTileEntity(TEExtractor.class, "tileEntityDisassembler");
        GameRegistry.registerTileEntity(TEExpGenerator.class, "tileEntityExpGenerator");
        GameRegistry.registerTileEntity(TEBookGenerator.class, "tileEntityBookGenerator");

        //Proxy init
        proxy.init(event);

        System.out.println("Baubles Stuff here :3");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
    
    @SubscribeEvent
    public void models(ModelRegistryEvent event) {
        proxy.registerModels();
    }
    
    @SubscribeEvent
    public void models(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().register(new RecipeBeltCore());
        event.getRegistry().register(new RecipePendantCore());
        event.getRegistry().register(new RecipeRingCore());
    }
}
