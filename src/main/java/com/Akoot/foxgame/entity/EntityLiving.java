package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.container.Inventory;

public class EntityLiving extends Entity
{
	protected double health;
	protected double maxHealth;
	protected double money;
	protected Inventory inventory;
	protected boolean jump;
	protected boolean canJump;
	protected boolean dead;
	protected boolean crouching;
	protected double jumpHeight;

	public EntityLiving(Foxgame game, String displayName)
	{
		super(game, displayName);
		this.health = 100.0;
		this.maxHealth = 100.0;
		this.solid = true;
	}

	protected void crouch(boolean crouch)
	{
		if (crouch)
		{
			crouching = true;
			if (onGround)
			{
				this.y += 8;
			}
			else
			{
				//this.y -= 4;
			}
		}
		else
		{
			crouching = false;
		}
	}

	public double getHealth()
	{
		return health;
	}

	public double getMaxHealth()
	{
		return maxHealth;
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public void setHealth(double health)
	{
		if(health > maxHealth) maxHealth = health;
		this.health = health;
	}

	public void setMaxHealth(double maxHealth)
	{
		this.maxHealth = health;
	}

	public void chat(String msg)
	{
		System.out.println(displayName + ": " + msg);
	}

	public boolean isDead()
	{
		return dead;
	}
	
	protected void checkCollision()
	{
		lastX = this.x;
		lastY = this.y;

		onCeiling = false;
		onGround = false;
		onWallL = false;
		onWallR = false;
		canJump = true;

		while (level.world.hitTestPoint(this.x, this.y + this.height - 1, true) || level.world.hitTestPoint(this.x - this.width / 2, this.y + this.height - 1, true) || level.world.hitTestPoint(this.x + this.width / 2, this.y + this.height - 1, true)) //bottom
		{
			jump = false;
			this.y -= 0.5;
			grav = 0;
			onGround = true;
		}
		while (level.world.hitTestPoint(this.x, this.y - this.height - 0.5, true) || level.world.hitTestPoint(this.x - this.width / 2, this.y - this.height - 0.5, true) || level.world.hitTestPoint(this.x + this.width / 2, this.y - this.height - 0.5, true)) //top
		{
			onCeiling = true;
			jump = false;
			this.y += 0.5;
			grav = 0;
		}
		while (level.world.hitTestPoint(this.x - this.width + 0.5, this.y - this.height / 2, true) || level.world.hitTestPoint(this.x - this.width + 0.5, this.y, true) || level.world.hitTestPoint(this.x - this.width + 0.5, this.y + this.height / 2, true)) //left
		{
			speedl = 0;
			this.x += 0.1;
			onWallL = true;
		}
		while (level.world.hitTestPoint(this.x + this.width - 0.5, this.y - this.height / 2, true) || level.world.hitTestPoint(this.x + this.width - 0.5, this.y, true) || level.world.hitTestPoint(this.x + this.width - 0.5, this.y + this.height / 2, true)) //right
		{
			speedr = 0;
			this.x -= 0.1;
			onWallR = true;
		}
		if ((onGround && onCeiling) || (onWallL && onWallR))
		{
			health = 0;
		}
		while (!crouching && onGround && ((level.world.hitTestPoint(this.x, this.y - this.height - 1, true) || level.world.hitTestPoint(this.x - this.width + 1, this.y - this.height - 1, true) || level.world.hitTestPoint(this.x + this.width - 1, this.y - this.height - 1, true))))
		{
			canJump = false;
			this.y -= 8;
			crouch(true);
		}
	}
}
