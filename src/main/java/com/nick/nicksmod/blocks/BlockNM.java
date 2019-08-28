package com.nick.nicksmod.blocks;

import com.nick.nicksmod.Nicksmod;
import com.nick.nicksmod.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;  
/*
 * 	TO ADD NEW BLOCK
 * 	Each block needs to extend a generic Block class
 * 	Each block needs a .json in blockstates, block, and item
 * 	Each block needs a texture in textures.blocks
 * 	Each block needs added to ModBlocks class
 * 	Update en-us
 * 
 */

public class BlockNM extends Block
{
	public BlockNM(Material material, String name)
	{
		super(material);								//Call block constuctor
		this.setUnlocalizedName(name);					//Name with tile.nicksmod in front
		this.setRegistryName(name);						//Name in system
		this.setCreativeTab(Nicksmod.NICK_TAB);			//Add to creative tab
	}
	
	//Default for unspecified material
	public BlockNM(String name)
	{
		this(Material.ROCK, name);						//Set the material to rock and set the other properties				
	}
	

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s:%s", Reference.MODID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    //Name without tile. in front of it
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
	
    
    
}
