/*
 * This class (UpgradeExtractor.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.blocks;

import baubles.api.IBauble;
import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.common.energy.BaubleBSUContainer;
import md.zazpro.mod.common.tileentity.TEExtractor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class UpgradeExtractor extends BlockContainer {
    public UpgradeExtractor() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTab.tabBaublesStuff);
        this.setHardness(1.0F);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
    	final ItemStack heldItem = player.getHeldItem(hand);
        
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        
        if (heldItem != null && heldItem.getItem() instanceof IBauble && heldItem.hasTagCompound()) {
            if (heldItem.hasTagCompound() && heldItem.getItem() instanceof BaubleBSUContainer) {
                if (!world.isRemote)
                    for (int i = 0; i < heldItem.getTagCompound().getTagList("ItemStacksInBauble", Constants.NBT.TAG_COMPOUND).tagCount(); i++)
                        world.spawnEntity(new EntityItem(world, x, y, z, new ItemStack(heldItem.getTagCompound().getTagList("ItemStacksInBauble", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i))));
                int energy = ((BaubleBSUContainer) player.getHeldItemMainhand().getItem()).getBSUStored(player.getHeldItemMainhand());
                ItemStack itemStack = new ItemStack(player.getHeldItemMainhand().getItem(), player.getHeldItemMainhand().getMaxStackSize(), player.getHeldItemMainhand().getItemDamage());
                ((BaubleBSUContainer) itemStack.getItem()).setBSUStored(itemStack, energy);
                itemStack.getItem().getDurabilityForDisplay(itemStack);
                player.inventory.setInventorySlotContents(player.inventory.currentItem, itemStack);
                return true;
            }
        }
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TEExtractor();
    }
}


