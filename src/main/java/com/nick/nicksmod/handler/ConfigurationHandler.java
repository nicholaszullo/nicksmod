package com.nick.nicksmod.handler;

import java.io.*;

import com.nick.nicksmod.reference.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler 
{
	public static Configuration config;
	public static boolean testValue = false;
	
	public static void init(File configFile) 
	{
		if (config == null) {
			config = new Configuration(configFile);				//Create config object from configFile
			loadConfiguration();
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) 
	{
		if (event.getModID().equalsIgnoreCase(Reference.MODID)) 
		{
			//Resync configs
			ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
		}
		
	}
	
	public static void loadConfiguration() 
	{
		testValue = config.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "Example config value");
		
		if (config.hasChanged()) 
		{
			config.save();
		}
		
	}
}
