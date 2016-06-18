package com.Akoot.foxgame.graphics.elements;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;

public class Background
{
	private Foxgame game;
	private Texture texture;
	private Color color;
	public double x, y;
	private double width, height, patternWidth, patternHeight;
	private int patternsHorizontal, patternsVertical;
	private boolean dynamic;

	public Background(Foxgame game)
	{
		this(game, game.getWidth(), game.getHeight(), null, game.getWidth(), game.getHeight(), 1, 1, Color.getColor(0xffffff));
		this.dynamic = true;
	}

	public Background(Foxgame game, Color color)
	{
		this(game, game.getWidth(), game.getHeight(), null, game.getWidth(), game.getHeight(), 1, 1, color);
		this.dynamic = true;
	}
	
	public Background(Foxgame game, Texture texture)
	{
		this(game, 0, 0, texture, game.getWidth(), game.getHeight(), 1, 1, Color.getColor(0xffffff));
		this.dynamic = true;
	}
	
	public Background(Foxgame game, Texture texture, Color color)
	{
		this(game, 0, 0, texture, game.getWidth(), game.getHeight(), 1, 1, color);
		this.dynamic = true;
	}
	
	public Background(Foxgame game, Texture texture, double patternSize, int patternHorizontal, int patternVertical, Color color)
	{
		this(game, 0, 0, texture, patternSize, patternSize, patternHorizontal, patternVertical, color);
	}
	
	public Background(Foxgame game, Texture texture, double patternWidth, double patternHeight, int patternHorizontal, int patternVertical, Color color)
	{
		this(game, 0, 0, texture, patternWidth, patternHeight, patternHorizontal, patternVertical, color);
	}
	
	public Background(Foxgame game, double width, double height)
	{
		this(game, width, height, null, width, height, 1, 1, Color.getColor(0xffffff));
	}
	
	public Background(Foxgame game, double width, double height, Color color)
	{
		this(game, width, height, null, width, height, 1, 1, color);
	}

	public Background(Foxgame game, double width, double height, Texture texture, double patternWidth, double patternHeight, int patternsHorizontal, int patternsVertical,  Color color)
	{
		this.game = game;
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
		if(dynamic)
		{
			width = game.getWidth();
			height = game.getHeight();
			patternWidth = game.getWidth();
			patternHeight = game.getHeight();
		}
		if(texture != null)
		{
			for(int xx = 0; xx < patternsHorizontal; xx++)
			{
				for(int yy = 0; yy < patternsVertical; yy++)
				{
					game.gui.drawTexture(x + patternWidth * xx * 2, y + patternHeight * yy * 2, patternWidth, patternHeight, texture, color);
				}
			}
		}
		else game.gui.drawRect(x, y, width, height, color);
	}
}
