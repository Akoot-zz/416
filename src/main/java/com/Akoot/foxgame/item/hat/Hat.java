package com.Akoot.foxgame.item.hat;

import java.util.List;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.User;
import com.Akoot.foxgame.graphics.DisplayObject;
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
		this.width = 100;
		this.height = 100;
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
		stage.drawTexture(x - (width * scaleX / 4), y - height * scaleY / 2, width * scaleX, height * scaleY, texture_c, color);
		stage.drawTexture(x - (width * scaleX / 4), y - height * scaleY / 2, width * scaleX, height * scaleY, texture_v);
		
		stage.drawRect(x, y, width, height, Color.getColor(0xff0000));

		if(this.hitTestPoint(Foxgame.getFoxgame().camera.mouseX(), Foxgame.getFoxgame().camera.mouseY()))
		{
			stage.drawRect((float) Foxgame.getFoxgame().camera.mouseX(), (float) Foxgame.getFoxgame().camera.mouseY(), 20F, 20F, color);
		}
	}
}
