package com.Akoot.foxgame.world;

import com.Akoot.foxgame.util.ResourceLocation;

public class World
{
	protected double width, height;
	public Tile[] tiles;

	public World(double width, double height)
	{
		this.width = width;
		this.height = height;
		tiles = new Tile[4];
	}

	public void generate(ResourceLocation location)
	{
		tiles[0] = Tile.getTiles()[1];
		tiles[1] = Tile.getTiles()[0];
		tiles[2] = Tile.getTiles()[2];
		tiles[3] = Tile.getTiles()[1];
		for(int i = 0; i < tiles.length; i++) 
		{
			tiles[i].x += (i * tiles[i].size * 2);
		}
	}

	public void render()
	{
		for(int i = 0; i < tiles.length; i++) 
		{
			tiles[i].render();
		}
	}
}
