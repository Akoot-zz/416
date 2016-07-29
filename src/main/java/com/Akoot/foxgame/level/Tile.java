package com.Akoot.foxgame.level;

import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Tile extends DisplayObject
{
	public enum Type
	{
		SOLID,
		LIQUID,
		GAS
	}

	private Texture texture;
	private Color color;
	public Type type;
	public double size;

	public Tile(ResourceLocation location, Type type)
	{
		this(location, type, Color.getColor(0xffffff), 50);
	}
	public Tile(ResourceLocation location, Type type, double size)
	{
		this(location, type, Color.getColor(0xffffff), size);
	}
	
	public Tile(ResourceLocation location, Type type, Color color)
	{
		this(location, type, color, 50);
	}
	
	public Tile(ResourceLocation location, Type type, Color color, double size)
	{
		if(location != null) this.texture = new Texture(location);
		this.color = color;
		this.size = size;
		this.width = size;
		this.height = size;
		this.type = type;
	}
	
	@Override
	public void render()
	{
		//if(texture != null) Foxgame.getFoxgame().gui.drawTexture(x, y, size, size, texture, (color != null ? color: Color.getColor(0xffffff)));
	}
	
	public boolean isSolid()
	{
		return type == Type.SOLID;
	}
	
	public boolean isLiquid()
	{
		return type == Type.LIQUID;
	}
	
	@Override
	public String toString()
	{
		return String.format("(%s,%s) %s", x, y);
	}
}
