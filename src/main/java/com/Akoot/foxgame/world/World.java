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
	protected int size;
	public Tile[] tiles;
	public Entity[] entities;
	public double gravity;
	public double x, y;

	/**
	 * @param size The size of the map
	 */
	public World(int size)
	{
		this.size = size;
		this.tiles = new Tile[size];
	}

	public void generate(ResourceLocation location)
	{
		try
		{
			BufferedImage image = ImageIO.read(new File(location.getResourcePath()));
			int[] pixels = Pixels.getPixels(image);
			this.size = pixels.length;
			tiles = new Tile[size];
			for(int i = 0; i < size; i++)
			{
				if(pixels[i] == 0xff000000) tiles[i] = Tile.getTiles()[1];
				else if(pixels[i] == 0xff0000ff) tiles[i] = Tile.getTiles()[2];
				else if(pixels[i] == 0xff00ff00) tiles[i] = Tile.getTiles()[3];
				else if(pixels[i] == 0xffff0000) tiles[i] = Tile.getTiles()[4];
				else tiles[i] = Tile.getTiles()[0];
			}
			for(int y = 0; y < image.getHeight(); y++)
			{
				for(int x = 0; x < image.getWidth(); x++)
				{
					tiles[x + y * image.getWidth()].x += x * tiles[x].size * 2;
					tiles[x + y * image.getHeight()].y += y * tiles[y].size * 2;
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
	
	public boolean hitTestPoint(double x, double y, boolean bool)
	{
		for(Tile tile: tiles)
		{
			if(tile.x == x && tile.y == y) return true;
		}
		return false;
	}

	public void render()
	{
		for(int i = 0; i < size; i++)
		{
			tiles[i].render();
		}
	}
}
