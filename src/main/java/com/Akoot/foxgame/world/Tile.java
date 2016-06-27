package com.Akoot.foxgame.world;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Tile
{
	public enum Type
	{
		BRICKS,
		GRASS,
		WATER,
		LAVA,
		AIR
	}

	private Texture texture;
	public Type type;
	public int x, y, size;
	public Color color;
	private boolean solid;

	public Tile(ResourceLocation location, Type type, boolean solid, Color color)
	{
		if(location != null) this.texture = new Texture(location);
		this.color = color;
		this.type = type;
		this.size = 50;
		this.solid = solid;
	}
	
	public void render()
	{
		if(texture != null && type != Type.AIR) Foxgame.getFoxgame().gui.drawTexture(x, y, size, size, texture, (color != null ? color: Color.getColor(0xffffff)));
	}

	public static Tile[] getTiles()
	{
		return new Tile[]
		{
			new Tile(null, Type.AIR, false, null),
			new Tile(new ResourceLocation("assets/textures/bricks.png"), Type.BRICKS, true, Color.getColor(0xa2492a)),
			new Tile(new ResourceLocation("assets/textures/water.png"), Type.WATER, false, Color.getColor(0x53bde3)),
			new Tile(new ResourceLocation("assets/textures/grass.png"), Type.GRASS, true, Color.getColor(0x5ec03c)),
			new Tile(new ResourceLocation("assets/textures/water.png"), Type.LAVA, false, Color.getColor(0xff4200))
		};
	}
	
	public boolean isSolid()
	{
		return solid;
	}
	
	@Override
	public String toString()
	{
		return String.format("(%s,%s) %s", x, y, type);
	}
}
