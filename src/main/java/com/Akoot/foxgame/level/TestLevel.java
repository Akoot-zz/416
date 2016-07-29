package com.Akoot.foxgame.level;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.ResourceLocation;

public class TestLevel extends Level
{
	public TestLevel(Foxgame game)
	{
		super(game);
		this.game = game;
		this.generate(new ResourceLocation("assets/textures/testlevel.png"));
	}
}
