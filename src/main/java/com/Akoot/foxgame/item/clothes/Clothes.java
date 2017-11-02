package com.Akoot.foxgame.item.clothes;

import java.util.List;

import com.Akoot.foxgame.User;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.item.ItemRarity;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;

public class Clothes extends DisplayObject
{
	protected ItemRarity rarity;
	protected String displayname;
	protected String description;
	protected List<User> owners;
	protected User owner;
	protected Color color;
	protected Texture texture_v;
	protected Texture texture_c;
	
	public static final Hair defaultHair = new Hair("1");
	public static final Shirt defaultShirt = new Shirt();
	public static final Pants defaultPants = new Pants();
	public static final Boots defaultShoes = new Boots();

	public Clothes()
	{
		this.width = 100;
		this.height = 100;
		this.color = Color.getColor(0xffffff);
		//this.texture_c = new Texture(new ResourceLocation("assets/textures/entity/player/%s/idle_c.png".replaceAll("%s", getClass().getSimpleName())));
		//this.texture_v = new Texture(new ResourceLocation("assets/textures/entity/player/%s/idle_v.png".replaceAll("%s", getClass().getSimpleName())));
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}
	
	@Override
	public void render()
	{
		stage.drawTexture(x - (scaleX < 0 ? width * scaleX : 0), y, width * scaleX, height * scaleY, texture_c, color);
		//stage.drawTexture(x, y - height / 2, width, height, texture_v);
	}
}
