package com.Akoot.foxgame.item.hat;

import java.util.List;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.User;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.input.MouseHandler;
import com.Akoot.foxgame.item.ItemRarity;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Hat extends DisplayObject
{
	protected ItemRarity rarity;
	protected String displayname;
	protected String description;
	protected List<User> owners;
	protected User owner;
	protected Color color;
	protected Texture texture_v;
	protected Texture texture_c;
	
	public Hat()
	{
		this.width = 50;
		this.height = 50;
		this.color = Color.getColor(0xffffff);
		this.texture_c = new Texture(new ResourceLocation("assets/textures/items/hats/%s/%s_c.png".replaceAll("%s", getClass().getSimpleName())));
		this.texture_v = new Texture(new ResourceLocation("assets/textures/items/hats/%s/%s_v.png".replaceAll("%s", getClass().getSimpleName())));
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
		x = x - (scaleX < 0 ? width * scaleX : 0);
		y = y - (scaleY < 0 ? height * scaleY : 0);
		stage.drawTexture(x, y, 100 * scaleX, 100 * scaleY, texture_c, color);
		stage.drawTexture(x, y, 100 * scaleX, 100 * scaleY, texture_v);
		
		//Draw hitbox
		stage.drawRect(x, y, width, height, Color.getColor(0xff0000, 0.5));

		Foxgame.getFoxgame();
		if(this.hitTestPoint(MouseHandler.mouseX(), MouseHandler.mouseY()))
		{
			Foxgame.getFoxgame();
			stage.drawRect((float) MouseHandler.mouseX(), (float) MouseHandler.mouseY(), 20F, 20F, color);
		}
	}
}
