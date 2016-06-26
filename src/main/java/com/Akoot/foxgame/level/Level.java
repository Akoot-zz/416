package com.Akoot.foxgame.level;

import java.util.ArrayList;
import java.util.List;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.elements.Background;
import com.Akoot.foxgame.world.World;

public class Level implements RenderListener, TickListener
{
	protected Foxgame game;
	protected World world;
	protected Background background;
	protected List<Entity> entities;
	
	public Level(Foxgame game)
	{
		this.game = game;
		this.entities = new ArrayList<Entity>();
	}

	@Override
	public void tick() {}

	@Override
	public void render()
	{
		if(this.background != null) this.background.render();
		this.world.render();
	}

	public Foxgame getGame()
	{
		return game;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	public List<Entity> getEntities()
	{
		return entities;
	}
}
