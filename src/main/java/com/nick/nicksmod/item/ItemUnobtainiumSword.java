package com.nick.nicksmod.item;

import com.google.common.collect.Sets;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class ItemUnobtainiumSword extends ToolNM {
	
	public static final String NAME = "unobtainiumSword";
	
	public ItemUnobtainiumSword() {
		super(7F, -2.4F, ItemNM.UNOBTAINIUM, Sets.newHashSet(), NAME);
		this.setMaxStackSize(1);
		this.setHarvestLevel("sword", 3);
	}

	public boolean canHarvestBlock(IBlockState blockIn)
	{
		return blockIn.getBlock() == Blocks.WEB;
	}

}
