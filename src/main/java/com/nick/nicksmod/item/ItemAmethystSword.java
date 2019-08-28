package com.nick.nicksmod.item;

import com.google.common.collect.Sets;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class ItemAmethystSword extends ToolNM
{
	public static final String NAME = "amethystSword";
	
	public ItemAmethystSword()
	{
		super(3F, -2.4F, ItemNM.AMETHYST, Sets.newHashSet(), NAME);
		this.setMaxStackSize(1);
		this.setHarvestLevel("sword", 2);
	}
	
	public boolean canHarvestBlock(IBlockState blockIn)
	{
		return blockIn.getBlock() == Blocks.WEB;
	}
}
