package com.Akoot.foxgame.level;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.elements.Background;
import com.Akoot.foxgame.world.World;

public class Level implements RenderListener, TickListener
{
	protected Foxgame game;
	protected World world;
	protected Background background;
	
	public Level(Foxgame game)
	{
		this.game = game;
	}

	@Override
	public void tick() {}

	@Override
	public void render() {}

	public Foxgame getGame()
	{
		return game;
	}
	
	public World getWorld()
	{
		return world;
	}
}
