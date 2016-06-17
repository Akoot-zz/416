package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.events.RenderEvent;
import com.Akoot.foxgame.event.events.TickEvent;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.Gui;
import com.Akoot.foxgame.graphics.Texture;

public class Entity implements TickListener, RenderListener
{
	protected String displayName;
	protected Foxgame game;
	protected Gui gui;
	protected Texture texture;
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
		this.texture = new Texture("assets/textures/unknown.png");
		this.x = 0;
		this.y = 0;
		this.width = 50;
		this.height = 50;
		
		/* Add event listeners */
		game.getEvents().addEventListener(TickEvent.class, this);
		game.getEvents().addEventListener(RenderEvent.class, this);
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
	
	public void rename(String newName)
	{
		this.displayName = newName;
	}
	
	public String getName()
	{
		return this.displayName;
	}
}
