package com.Akoot.foxgame.level;

import com.Akoot.foxgame.Foxgame;
<<<<<<< HEAD
import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.graphics.elements.Background;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;
import com.Akoot.foxgame.world.Tile;
=======
import com.Akoot.foxgame.util.ResourceLocation;
>>>>>>> origin/master
import com.Akoot.foxgame.world.World;

public class TestLevel extends Level
{
	public TestLevel(Foxgame game)
	{
		super(game);
		this.game = game;
<<<<<<< HEAD
		this.world = new World(100, 100);
		this.background = new Background(game, new Texture(new ResourceLocation("assets/textures/bg.png")));
		this.world.generate(new ResourceLocation("assets/textures/testlevel.png"));
		for(Tile tile: world.tiles)
		{
			System.out.println(tile.type);
		}
	}

	@Override
	public void tick()
	{
		if(entities != null)
		{
			for(Entity entity: entities)
			{
				if(entity.isSolid())
				{
					for(Tile tile: world.tiles)
					{
						if(entity.getX() < tile.x)
						{
							
						}
					}
				}
			}
		}
	}

	@Override
	public void render()
	{
		background.render();
		world.render();
=======
		this.world = new World(10);
		//this.background = new Background(new Texture(new ResourceLocation("assets/textures/bg.png")));
		this.world.generate(new ResourceLocation("assets/textures/testlevel.png"));
//		for(Tile tile: world.tiles)
//		{
//			System.out.println(tile.type);
//		}
>>>>>>> origin/master
	}
}
