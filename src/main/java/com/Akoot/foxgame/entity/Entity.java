package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.Event;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.graphics.Gui;
import com.Akoot.foxgame.level.World;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Entity extends DisplayObject implements TickListener, RenderListener
{
	protected String displayName;
	protected Foxgame game;
	protected Gui gui;
	protected ResourceLocation textureLocation;
	protected Texture texture;
	protected Color color;
	public boolean onGround, onCeiling, onWallL, onWallR;
	protected double speedl, speedr;
	public double speed;
	protected double inertia;
	protected double grav;
	protected boolean solid;
	protected double lastX, lastY;
	public double startX, startY;
	protected World level;

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
		this.level = game.getCurrentLevel();

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

	public boolean isSolid()
	{
		return this.solid;
	}
}
