package com.nick.nicksmod.blocks;

import java.util.Random;

import com.nick.nicksmod.init.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;


public class BlockAmethystOre extends BlockNM 
{
	public static final String NAME = "amethystOre";
	public BlockAmethystOre()
	{
		super(NAME);
		this.setHarvestLevel("pickaxe", 2);						//Tool to break block, iron required
		this.setHardness(2);									//How hard it is to break block
	}
	
	
	//Overrides the method in Block Class, drops the gem instead of default of ore
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 	
	{
		return ModItems.amethystGem;
	}
	
	
	//Overrides default block of returning 0 xp to values from breaking ore (3,7 for diamond, 0,2 for coal, 2,5 for quartz)
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
	{
		return MathHelper.getInt(new Random(), 2, 5);
	}
	
}
