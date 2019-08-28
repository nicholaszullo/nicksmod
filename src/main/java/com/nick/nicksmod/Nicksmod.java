package com.nick.nicksmod;

import org.apache.logging.log4j.Logger;

import com.nick.nicksmod.creativetab.CreativeTab;
import com.nick.nicksmod.handler.ConfigurationHandler;
import com.nick.nicksmod.init.ModBlocks;
import com.nick.nicksmod.init.ModItems;
import com.nick.nicksmod.init.ModRecipes;
import com.nick.nicksmod.proxy.IProxy;
import com.nick.nicksmod.reference.Reference;
import com.nick.nicksmod.worldgen.OreGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Nicksmod
{
	
    private static Logger logger;
    
    @Mod.Instance(Reference.MODID)
    public static Nicksmod instance;
    
    public static final CreativeTabs NICK_TAB = new CreativeTab("nicksmod");				//Create the creative tab instance
    
    @SidedProxy(modId = Reference.MODID, clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    
 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());			//Create the config file
        ModBlocks.init();															//Initialize blocks
        ModItems.init();															//Initialize items
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.registerWorldGenerator(new OreGen(), 0);
    	ModRecipes.init();															//Smelting recipies, crafting is made with .json file
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    
}
