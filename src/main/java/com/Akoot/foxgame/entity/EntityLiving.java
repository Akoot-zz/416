package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.container.Inventory;
import com.Akoot.foxgame.item.Item;

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
	protected Item mainItem;

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
	
	@Override
	public void render()
	{
		renderBody();
		renderHat();
		renderItem();
	}
	
	public void renderHat()
	{
	}
	
	public void renderBody()
	{
	}
	
	public void renderItem()
	{
	}
}
