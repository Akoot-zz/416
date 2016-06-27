package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.Event;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.Gui;
import com.Akoot.foxgame.level.Level;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Position;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Entity implements TickListener, RenderListener
{
	protected String displayName;
	protected Foxgame game;
	protected Gui gui;
	protected ResourceLocation textureLocation;
	protected Texture texture;
	protected Color color;
	public double x;
	public double y;
	public double width;
	public double height;
	protected boolean solid;
	protected Level level;
	public double speed;

	public Entity(Foxgame game, String displayName)
	{
		/* Setup defaults */
		this.displayName = displayName;
		this.game = game;
		this.gui = game.gui;
		this.textureLocation = new ResourceLocation("assets/textures/unknown.png");
		this.texture = new Texture(textureLocation);
		this.x = 0;
		this.y = 0;
		this.width = 50;
		this.height = 50;
		this.solid = true;

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

	public Position getPosition()
	{
		return new Position(this.x, this.y);
	}

	public void setPosition(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void setSolid(boolean b)
	{
		this.solid = b;
	}

	public boolean isSolid()
	{
		return this.solid;
	}

	public boolean hitTestPoint(double x, double y)
	{
		if(this.x == x && this.y == y) return true;
		return false;
	}

	public boolean hitTest(double x, double y, double width, double height)
	{
		return false;
	}
}
