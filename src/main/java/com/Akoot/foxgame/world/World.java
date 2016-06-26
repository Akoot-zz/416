package com.Akoot.foxgame.world;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.util.Pixels;
import com.Akoot.foxgame.util.ResourceLocation;

public class World
{
	protected int width, height;
	public Tile[][] tiles;
	public Entity[] entities;

	/**
	 * @param size The size of the map
	 */
	public World(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
	}

	public void generate(ResourceLocation location)
	{
		try
		{
			BufferedImage image = ImageIO.read(new File(location.getResourcePath()));
			this.width = image.getWidth();
			this.height = image.getHeight();
			int[][] pixels = Pixels.getPixels(image);
			for(int row = 0; row < image.getWidth(); row++)
			{
				for(int col = 0; col < image.getHeight(); col++)
				{
					
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void generateRandom()
	{

	}

	public void render()
	{
	}
}
