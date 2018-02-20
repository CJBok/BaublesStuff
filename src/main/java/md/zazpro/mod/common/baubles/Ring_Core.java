/*
 * This class (Ring_Core.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.common.config.ConfigurationHandler;
import md.zazpro.mod.common.energy.BaubleBSUContainer;
import md.zazpro.mod.helper.Wrapper;
import md.zazpro.mod.helper.ring.RingUtils;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class Ring_Core extends BaubleBSUContainer {

    private static final int COST_INTERVAL = 20;
    private boolean NightVision = false;
    private boolean checkForNightVision = false;

    public Ring_Core(String name) {
        super(800000, 1000, 1000);
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.tabBaublesStuff);
        setHasSubtypes(true);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void addInformation(ItemStack itemStack, World worldIn, java.util.List<String> list, ITooltipFlag p_77624_4_) {

        list.add(TextFormatting.GOLD + (this.getBSUStored(itemStack) + "/" + this.getMaxBSUStored(itemStack) + " BSU"));
        list.add(I18n.format("tooltip.shift"));

        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            list.add(TextFormatting.RED + I18n.format("tooltip.ring.warning"));
            list.add(TextFormatting.WHITE + I18n.format("tooltip.ring.Invisibility"));
            list.add(TextFormatting.WHITE + I18n.format("tooltip.ring.NightVision"));
            list.add(TextFormatting.WHITE + I18n.format("tooltip.ring.Haste"));
            list.add(TextFormatting.WHITE + I18n.format("tooltip.ring.Power"));
            list.add(TextFormatting.WHITE + I18n.format("tooltip.ring.FastGrowth"));
            list.add(TextFormatting.WHITE + I18n.format("tooltip.ring.Harvest"));
            list.add(TextFormatting.WHITE + I18n.format("tooltip.ring.Repair"));
        } else if (itemStack.getTagCompound() != null) {
            Boolean invisibility = itemStack.getTagCompound().getBoolean("Invisibility");
            if (invisibility)
                list.add(TextFormatting.AQUA + I18n.format("tooltip.ring.Invisibility"));
            Boolean nightVision = itemStack.getTagCompound().getBoolean("NightVision");
            if (nightVision) list.add(TextFormatting.AQUA + I18n.format("tooltip.ring.NightVision"));
            Float haste = itemStack.getTagCompound().getFloat("Haste");
            if (haste > 0)
                list.add(TextFormatting.AQUA + I18n.format("tooltip.ring.HasteLVL") + ": +" + Math.round(haste));
            Integer power = itemStack.getTagCompound().getInteger("Power");
            if (power > 0)
                list.add(TextFormatting.AQUA + I18n.format("tooltip.ring.PowerLVL") + ": +" + power);
            Boolean Growth = itemStack.getTagCompound().getBoolean("Growth");
            if (Growth) list.add(TextFormatting.AQUA + I18n.format("tooltip.ring.FastGrowth"));
            Boolean Harvest = itemStack.getTagCompound().getBoolean("Harvest");
            if (Harvest) list.add(TextFormatting.AQUA + I18n.format("tooltip.ring.Harvest"));
            Boolean Repair = itemStack.getTagCompound().getBoolean("Repair");
            if (Repair) list.add(TextFormatting.AQUA + I18n.format("tooltip.ring.Repair"));
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void clientTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().player != null && Wrapper.INSTANCE.world() != null && checkForNightVision) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            ItemStack itemStack1 = BaublesApi.getBaublesHandler(player).getStackInSlot(1);
            ItemStack itemStack2 = BaublesApi.getBaublesHandler(player).getStackInSlot(2);
            if (RingUtils.isLegalb(itemStack1, itemStack2, "NightVision") && NightVision == false) {
                ItemStack itemStack3 = RingUtils.getStackFromBoolean(itemStack1, itemStack2, "NightVision");
                if (this.getBSUStored(itemStack3) >= ConfigurationHandler.Ring_INVISIBILITY) {
                    if (player.ticksExisted % COST_INTERVAL == 0)
                        this.extractBSU(itemStack3, ConfigurationHandler.Ring_INVISIBILITY, false);
                    float[] bright = Wrapper.INSTANCE.world().provider.getLightBrightnessTable();
                    for (int i = 0; i < bright.length; i++) {
                        bright[i] = 1.0F;
                    }
                    NightVision = true;
                }
            } else if (!RingUtils.isLegalb(itemStack1, itemStack2, "NightVision") && NightVision) {
                Wrapper.INSTANCE.world().provider.setWorld(Wrapper.INSTANCE.world());
                NightVision = false;
            }
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase e) {
        checkForNightVision = true;
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase e) {
        e.setInvisible(false);
        checkForNightVision = true;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase e) {
        if (itemStack.getTagCompound() != null) {
        	this.setBSUStored(itemStack, this.getMaxBSUStored(itemStack));
            if (e instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) e;
                ItemStack itemStack1 = BaublesApi.getBaublesHandler(player).getStackInSlot(1);
                ItemStack itemStack2 = BaublesApi.getBaublesHandler(player).getStackInSlot(2);
                World world = player.world;

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Invisibility")) {
                    ItemStack itemStack3 = RingUtils.getStackFromBoolean(itemStack1, itemStack2, "Invisibility");
                    if (this.getBSUStored(itemStack3) >= ConfigurationHandler.Ring_INVISIBILITY) {
                        if (player.ticksExisted % COST_INTERVAL == 0) {
                            this.extractBSU(itemStack3, ConfigurationHandler.Ring_INVISIBILITY, false);
                        }
                        player.setInvisible(true);
                    } else {
                        player.setInvisible(false);
                    }
                }

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Growth")) {
                    ItemStack itemStack3 = RingUtils.getStackFromBoolean(itemStack1, itemStack2, "Growth");
                    if (this.getBSUStored(itemStack3) >= ConfigurationHandler.Ring_GROWTH) {
                        if (player.ticksExisted % COST_INTERVAL == 0)
                            this.extractBSU(itemStack3, ConfigurationHandler.Ring_GROWTH, false);
                        UpdatePlant(player, world);
                    }
                }

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Harvest")) {
                    ItemStack itemStack3 = RingUtils.getStackFromBoolean(itemStack1, itemStack2, "Harvest");
                    if (this.getBSUStored(itemStack3) >= ConfigurationHandler.Ring_HARVEST) {
                        if (player.ticksExisted % COST_INTERVAL == 0)
                            this.extractBSU(itemStack3, ConfigurationHandler.Ring_HARVEST, false);
                        HarvestPlant(player, world);
                    }
                }

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Repair")) {
                    ItemStack itemStack3 = RingUtils.getStackFromBoolean(itemStack1, itemStack2, "Repair");
                    if (this.getBSUStored(itemStack3) >= ConfigurationHandler.Ring_REPAIR) {
                        if (player.ticksExisted % 5 == 0)
                            this.extractBSU(itemStack3, ConfigurationHandler.Ring_REPAIR, false);
                        RepairItem(player, world);
                    }
                }
            }
        }
    }

    private void UpdatePlant(EntityPlayer player, World world) {
        if (!world.isRemote) {
            int range = 5;
            int verticalRange = 2;
            int posX = (int) Math.round(player.posX - 0.5f);
            int posY = (int) player.posY;
            int posZ = (int) Math.round(player.posZ - 0.5f);

            for (int ix = posX - range; ix <= posX + range; ix++)
                for (int iz = posZ - range; iz <= posZ + range; iz++)
                    for (int iy = posY - verticalRange; iy <= posY + verticalRange; iy++) {
                        Block block = world.getBlockState(new BlockPos(ix, iy, iz)).getBlock();
                        IBlockState state = world.getBlockState(new BlockPos(ix, iy, iz));

                        if (block instanceof IPlantable)
                            if (world.rand.nextInt(ConfigurationHandler.GrowthChance) == 0)
                                block.updateTick(world, new BlockPos(ix, iy, iz), state, world.rand);
                    }
        }
    }

    private void HarvestPlant(EntityPlayer Player, World world) {
        if (!world.isRemote) {
            int range = 5;
            int verticalRange = 2;
            int posX = (int) Math.round(Player.posX - 0.5f);
            int posY = (int) Player.posY;
            int posZ = (int) Math.round(Player.posZ - 0.5f);

            for (int ix = posX - range; ix <= posX + range; ix++)
                for (int iz = posZ - range; iz <= posZ + range; iz++)
                    for (int iy = posY - verticalRange; iy <= posY + verticalRange; iy++) {
                        BlockPos pos = new BlockPos(ix, iy, iz);
                        Block block = world.getBlockState(pos).getBlock();
                        if (block == Blocks.MELON_STEM || block == Blocks.PUMPKIN_STEM)
                            continue;
                        if (block == Blocks.MELON_BLOCK || block == Blocks.PUMPKIN) {
                            block.dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
                            world.setBlockToAir(pos);
                        }
                        if (block instanceof IGrowable && !((IGrowable) block).canGrow(world, pos, world.getBlockState(pos), true)) {
                            block.dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
                            world.setBlockState(pos, block.getDefaultState(), 2);
                        }
                    }
        }
    }

    private void RepairItem(EntityPlayer player, World world) {
        if (!world.isRemote) {
        	IInventory inv = player.inventory;
        	for (int i = 0; i < inv.getSizeInventory(); i++) {
        		ItemStack invStack = inv.getStackInSlot(i);
        		
        		if (invStack.getTagCompound() != null && invStack.getTagCompound().getTag("TinkerData") != null) {
        			invStack.setItemDamage(0);
        			continue;
        		}

        		if (invStack.isEmpty() || !invStack.getItem().isRepairable()) {
        			continue;
        		}
        		/*if (invStack.equals(player.getHeldItemMainhand()) && player.isSwingInProgress) {
                        continue;
                    }
                    if (invStack.equals(player.getHeldItemOffhand()) && player.isSwingInProgress) {
                        continue;
                    }*/
        		if (!invStack.getHasSubtypes() && invStack.getMaxDamage() != 0 && invStack.getItemDamage() > 0) {
        			invStack.setItemDamage(0);
        		}
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onBreaking(PlayerEvent.BreakSpeed event) {
    	
    	EntityPlayer player =  event.getEntityPlayer();
    	ItemStack itemStack = player.getHeldItemMainhand();
    	ItemStack itemStack1 = BaublesApi.getBaublesHandler(player).getStackInSlot(1);
    	ItemStack itemStack2 = BaublesApi.getBaublesHandler(player).getStackInSlot(2);
    	
    	if (!itemStack.isEmpty() && RingUtils.isLegalf(itemStack1, itemStack2, "Haste"))
    	{
    		ItemStack itemStack3 = RingUtils.getStackFromBoolean(itemStack1, itemStack2, "Haste");
    		if (this.getBSUStored(itemStack3) >= ConfigurationHandler.Ring_HASTE)
    		{
    			this.extractBSU(itemStack3, ConfigurationHandler.Ring_HASTE, false);
    			
    			float haste = RingUtils.getFloatFromBauble(itemStack1, itemStack2, "Haste");
    			float f = event.getOriginalSpeed();
    			
    			if (player.isInsideOfMaterial(Material.WATER) && !EnchantmentHelper.getAquaAffinityModifier(player))
    	        {
    	            f *= 5.0F;
    	        }

    	        if (!player.onGround)
    	        {
    	            f *= 5.0F;
    	        }
    			
    			if (player.world.getTileEntity(event.getPos()) != null)
    			{
    				haste /= 5;
    			}
    			
    			event.setNewSpeed(f + haste);
    		}
    	}
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onHurt(LivingHurtEvent event) {
        if (event.getSource().getImmediateSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getImmediateSource();
            ItemStack itemStack1 = BaublesApi.getBaublesHandler(player).getStackInSlot(1);
            ItemStack itemStack2 = BaublesApi.getBaublesHandler(player).getStackInSlot(2);
            if (RingUtils.isLegali(itemStack1, itemStack2, "Power")) {
                ItemStack itemStack3 = RingUtils.getStackFromBoolean(itemStack1, itemStack2, "Power");
                if (this.getBSUStored(itemStack3) >= ConfigurationHandler.Ring_POWER) {
                    this.extractBSU(itemStack3, ConfigurationHandler.Ring_POWER, false);
                    float power = (float) RingUtils.getIntFromBauble(itemStack1, itemStack2, "Power");
                    float amount = event.getAmount() + power;
                    event.setAmount(amount);
                }
            }
        }
    }


    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerLoggedInEvent(PlayerLoggedInEvent event) {
        checkForNightVision = true;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerChangedDimensionEvent(PlayerChangedDimensionEvent event) {
        checkForNightVision = true;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerLoggedOutEvent(PlayerLoggedOutEvent event) {
        checkForNightVision = true;
    }

    // This is a fun method which allows us to run some code when our item is
    // shown in a creative tab.
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> itemList)
    {
        ItemStack itemStack = new ItemStack(item);
        this.setBSUStored(itemStack, 0);
        itemList.add(itemStack);
        ItemStack itemStack1 = new ItemStack(item);
        this.setBSUStored(itemStack1, this.getMaxBSUStored(itemStack));
        itemList.add(itemStack1);
    }
}
