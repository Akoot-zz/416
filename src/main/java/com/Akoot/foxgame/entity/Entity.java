package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.Event;
import com.Akoot.foxgame.event.listeners.TickListener;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.level.Level;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class Entity extends DisplayObject implements TickListener
{
	protected String displayName;
	protected Foxgame game;
	protected Color color;
	public boolean onGround, onCeiling, onWallL, onWallR;
	protected double speedl, speedr;
	public double speed;
	protected double inertia;
	protected double friction;
	protected double grav;
	protected boolean solid;
	protected double lastX, lastY;
	public float startX, startY;
	protected Level level;

	public Entity(Foxgame game, String displayName)
	{
		/* Setup defaults */
		this.stage = Foxgame.stage;
		this.displayName = displayName;
		this.game = game;
		this.texture = new Texture(new ResourceLocation("assets/textures/unknown.png"));
		this.x = 0;
		this.y = 0;
		this.width = 50;
		this.height = 50;
		this.scaleX = 1;
		this.scaleY = 1;
		this.solid = true;
		this.level = game.currentLevel;

		/* Add event listeners */
		Foxgame.eventHandler.addEventListener(Event.UPDATE, this);
	}

	public void init() {}

	@Override
	public void tick() {}

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
