package com.nick.nicksmod.item;

import com.nick.nicksmod.Nicksmod;
import com.nick.nicksmod.reference.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

/*	Base class to extend all items of mod to
 * 	Wrapper class for all common stuff for each item
 * 
 * 
 * 	TO ADD NEW ITEM 
 * 	Each item needs its own class which extends a generic version
 * 	Each item needs a .json file in assets.models.item all lower case
 * 	Each item needs a 16x16 .png file in textures.item
 * 	Each item needs added to ModItems class array
 * 	Update en-us file 
 */
public class ItemNM extends Item
{
	
	public static ToolMaterial AMETHYST, UNOBTAINIUM;
	
	//Set default properties of each item
	public ItemNM(String name) 
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Nicksmod.NICK_TAB);
		AMETHYST = EnumHelper.addToolMaterial("Amethyst", 3, 700, 7.0F, 2.5F, 14); 	
		UNOBTAINIUM = EnumHelper.addToolMaterial("Unobtainium", 4, 5000, 15.0F, 4.0F, 40);
				
	}
	
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s:%s", Reference.MODID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s:%s", Reference.MODID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    //Name without item. in front of it
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
	
    
    
    
}
