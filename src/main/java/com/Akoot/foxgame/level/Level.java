package com.Akoot.foxgame.level;

import java.util.ArrayList;
import java.util.List;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.elements.Background;
import com.Akoot.foxgame.world.Tile;
import com.Akoot.foxgame.world.World;

public class Level implements RenderListener, TickListener
{
	protected Foxgame game;
	public World world;
	protected Background background;
	protected List<Entity> entities;

	public Level(Foxgame game)
	{
		this.game = game;
		this.entities = new ArrayList<Entity>();
	}

	@Override
	public void tick()
	{
		world.tiles[0].x = game.getPlayer().x + world.tiles[0].size * 2;
		world.tiles[0].y = game.getPlayer().y;
		for(Tile tile: world.tiles)
		{
			if(tile.isSolid())
			{
				for(Entity entity: this.entities)
				{
					if(entity.isSolid())
					{
						if(entity.y + entity.height * 2 == tile.y) entity.onGround = true;
						else entity.onGround = false;
					}
				}
			}
		}

	}

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

	public List<Entity> getEntities()
	{
		return entities;
	}
}
