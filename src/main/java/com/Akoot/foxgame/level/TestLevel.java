package com.Akoot.foxgame.level;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.world.World;

public class TestLevel extends Level
{
	public TestLevel(Foxgame game)
	{
		super(game);
		this.game = game;
		this.world = new World(10);
		//this.background = new Background(new Texture(new ResourceLocation("assets/textures/bg.png")));
		this.world.generate(new ResourceLocation("assets/textures/testlevel.png"));
//		for(Tile tile: world.tiles)
//		{
//			System.out.println(tile.type);
//		}
	}
}
