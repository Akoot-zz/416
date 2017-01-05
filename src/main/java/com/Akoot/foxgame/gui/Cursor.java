package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.input.MouseHandler;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Cursor extends DisplayObject
{
	
	private float posX, posY;
	
	public Cursor()
	{
		setIcon(Icon.NORMAL, Color.getColor(0xffffff));
	}
	
	public void setIcon(Icon icon, Color color)
	{
		this.texture = icon.getTexture();
		this.x = -(float) icon.x;
		this.y = -(float) icon.y;
		this.color = color;
	}
	
	@Override
	public void render()
	{
		renderCursor();
		posX = x + MouseHandler.mouseX();
		posY = y + MouseHandler.mouseY();
	}
	
	public void renderCursor()
	{
		stage.drawTexture(posX, posY, 16, 16, texture);
	}
	
	public enum Icon
	{
		NORMAL("assets/textures/ui/pointer.png", 0, 0),
		HOT("assets/textures/ui/pointer_hot.png", 0, 0),
		SCOPE("assets/textures/ui/pointer_scope.png", 8, 8);
		
		Texture texture;
		double x, y;
		
		Icon(String location, int x, int y)
		{
			texture = new Texture(new ResourceLocation(location));
			this.x = x;
			this.y = y;
		}
		
		public Texture getTexture()
		{
			return texture;
		}
	}
}
