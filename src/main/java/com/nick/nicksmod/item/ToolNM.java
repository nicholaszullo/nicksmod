package com.nick.nicksmod.item;

import java.util.Set;

import com.nick.nicksmod.Nicksmod;
import com.nick.nicksmod.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ToolNM extends ItemTool
{

	protected ToolNM(float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn, Set<Block> effectiveBlocksIn, String name) 
	{
		super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocksIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Nicksmod.NICK_TAB);
		
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
