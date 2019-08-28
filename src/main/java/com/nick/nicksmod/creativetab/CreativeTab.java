package com.nick.nicksmod.creativetab;

import com.nick.nicksmod.init.ModItems;
import com.nick.nicksmod.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab extends CreativeTabs
{
	public CreativeTab(String name) {
		super(Reference.MODID+"."+name);						//Name of creative tab in system
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem()							//Image displayed on creative tab
	{
		return new ItemStack(ModItems.mapleLeaf);
	}
	
	public String getTranslatedTabLabel()						//Name of tab when hovered over
	{
		return "Nick's Mod";
	}
}
