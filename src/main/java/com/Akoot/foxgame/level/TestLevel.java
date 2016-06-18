package com.Akoot.foxgame.level;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.graphics.elements.Background;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;
import com.Akoot.foxgame.world.World;

public class TestLevel extends Level
{
	public TestLevel(Foxgame game)
	{
		super(game);
		this.world = new World(100, 100);
		this.background = new Background(game, new Texture(new ResourceLocation("assets/textures/bricks.png")), 200, 5, 5, Color.getColor(0xffffff));
	}
	
	public void render()
	{
		background.render();
	}
}
