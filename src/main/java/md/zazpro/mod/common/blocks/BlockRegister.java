/*
 * This class (BlockRegister.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.blocks;

import md.zazpro.mod.client.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockRegister
{

    public static final Block UpgradeExtractor = new UpgradeExtractor();
    public static final Block BlockExpGenerator = new BlockExpGenerator();
    public static final Block BlockBookGenerator = new BlockBookGenerator();
    
    @SubscribeEvent
    public void registerBlock(RegistryEvent.Register<Block> event)
    {
    	event.getRegistry().register(UpgradeExtractor.setRegistryName(ModInfo.MODID, "upgradeextractor").setUnlocalizedName("upgradeextractor"));
    	event.getRegistry().register(BlockExpGenerator.setRegistryName(ModInfo.MODID, "experiencegenerator").setUnlocalizedName("experiencegenerator"));
    	event.getRegistry().register(BlockBookGenerator.setRegistryName(ModInfo.MODID, "bookgenerator").setUnlocalizedName("bookgenerator"));
    }

    private static void registerRender(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(
                ModInfo.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void registerRenders()
    {
        registerRender(UpgradeExtractor);
        registerRender(BlockExpGenerator);
        registerRender(BlockBookGenerator);
    }
}
