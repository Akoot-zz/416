package com.Akoot.foxgame.world;

import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.util.ResourceLocation;

public class World
{
	protected int size;
	public Tile[] tiles;
	public Entity[] entities;

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
		for(int i = 0; i < size; i++)
		{
			tiles[i] = Tile.getTiles()[1];
			tiles[i].x += tiles[i].size * 2 * i;
			tiles[i].y += tiles[i].size * 2 * i;
		}
//		try
//		{
//			BufferedImage image = ImageIO.read(location.getFile());
//			this.size = (image.getHeight() + image.getWidth());
//			int[] pixels = Pixels.getPixels(image);
//			int i = 0;
//			for(int pixel: pixels)
//			{
//				Tile tile = Tile.getTiles()[0];
//				if(pixel == 0x000000) tile =  Tile.getTiles()[1];
//				tiles[i] = tile;
//				i++;
//			}
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}

	public void generateRandom()
	{

	}

	public void render()
	{
		for(Tile tile: tiles)
		{
			if(tile != null) tile.render();
		}
	}
}
