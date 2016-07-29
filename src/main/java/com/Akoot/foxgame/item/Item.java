package com.Akoot.foxgame.item;

import com.Akoot.foxgame.graphics.DisplayObject;

public class Item extends DisplayObject
{
	protected double meleeDamage;
	protected double durability;
	protected String description;
	protected String displayname;
	protected ItemRarity rarity;
	protected int stack;
	public int amount;
	
	public Item()
	{
		this.meleeDamage = 5;
		this.rarity = ItemRarity.DEFAULT;
		this.durability = 100.0;
		this.stack = 64;
		this.amount = 1;
	}
}
