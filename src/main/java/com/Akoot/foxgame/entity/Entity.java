package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.Event;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.Gui;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;
import com.Akoot.foxgame.world.World;

public class Entity implements TickListener, RenderListener
{
	protected String displayName;
	protected Foxgame game;
	protected Gui gui;
	protected World world;
	protected ResourceLocation textureLocation;
	protected Texture texture;
	protected Color color;
	protected double x;
	protected double y;
	protected double width;
	protected double height;

	public Entity(Foxgame game, String displayName)
	{
		/* Setup defaults */
		this.displayName = displayName;
		this.game = game;
		this.gui = game.gui;
		this.world = game.getCurrentLevel().getWorld();
		this.textureLocation = new ResourceLocation("assets/textures/unknown.png");
		this.texture = new Texture(textureLocation);
		this.x = 0;
		this.y = 0;
		this.width = 50;
		this.height = 50;

		/* Add event listeners */
		game.getEvents().addEventListener(Event.UPDATE, this);
		game.getEvents().addEventListener(Event.ENTER_FRAME, this);
	}

	public void init() {}

	@Override
	public void tick() {}

	@Override
	public void render() {}

	public void setTexture(Texture texture)
	{
		this.texture = texture;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public void rename(String newName)
	{
		this.displayName = newName;
	}

	public String getName()
	{
		return this.displayName;
	}
}
