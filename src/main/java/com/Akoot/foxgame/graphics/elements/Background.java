package com.Akoot.foxgame.graphics.elements;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;

public class Background
{
	private Texture texture;
	private Color color;
	public double x, y;
	private double width, height, patternWidth, patternHeight;
	private int patternsHorizontal, patternsVertical;

	public Background(Color color)
	{
		this(0, 0, null, Foxgame.getFoxgame().getWidth(), Foxgame.getFoxgame().getHeight(), 1, 1, color);
	}
	
	public Background(Texture texture)
	{
		this(0, 0, texture, texture.width, texture.height, 1, 1, Color.getColor(0xffffff));
	}
	
	public Background(Texture texture, Color color)
	{
		this(0, 0, texture, Foxgame.getFoxgame().getWidth(), Foxgame.getFoxgame().getHeight(), 1, 1, color);
	}
	
	public Background(Texture texture, double patternSize, int patternHorizontal, int patternVertical, Color color)
	{
		this(0, 0, texture, patternSize, patternSize, patternHorizontal, patternVertical, color);
	}
	
	public Background(Texture texture, double patternWidth, double patternHeight, int patternHorizontal, int patternVertical, Color color)
	{
		this(0, 0, texture, patternWidth, patternHeight, patternHorizontal, patternVertical, color);
	}
	
	public Background(double width, double height)
	{
		this(width, height, null, width, height, 1, 1, Color.getColor(0xffffff));
	}
	
	public Background(double width, double height, Color color)
	{
		this(width, height, null, width, height, 1, 1, color);
	}

	public Background(double width, double height, Texture texture, double patternWidth, double patternHeight, int patternsHorizontal, int patternsVertical,  Color color)
	{
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.color = color;
		this.patternHeight = patternHeight;
		this.patternWidth = patternWidth;
		this.patternsHorizontal = patternsHorizontal;
		this.patternsVertical = patternsVertical;
	}

	public void render()
	{
		if(texture != null)
		{
			for(int xx = 0; xx < patternsHorizontal; xx++)
			{
				for(int yy = 0; yy < patternsVertical; yy++)
				{
					Foxgame.getFoxgame().gui.drawTexture(x + patternWidth * xx * 2, y + patternHeight * yy * 2, patternWidth, patternHeight, texture, color);
				}
			}
		}
		else Foxgame.getFoxgame().gui.drawRect(x, y, width, height, color);
	}
}
