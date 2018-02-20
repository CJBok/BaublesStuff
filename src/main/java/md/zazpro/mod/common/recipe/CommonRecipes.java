/*
 * This class (CommonRecipes.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.recipe;

import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.config.ConfigurationHandler;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonRecipes {
	
	
    public static void register() {
    	
        /*GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, "upgradeextractor"),
        		null,
        		new ItemStack(BlockRegister.UpgradeExtractor),
                "ALA",
                "IDI",
                "ALA",
                'A', Blocks.STONE,
                'I', Items.IRON_INGOT,
                'L', new ItemStack(Items.DYE, 1, 4),
                'D', ItemsAndUpgrades.Upgrade_Stone);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, "experiencegenerator"),
        		null,
        		new ItemStack(BlockRegister.BlockExpGenerator),
                "AAA",
                "UEU",
                "GDG",
                'A', Items.BOOK, 'E', Blocks.ENCHANTING_TABLE, 'G', Items.GOLD_INGOT, 'U', ItemsAndUpgrades.Upgrade_Stone, 'D', Items.DIAMOND);*/

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Exp_Stuff.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Exp_Stuff),
                "III",
                "IBI",
                "III",
                'B', Items.BOOK, 'I', Items.IRON_INGOT);


        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_Stone.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_Stone),
                "ABA",
                "CDC",
                "ABA",
                'A', Blocks.STONE, 'B', Items.GOLD_INGOT, 'C', new ItemStack(Items.DYE, 1, 4), 'D', Items.IRON_INGOT);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Belt_Core.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Belt_Core),
                " B ",
                "BGB",
                " B ",
                'B', Items.LEATHER, 'G', Items.GOLD_INGOT);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Pendant_Core.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Pendant_Core),
                "G G",
                "AGA",
                " A ",
                'A', Items.FEATHER, 'G', Items.GOLD_INGOT);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Ring_Core.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Ring_Core),
                " G ",
                "G G",
                " G ",
                'G', Items.GOLD_INGOT);

        if (ConfigurationHandler.CMagnetRing)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Ring_Magnet.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Ring_Magnet),
                    "RA ",
                    "ABA",
                    " AL",
                    'A', Items.IRON_INGOT, 'B', ItemsAndUpgrades.Upgrade_Stone, 'R', new ItemStack(Items.DYE, 1, 1), 'L', new ItemStack(Items.DYE, 1, 4));

        //Sheets
        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Speed.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Speed),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.SUGAR);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Jump.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Jump),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.REEDS);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Haste.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Haste),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.GOLDEN_PICKAXE);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_HealthRegen.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_HealthRegen),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.GHAST_TEAR);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Invisibility.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Invisibility),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.FERMENTED_SPIDER_EYE);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_NightVision.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_NightVision),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.GOLDEN_CARROT);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Power.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Power),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.GOLDEN_SWORD);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_WitherImmune.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_WitherImmune),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.NETHER_STAR);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_FireImmune.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_FireImmune),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.MAGMA_CREAM);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_FallImmune.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_FallImmune),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.FEATHER);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_WaterBreathing.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_WaterBreathing),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', new ItemStack(Items.FISH, 1, 3));

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Growth.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Growth),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Blocks.MELON_BLOCK);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Harvest.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Harvest),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Items.GOLDEN_HOE);

        GameRegistry.addShapedRecipe(
        		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Sheet_Repair.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Sheet_Repair),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.WRITABLE_BOOK, 'W', Items.NETHER_WART, 'P', Items.BLAZE_POWDER, 'X', Blocks.IRON_BLOCK);

        if (ConfigurationHandler.CUpgrade_HighStep)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_HighStep.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_HighStep),
                    " T ",
                    "ABC",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_Stone, 'C', ItemsAndUpgrades.Sheet_Jump, 'T', Items.GHAST_TEAR, 'F', Items.BLAZE_POWDER);

        //Upgrades
        if (ConfigurationHandler.CUpgrade_FireImmune)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_FireImmune.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_FireImmune),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_FireImmune, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_FallImmune)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_FallImmune.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_FallImmune),
                    " D ",
                    "ABA",
                    " D ",
                    'A', ItemsAndUpgrades.Sheet_FallImmune, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', Items.DIAMOND);

        if (ConfigurationHandler.CUpgrade_WaterBreathing)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_WaterBreathing.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_WaterBreathing),
                    " X ",
                    "ABA",
                    " X ",
                    'A', ItemsAndUpgrades.Sheet_WaterBreathing, 'B', ItemsAndUpgrades.Upgrade_Stone, 'X', Items.GLASS_BOTTLE);

        if (ConfigurationHandler.CUpgrade_WitherImmune)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_WitherImmune.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_WitherImmune),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_WitherImmune, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_Fly)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_Fly.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_Fly),
                    "SCJ",
                    "QNE",
                    "SXJ",
                    'S', ItemsAndUpgrades.Sheet_Speed, 'C', Items.FEATHER, 'Q', ItemsAndUpgrades.Upgrade_SpeedIII, 'X', ItemsAndUpgrades.Upgrade_FallImmune, 'N', Items.NETHER_STAR, 'E', ItemsAndUpgrades.Upgrade_JumpIII, 'J', ItemsAndUpgrades.Sheet_Jump);

        if (ConfigurationHandler.CUpgrade_SpeedI)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_SpeedI.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_SpeedI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_SpeedII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_SpeedII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_SpeedII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_SpeedI, 'G', Items.SUGAR, 'F', Items.BLAZE_POWDER);

        if (ConfigurationHandler.CUpgrade_SpeedIII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_SpeedIII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_SpeedIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_SpeedII, 'T', Items.GHAST_TEAR, 'F', Items.DIAMOND);

        if (ConfigurationHandler.CUpgrade_JumpI)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_JumpI.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_JumpI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Jump, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_JumpII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_JumpII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_JumpII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Jump, 'B', ItemsAndUpgrades.Upgrade_JumpI, 'G', Items.FEATHER, 'F', Items.BLAZE_POWDER);

        if (ConfigurationHandler.CUpgrade_JumpIII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_JumpIII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_JumpIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Jump, 'B', ItemsAndUpgrades.Upgrade_JumpII, 'T', Items.MAGMA_CREAM, 'F', Items.DIAMOND);

        if (ConfigurationHandler.CUpgrade_HasteI)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_HasteI.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_HasteI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Haste, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_HasteII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_HasteII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_HasteII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Haste, 'B', ItemsAndUpgrades.Upgrade_HasteI, 'G', Items.GOLD_NUGGET, 'F', Items.BLAZE_POWDER);

        if (ConfigurationHandler.CUpgrade_HasteIII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_HasteIII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_HasteIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Haste, 'B', ItemsAndUpgrades.Upgrade_HasteII, 'T', Items.GHAST_TEAR, 'F', Items.DIAMOND_PICKAXE);

        if (ConfigurationHandler.CUpgrade_PowerI)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_PowerI.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_PowerI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Power, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_PowerII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_PowerII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_PowerII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Power, 'B', ItemsAndUpgrades.Upgrade_PowerI, 'G', Items.QUARTZ, 'F', Items.BLAZE_POWDER);

        if (ConfigurationHandler.CUpgrade_PowerIII)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_PowerIII.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_PowerIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Power, 'B', ItemsAndUpgrades.Upgrade_PowerII, 'T', Items.GHAST_TEAR, 'F', Items.DIAMOND_SWORD);

        if (ConfigurationHandler.CNotLMagnetRing)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Ring_NotLMagnet.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Ring_NotLMagnet),
                    "DAC",
                    "ABA",
                    "DAC",
                    'A', Items.IRON_INGOT, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', new ItemStack(Items.DYE, 1, 4), 'C', new ItemStack(Items.DYE, 1, 1));

        if (ConfigurationHandler.CUpgrade_HealthRegen)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_HealthRegen.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_HealthRegen),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_HealthRegen, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_Invisibility)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_Invisibility.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_Invisibility),
                    " D ",
                    "ABA",
                    " D ",
                    'A', ItemsAndUpgrades.Sheet_Invisibility, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', Items.DIAMOND);

        if (ConfigurationHandler.CUpgrade_NightVision)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_NightVision.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_NightVision),
                    " D ",
                    "ABA",
                    " D ",
                    'A', ItemsAndUpgrades.Sheet_NightVision, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', Items.DIAMOND);

        if (ConfigurationHandler.CUpgrade_Growth)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_Growth.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_Growth),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Growth, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_Harvest)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_Harvest.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_Harvest),
                    " X ",
                    "ABA",
                    " X ",
                    'A', ItemsAndUpgrades.Sheet_Harvest, 'B', ItemsAndUpgrades.Upgrade_Stone, 'X', Items.DIAMOND);

        if (ConfigurationHandler.CUpgrade_Repair)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_Repair.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_Repair),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Repair, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (ConfigurationHandler.CUpgrade_Vampire)
            GameRegistry.addShapedRecipe(
            		new ResourceLocation(ModInfo.MODID, ItemsAndUpgrades.Upgrade_Vampire.getUnlocalizedName()), null, new ItemStack(ItemsAndUpgrades.Upgrade_Vampire),
                    " T ",
                    "ABH",
                    " P ",
                    'A', ItemsAndUpgrades.Sheet_Power, 'B', ItemsAndUpgrades.Upgrade_Stone, 'H', ItemsAndUpgrades.Sheet_HealthRegen, 'T', Items.GHAST_TEAR, 'P', Items.BLAZE_POWDER);

    }

}
