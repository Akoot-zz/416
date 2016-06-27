package com.Akoot.foxgame.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.graphics.elements.Background;
import com.Akoot.foxgame.util.Pixels;
import com.Akoot.foxgame.util.ResourceLocation;

public class World extends DisplayObject implements RenderListener, TickListener
{
	protected Foxgame game;
	protected int size;
	protected Background background;
	public Tile[] tiles;
	public ArrayList<Entity> entities;
	public double gravity;

	public World(Foxgame game)
	{
		this.game = game;
		this.entities = new ArrayList<Entity>();
	}

	@Override
	public void tick()
	{
		//		world.tiles[0].x = game.getPlayer().x + world.tiles[0].size * 2;
		//		world.tiles[0].y = game.getPlayer().y;
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

	@Override
	public void render()
	{
		if(background != null) background.render();
		for(int i = 0; i < size; i++)
		{
			tiles[i].render();
		}
	}

	public List<Entity> getEntities()
	{
		return entities;
	}
}
