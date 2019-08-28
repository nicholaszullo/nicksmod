package com.nick.nicksmod.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUnobtainiumOre extends BlockNM
{
	public static final String NAME = "unobtainiumOre";
	
	public BlockUnobtainiumOre()
	{
		super(NAME);
		this.setHarvestLevel("pickaxe", 3);						//Tool to break block, diamond required
		this.setHardness(40);									//How hard it is to break block
	}
	
	//When block is mined, check if it is with a diamond pick. If so, do 500 damage to pick (can mine 3 with 1 pick diamond has 1561 uses)
		//Used onBlockHarveted because it has player passed in so i can access inventory. Better way? Tried with BreakEvent but was catching every block break not just 'this'
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		if (player.inventory.getCurrentItem().getUnlocalizedName().equals(Items.DIAMOND_PICKAXE.getUnlocalizedName()))		//If the name of the current item is diamond pickaxe, damage the item
		{
			player.inventory.getCurrentItem().damageItem(500, player);
		}
	}
}
