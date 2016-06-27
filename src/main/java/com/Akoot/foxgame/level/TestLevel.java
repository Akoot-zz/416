package com.Akoot.foxgame.level;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.graphics.elements.Background;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class TestLevel extends World
{
	public TestLevel(Foxgame game)
	{
		super(game);
		this.game = game;
		this.background = new Background(new Texture(new ResourceLocation("assets/textures/bg.png")));
		this.generate(new ResourceLocation("assets/textures/testlevel.png"));
	}
}
