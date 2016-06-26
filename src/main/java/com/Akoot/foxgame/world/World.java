package com.Akoot.foxgame.world;

<<<<<<< HEAD
=======
import com.Akoot.foxgame.entity.Entity;
>>>>>>> origin/master
import com.Akoot.foxgame.util.ResourceLocation;

public class World
{
<<<<<<< HEAD
	protected double width, height;
	public Tile[] tiles;

	public World(double width, double height)
	{
		this.width = width;
		this.height = height;
		tiles = new Tile[4];
=======
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
>>>>>>> origin/master
	}

	public void generate(ResourceLocation location)
	{
<<<<<<< HEAD
		tiles[0] = Tile.getTiles()[1];
		tiles[1] = Tile.getTiles()[0];
		tiles[2] = Tile.getTiles()[2];
		tiles[3] = Tile.getTiles()[1];
		for(int i = 0; i < tiles.length; i++) 
		{
			tiles[i].x += (i * tiles[i].size * 2);
		}
=======
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

>>>>>>> origin/master
	}

	public void render()
	{
<<<<<<< HEAD
		for(int i = 0; i < tiles.length; i++) 
		{
			tiles[i].render();
=======
		for(Tile tile: tiles)
		{
			if(tile != null) tile.render();
>>>>>>> origin/master
		}
	}
}
