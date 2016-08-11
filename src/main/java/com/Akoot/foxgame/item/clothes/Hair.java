package com.Akoot.foxgame.item.clothes;

import com.Akoot.foxgame.item.ItemRarity;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Hair extends Clothes
{
	public Hair(String name)
	{
		this.displayname = name;
		this.description = "Hair of type \"" + name + "\"";
		this.rarity = ItemRarity.DEFAULT;
		this.texture_c = new Texture(new ResourceLocation("assets/textures/entity/player/hair_%s/idle_c.png".replaceAll("%s", name)));
	}
}
