package md.zazpro.mod.common.items;

import java.util.List;

import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import md.zazpro.mod.helper.NBTHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.World;

public class Exp_Stuff extends Item {
    Exp_Stuff() {
        super();
        setUnlocalizedName("Exp_Stuff");
        setRegistryName("Exp_Stuff");
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }

    @Override
    public void addInformation(ItemStack itemStack, World worldIn, List<String> list, ITooltipFlag p_77624_4_) {
        list.add(TextFormatting.DARK_GREEN + I18n.format("tooltip.Exp_Stuff") + ": " + NBTHelper.getInteger(itemStack, "expLVL"));
        list.add(TextFormatting.DARK_RED + I18n.format("tooltip.Exp_Stuff.warning"));
        list.add(TextFormatting.WHITE + I18n.format("tooltip.Exp_Stuff.info"));
        list.add(TextFormatting.AQUA + I18n.format("tooltip.Exp_Stuff.info.energy"));
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        if (!stack.hasTagCompound()) {
            NBTHelper.setInteger(stack, "expLVL", 0);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
    	final ItemStack itemStack = player.getHeldItem(hand);
    	
        if (!world.isRemote) {
            if (itemStack.hasTagCompound()) {
                int lvlPlayer = player.experienceLevel;
                int lvlItem = NBTHelper.getInteger(itemStack, "expLVL");
                //player.removeExperienceLevel(lvlPlayer);
                player.addExperienceLevel(lvlItem);
                NBTHelper.setInteger(itemStack, "expLVL", lvlPlayer);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	final ItemStack itemStack = player.getHeldItem(hand);
    	
        if (!world.isRemote) {
            if (itemStack.hasTagCompound()) {
                if (world.getTileEntity(pos) instanceof TEExpGenerator) {
                    TEExpGenerator te = (TEExpGenerator) world.getTileEntity(pos);
                    int lvlItem = NBTHelper.getInteger(itemStack, "expLVL");
                    int lvlTe = te.getLvlStored();
                    te.setLvlStored(lvlItem);
                    NBTHelper.setInteger(itemStack, "expLVL", lvlTe);
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }
}

