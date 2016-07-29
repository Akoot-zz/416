package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class EntityPlayer extends EntityLiving
{
	private double hunger;

	public EntityPlayer(Foxgame game, String username)
	{
		super(game, username);
		this.texture = new Texture(new ResourceLocation("assets/textures/player.png"));
		this.height = 50;
		this.width = 50;
		this.speed = 8;
		this.jumpHeight = 8;
	}

	@Override
	public void init()
	{
		startX = 200;
		startY = 200;
		reset();
	}

	public void reset()
	{
		this.x = startX;
		this.y = startY;
		health = 100;
		speedl = 0;
		speedr = 0;
		grav = 0;
	}

	@Override
	public void tick()
	{
	}

	@Override
	public void render()
	{
	}

	public double getHunger()
	{
		return hunger;
	}
}
