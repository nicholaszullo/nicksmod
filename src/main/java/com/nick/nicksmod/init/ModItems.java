package com.nick.nicksmod.init;

import java.util.ArrayList;

import com.nick.nicksmod.item.ItemAmethystGem;
import com.nick.nicksmod.item.ItemAmethystSword;
import com.nick.nicksmod.item.ItemMapleLeaf;
import com.nick.nicksmod.item.ItemNM;
import com.nick.nicksmod.item.ItemNickPick;
import com.nick.nicksmod.item.ItemUnobtainiumIngot;
import com.nick.nicksmod.item.ItemUnobtainiumPickaxe;
import com.nick.nicksmod.item.ItemUnobtainiumSword;
import com.nick.nicksmod.item.ToolNM;
import com.nick.nicksmod.reference.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/*
 * Registers items added into game registry
 * initialize item
 */

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems 
{
	public static ItemNM mapleLeaf;
	public static ItemNM amethystGem;
	public static ItemNM unobtainiumIngot;
	
	public static ToolNM unobtainiumSword;
	public static ToolNM unobtainiumPickaxe;
	public static ToolNM amethystSword;
	public static ToolNM nickPick;
	
	public static ArrayList<Item> items = new ArrayList<>();
	
	//Instantiate each item and add it to array of items
	public static void init()		
	{
		mapleLeaf = new ItemMapleLeaf();
		items.add(mapleLeaf);
		amethystGem = new ItemAmethystGem();
		items.add(amethystGem);
		unobtainiumIngot = new ItemUnobtainiumIngot();
		items.add(unobtainiumIngot);
		
		nickPick = new ItemNickPick();
		items.add(nickPick);
		amethystSword = new ItemAmethystSword();
		items.add(amethystSword);
		unobtainiumSword = new ItemUnobtainiumSword();
		items.add(unobtainiumSword);
		unobtainiumPickaxe = new ItemUnobtainiumPickaxe();
		items.add(unobtainiumPickaxe);
	}
	
	//Add each item to back end game registry when fired from forge 
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)		
	{
		
		for (Item item : items)
		{
			event.getRegistry().register(item);
		}
	}
	
	//Register the texture for each item when fired from forge
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		for (Item item : items)
		{
			registerRender(item);
		}
	}

	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		
	}
	
	
}
