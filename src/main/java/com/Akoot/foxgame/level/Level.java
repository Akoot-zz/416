package com.Akoot.foxgame.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.entity.EntityLiving;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.util.Pixels;
import com.Akoot.foxgame.util.ResourceLocation;

public class Level extends DisplayObject implements RenderListener, TickListener
{
	protected Foxgame game;
	protected int size;
	protected Tile[] tiles;
	protected ArrayList<Entity> entities;
	public double gravity;

	public Level(Foxgame game)
	{
		this.game = game;
		this.entities = new ArrayList<Entity>();
		this.tiles = new Tile[0];
	}

	@Override
	public void tick()
	{
	}
	
	public void spawn(Entity entity)
	{
		this.entities.add(entity);
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
				if(pixels[i] == 0xff000000) tiles[i] = Tiles.BRICKS;
				else if(pixels[i] == 0xff0000ff) tiles[i] = Tiles.WATER;
				else if(pixels[i] == 0xff00ff00) tiles[i] = Tiles.GRASS;
				else if(pixels[i] == 0xffff0000) tiles[i] = Tiles.LAVA;
				else tiles[i] = Tiles.AIR;
			}
			for(int y = 0; y < image.getHeight(); y++)
			{
				for(int x = 0; x < image.getWidth(); x++)
				{
					int i = x + y * image.getHeight();
					tiles[i].x = (float) ((image.getWidth() * tiles[i].size / 2.0) + (x * tiles[i].size));
					tiles[i].y = (float) ((image.getHeight() * tiles[i].size / 2.0) + (y * tiles[i].size));
				}
			}
			for(int i = 0; i < 10; i++)
			{
				System.out.println("Tile " + i + ": " + tiles[i].type + " (" + tiles[i].x + "," + tiles[i].y + ")");
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
		for(int i = 0; i < size; i++)
		{
			tiles[i].render();
		}
	}

	public List<Entity> getEntities()
	{
		return entities;
	}
	
	public List<EntityLiving> getLivingEntities()
	{
		//CHEAP METHOD ONLY $1
		List<EntityLiving> living = new ArrayList<EntityLiving>();
		for(Entity e: entities) if(e instanceof EntityLiving) living.add((EntityLiving) e);
		return living;
	}
}
