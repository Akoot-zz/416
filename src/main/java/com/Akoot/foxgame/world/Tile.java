package com.Akoot.foxgame.world;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Tile
{
	public enum Type
	{
		GROUND,
		WALL,
		WATER,
		AIR
	}

	private Texture texture;
	public Type type;
	public int x, y, size;

	public Tile(ResourceLocation location, Type type)
	{
		if(location != null) this.texture = new Texture(location);
		this.type = type;
		this.size = 100;
	}
	
	public void render()
	{
		if(texture != null) Foxgame.getFoxgame().gui.drawTexture(x, y, size, size, texture);
	}

	public static Tile[] getTiles()
	{
		return new Tile[]
		{
			new Tile(null, Type.AIR),
			new Tile(new ResourceLocation("assets/textures/bricks.png"), Type.GROUND),
			new Tile(null, Type.WATER)
		};
	}
}
