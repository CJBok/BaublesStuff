/*
 * This class (ItemsAndUpgrades.java) was created by <zazpro>. It's distributed as
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
import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.baubles.*;
import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.config.ConfigurationHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemsAndUpgrades {
	
	public static final Item Upgrade_Stone = new Item().setUnlocalizedName("Upgrade_Stone").setRegistryName("Upgrade_Stone").setMaxDamage(0).setCreativeTab(CreativeTab.tabBaublesStuff);
	public static final Item Spell_Book = new SpellBook();
	public static final Item Translator = new Translator();
	public static final Item Broken_Translator = new Broken_Translator();
	public static final Item Exp_Stuff = new Exp_Stuff();
	public static final Item Belt_Core = new Belt_Core("Belt_Core");
	public static final Item Pendant_Core = new Pendant_Core("Pendant_Core");
	public static final Item Ring_Core = new Ring_Core("Ring_Core");
	public static final Item Ring_Magnet = new Ring_Magnet("Ring_Magnet", ConfigurationHandler.MagnetRange);
	public static final Item Ring_NotLMagnet = new Ring_NotLMagnet("Ring_NotLMagnet", ConfigurationHandler.MagnetRange);
	public static final Item Body_Core = new Body_Core("Body_Core");
	public static final Item Charm_Core = new Charm_Core("Charm_Core");
	public static final Item Head_Core = new Head_Core("Head_Core");
	public static final Item Upgrade_HighStep = new ItemUpgrade("Upgrade_HighStep", formatTooltip(ConfigurationHandler.Belt_STEP, false, true));
	public static final Item Upgrade_SpeedI = new ItemUpgrade("Upgrade_SpeedI", formatTooltip(ConfigurationHandler.Belt_SPEED, false, false));
	public static final Item Upgrade_SpeedII = new ItemUpgrade("Upgrade_SpeedII", formatTooltip(ConfigurationHandler.Belt_SPEED, false, false));
	public static final Item Upgrade_SpeedIII = new ItemUpgrade("Upgrade_SpeedIII", formatTooltip(ConfigurationHandler.Belt_SPEED, false, false));
	public static final Item Upgrade_JumpI = new ItemUpgrade("Upgrade_JumpI", formatTooltip(ConfigurationHandler.Belt_JUMP, true, true));
	public static final Item Upgrade_JumpII = new ItemUpgrade("Upgrade_JumpII", formatTooltip(ConfigurationHandler.Belt_JUMP, true, true));
	public static final Item Upgrade_JumpIII = new ItemUpgrade("Upgrade_JumpIII", formatTooltip(ConfigurationHandler.Belt_JUMP, true, true));
	public static final Item Upgrade_Fly = new ItemUpgrade("Upgrade_Fly", formatTooltip(ConfigurationHandler.Belt_FLY, false, false));
	public static final Item Upgrade_FireImmune = new ItemUpgrade("Upgrade_FireImmune", formatTooltip(ConfigurationHandler.Pendant_FIRE, false, false));
	public static final Item Upgrade_FallImmune = new ItemUpgrade("Upgrade_FallImmune", formatTooltip(ConfigurationHandler.Pendant_FALL, false, false));
	public static final Item Upgrade_WaterBreathing = new ItemUpgrade("Upgrade_WaterBreathing", formatTooltip(ConfigurationHandler.Pendant_WATER, false, false));
	public static final Item Upgrade_WitherImmune = new ItemUpgrade("Upgrade_WitherImmune", formatTooltip(ConfigurationHandler.Pendant_WITHER, false, false));
	public static final Item Upgrade_HealthRegen = new ItemUpgrade("Upgrade_HealthRegen", formatTooltip(ConfigurationHandler.Pendant_HEALTH, false, false));
	public static final Item Upgrade_Vampire = new ItemUpgrade("Upgrade_Vampire", formatTooltip(ConfigurationHandler.Pendant_VAMPIRE, true, true));
	public static final Item Upgrade_Invisibility = new ItemUpgrade("Upgrade_Invisibility", formatTooltip(ConfigurationHandler.Ring_INVISIBILITY, false, true));
	public static final Item Upgrade_NightVision = new ItemUpgrade("Upgrade_NightVision", formatTooltip(ConfigurationHandler.Ring_NIGH, false, true));
	public static final Item Upgrade_Growth = new ItemUpgrade("Upgrade_Growth", formatTooltip(ConfigurationHandler.Ring_GROWTH, true, true));
	public static final Item Upgrade_Harvest = new ItemUpgrade("Upgrade_Harvest", formatTooltip(ConfigurationHandler.Ring_HARVEST, true, true));
	public static final Item Upgrade_HasteI = new ItemUpgrade("Upgrade_HasteI", formatTooltip(ConfigurationHandler.Ring_HASTE, true, true));
	public static final Item Upgrade_HasteII = new ItemUpgrade("Upgrade_HasteII", formatTooltip(ConfigurationHandler.Ring_HASTE, true, true));
	public static final Item Upgrade_HasteIII = new ItemUpgrade("Upgrade_HasteIII", formatTooltip(ConfigurationHandler.Ring_HASTE, true, true));
	public static final Item Upgrade_PowerI = new ItemUpgrade("Upgrade_PowerI", formatTooltip(ConfigurationHandler.Ring_POWER, true, true));
	public static final Item Upgrade_PowerII = new ItemUpgrade("Upgrade_PowerII", formatTooltip(ConfigurationHandler.Ring_POWER, true, true));
	public static final Item Upgrade_PowerIII = new ItemUpgrade("Upgrade_PowerIII", formatTooltip(ConfigurationHandler.Ring_POWER, true, true));
	public static final Item Upgrade_Repair = new ItemUpgrade("Upgrade_Repair", formatTooltip(ConfigurationHandler.Ring_REPAIR, true, true));
	public static final Item Sheet_FireImmune = new ItemSheet("Sheet_FireImmune");
	public static final Item Sheet_FallImmune = new ItemSheet("Sheet_FallImmune");
	public static final Item Sheet_Haste = new ItemSheet("Sheet_Haste");
	public static final Item Sheet_HealthRegen = new ItemSheet("Sheet_HealthRegen");
	public static final Item Sheet_Invisibility = new ItemSheet("Sheet_Invisibility");
	public static final Item Sheet_Jump = new ItemSheet("Sheet_Jump");
	public static final Item Sheet_NightVision = new ItemSheet("Sheet_NightVision");
	public static final Item Sheet_Power = new ItemSheet("Sheet_Power");
	public static final Item Sheet_Speed = new ItemSheet("Sheet_Speed");
	public static final Item Sheet_WaterBreathing = new ItemSheet("Sheet_WaterBreathing");
	public static final Item Sheet_WitherImmune = new ItemSheet("Sheet_WitherImmune");
	public static final Item Sheet_Growth = new ItemSheet("Sheet_Growth");
	public static final Item Sheet_Harvest = new ItemSheet("Sheet_Harvest");
	public static final Item Sheet_Repair = new ItemSheet("Sheet_Repair");
	
	public static Item ItemBlockUpgradeExtractor = new ItemBlock(BlockRegister.UpgradeExtractor);
    public static Item ItemBlockExpGenerator = new ItemBlock(BlockRegister.BlockExpGenerator);;
    public static Item ItemBlockBookGenerator = new ItemBlock(BlockRegister.BlockBookGenerator);;
    
    @SubscribeEvent
    public void registration(RegistryEvent.Register<Item> event) {
    	event.getRegistry().register(Spell_Book);
    	event.getRegistry().register(Translator);
    	event.getRegistry().register(Broken_Translator);
    	event.getRegistry().register(Exp_Stuff);
    	event.getRegistry().register(Sheet_FireImmune);
    	event.getRegistry().register(Sheet_FallImmune);
        event.getRegistry().register(Sheet_Haste);
        event.getRegistry().register(Sheet_HealthRegen);
        event.getRegistry().register(Sheet_Invisibility);
        event.getRegistry().register(Sheet_Jump);
        event.getRegistry().register(Sheet_NightVision);
        event.getRegistry().register(Sheet_Power);
        event.getRegistry().register(Sheet_Speed);
        event.getRegistry().register(Sheet_WaterBreathing);
        event.getRegistry().register(Sheet_WitherImmune);
        event.getRegistry().register(Sheet_Growth);
        event.getRegistry().register(Sheet_Harvest);
        event.getRegistry().register(Sheet_Repair);
        event.getRegistry().register(Belt_Core);
        event.getRegistry().register(Pendant_Core);
        event.getRegistry().register(Ring_Core);
        event.getRegistry().register(Ring_Magnet);
        event.getRegistry().register(Ring_NotLMagnet);
        event.getRegistry().register(Body_Core);
        event.getRegistry().register(Charm_Core);
        event.getRegistry().register(Head_Core);
        event.getRegistry().register(Upgrade_Stone);
        event.getRegistry().register(Upgrade_HighStep);
        event.getRegistry().register(Upgrade_SpeedI);
        event.getRegistry().register(Upgrade_SpeedII);
        event.getRegistry().register(Upgrade_SpeedIII);
        event.getRegistry().register(Upgrade_JumpI);
        event.getRegistry().register(Upgrade_JumpII);
        event.getRegistry().register(Upgrade_JumpIII);
        event.getRegistry().register(Upgrade_Fly);
        event.getRegistry().register(Upgrade_FireImmune);
        event.getRegistry().register(Upgrade_FallImmune);
        event.getRegistry().register(Upgrade_WaterBreathing);
        event.getRegistry().register(Upgrade_WitherImmune);
        event.getRegistry().register(Upgrade_Invisibility);
        event.getRegistry().register(Upgrade_HealthRegen);
        event.getRegistry().register(Upgrade_NightVision);
        event.getRegistry().register(Upgrade_HasteI);
        event.getRegistry().register(Upgrade_HasteII);
        event.getRegistry().register(Upgrade_HasteIII);
        event.getRegistry().register(Upgrade_PowerI);
        event.getRegistry().register(Upgrade_PowerII);
        event.getRegistry().register(Upgrade_PowerIII);
        event.getRegistry().register(Upgrade_Growth);
        event.getRegistry().register(Upgrade_Harvest);
        event.getRegistry().register(Upgrade_Repair);
        event.getRegistry().register(Upgrade_Vampire);
        
        event.getRegistry().register(ItemBlockUpgradeExtractor.setRegistryName(ModInfo.MODID, "upgradeextractor"));
        event.getRegistry().register(ItemBlockExpGenerator.setRegistryName(ModInfo.MODID, "experiencegenerator"));
        event.getRegistry().register(ItemBlockBookGenerator.setRegistryName(ModInfo.MODID, "bookgenerator"));
    }

    private static Object formatTooltip(int amount, boolean flag, boolean flag1) {
        if (!flag && flag1)
            return TextFormatting.GOLD + "Passive consume " + TextFormatting.RED + amount + " BSU/Second";
        else if (!flag && !flag1)
            return TextFormatting.GOLD + "Active consume " + TextFormatting.RED + amount + " BSU/Second";
        else
            return TextFormatting.GOLD + "Active consume " + TextFormatting.RED + amount + " BSU/Work";
    }
}
