package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.input.MouseHandler;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Cursor extends DisplayObject
{
	private DisplayObject target;
	
	public Cursor()
	{
		target = null;
		setIcon(Icon.NORMAL, Color.getColor(0xffffff));
	}
	
	public void setIcon(Icon icon, Color color)
	{
		texture = icon.getTexture();
		this.color = color;
	}
	
	@Override
	public void render()
	{
		x = MouseHandler.mouseX(target);
		y = MouseHandler.mouseY(target);
		
		stage.drawTexture(x, y, 16, 16, texture);
	}
	
	public enum Icon
	{
		NORMAL("assets/textures/ui/pointer.png"),
		HOT("assets/textures/ui/pointer_hot.png"),
		SCOPE("assets/textures/ui/pointer_scope.png"),
		NONE("");
		
		Texture texture;
		
		Icon(String location)
		{
			texture = new Texture(new ResourceLocation(location));
		}
		
		public Texture getTexture()
		{
			return texture;
		}
	}
}
