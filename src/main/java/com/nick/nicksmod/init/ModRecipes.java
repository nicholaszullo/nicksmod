package com.nick.nicksmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void init()
	{
		GameRegistry.addSmelting(ModBlocks.unobtainiumOre, new ItemStack(ModItems.unobtainiumIngot), 100);
	}

}
