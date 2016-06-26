package com.Akoot.foxgame.world;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.Color;
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
	public Color color;

	public Tile(ResourceLocation location, Type type, Color color)
	{
		if(location != null) this.texture = new Texture(location);
		this.color = color;
		this.type = type;
		this.size = 50;
	}
	
	public void render()
	{
		if(texture != null) Foxgame.getFoxgame().gui.drawTexture(x, y, size, size, texture, (color != null ? color: Color.getColor(0xffffff)));
	}

	public static Tile[] getTiles()
	{
		return new Tile[]
		{
			new Tile(null, Type.AIR, null),
			new Tile(new ResourceLocation("assets/textures/bricks.png"), Type.GROUND, Color.getColor(0xa2492a)),
			new Tile(new ResourceLocation("assets/textures/water.png"), Type.WATER, Color.getColor(0x53bde3))
		};
	}
}
