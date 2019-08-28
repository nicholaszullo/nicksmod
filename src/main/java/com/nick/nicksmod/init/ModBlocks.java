package com.nick.nicksmod.init;

import java.util.ArrayList;

import com.nick.nicksmod.blocks.BlockAmethystOre;
import com.nick.nicksmod.blocks.BlockNM;
import com.nick.nicksmod.blocks.BlockUnobtainiumOre;
import com.nick.nicksmod.reference.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks 
{
	public static BlockNM amethystOre;
	public static Item itemAmethystOre;
	public static BlockNM unobtainiumOre;
	public static Item itemUnobtainiumOre;
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<Item> item_blocks = new ArrayList<Item>();
	
	
	public static void init() 				//Instantiate and add each block and respective item block to arrays
	{
		amethystOre = new BlockAmethystOre();
		blocks.add(amethystOre);
		itemAmethystOre = new ItemBlock(amethystOre).setRegistryName(amethystOre.getRegistryName());
		item_blocks.add(itemAmethystOre);
		
		unobtainiumOre = new BlockUnobtainiumOre();
		blocks.add(unobtainiumOre);
		itemUnobtainiumOre = new ItemBlock(unobtainiumOre).setRegistryName(unobtainiumOre.getRegistryName());
		item_blocks.add(itemUnobtainiumOre);
	}
	
	//Register blocks to game registry when event is fired from forge BLOCKS BEFORE ITEMS
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for (Block block : blocks)
		{
			event.getRegistry().register(block);
		}
	}
	
	//Registers the item block after the block
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		for (Item item : item_blocks)
		{
			event.getRegistry().register(item);
		}
	}
	
	//Find the textures for each block
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		for (Item item : item_blocks)
		{
			registerRender(item);
		}
	}

	//ModelLoder finds the location for the texture and points game to it (Probably?)
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	
	
}
