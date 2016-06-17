package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.container.Inventory;

public class EntityLiving extends Entity
{
	protected double health;
	protected double maxHealth;
	protected double money;
	protected Inventory inventory;
	
	public EntityLiving(Foxgame game, String displayName)
	{
		super(game, displayName);
		this.health = 100.0;
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
}
