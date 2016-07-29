package com.Akoot.foxgame.item;

import com.Akoot.foxgame.util.Color;

public enum ItemRarity
{
	DEV(Color.getColor(0x55aaff), "Developer", "Item in development"),
	LEGENDARY(Color.getColor(0xbb2222), "Legendary", "Heck"),
	RARE(Color.getColor(0x4488CC), "Rare", "Pretty rare"),
	UNCOMMON(Color.getColor(0x4488CC), "Uncommon", "Kinda rare"),
	COMMON(Color.getColor(0x4488CC), "Common", "Pretty common"),
	DEFAULT(Color.getColor(0x4488CC), "Default", "Default item");
	
	private Color textColor;
	private String displayname;
	private String description;
	
	private ItemRarity(Color textColor, String displayname, String description)
	{
		this.textColor = textColor;
		this.displayname = displayname;
		this.description = description;
	}
	
	public Color getTextColor()
	{
		return this.textColor;
	}
	
	public String getName()
	{
		return this.displayname;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	@Override
	public String toString()
	{
		return this.displayname+ ": " + this.description;
	}
}
