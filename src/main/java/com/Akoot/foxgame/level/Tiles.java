package com.Akoot.foxgame.level;

import com.Akoot.foxgame.level.Tile.Type;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;

public class Tiles
{
	public static Tile AIR = new Tile(null, Type.GAS);
	public static Tile GRASS = new Tile(new ResourceLocation("assets/textures/grass.png"), Type.SOLID);
	public static Tile BRICKS = new Tile(new ResourceLocation("assets/textures/bricks.png"), Type.SOLID, Color.getColor(0x555555));
	public static Tile WATER = new Tile(new ResourceLocation("assets/textures/water.png"), Type.LIQUID, Color.getColor(0x0084ff));
	public static Tile LAVA = new Tile(new ResourceLocation("assets/textures/water.png"), Type.LIQUID, Color.getColor(0xff3c00));
}
