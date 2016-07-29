package com.Akoot.foxgame.item.hat;

import java.util.List;

import com.Akoot.foxgame.User;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.item.ItemRarity;

public class Hat extends DisplayObject
{
	protected ItemRarity rarity;
	protected String displayname;
	protected String description;
	protected List<User> owners;
	protected User owner;
	
	public Hat()
	{
		this.description = "A " + this.displayname + ".";
	}
}
