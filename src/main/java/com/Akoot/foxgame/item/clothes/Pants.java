package com.Akoot.foxgame.item.clothes;

import com.Akoot.foxgame.item.ItemRarity;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Pants extends Clothes
{
	public Pants()
	{
		this.displayname = "Pants";
		this.description = "a pants";
		this.rarity = ItemRarity.COMMON;
		this.texture_c = new Texture(new ResourceLocation("assets/textures/entity/player/%s/idle_c.png".replaceAll("%s", getClass().getSimpleName())));
	}
}
