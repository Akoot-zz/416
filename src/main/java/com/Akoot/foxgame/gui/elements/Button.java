package com.Akoot.foxgame.gui.elements;

import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;

public class Button extends GuiElement
{
	protected Texture texture;
	protected Color color;
	protected String label;
	protected String hint;
	
	public Button(String text)
	{
		
	}
	
	@Override
	public void render()
	{
		if(texture != null) stage.drawTexture(x, y, width, height, texture);
		else stage.drawRect(x, y, width, height, color);
		
		if(label != null) stage.drawString(label, x, y, height);
		
		if(mouseHover()) onHover();
	}
	
	public void onHover()
	{
		
	}
	
	public void onClick() {}
}
