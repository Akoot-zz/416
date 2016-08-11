package com.Akoot.foxgame.entity;

import java.util.ArrayList;
import java.util.List;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.container.Inventory;
import com.Akoot.foxgame.item.Item;
import com.Akoot.foxgame.item.clothes.Clothes;
import com.Akoot.foxgame.item.hat.Hat;
import com.Akoot.foxgame.util.Animation;

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
	protected Hat hat;
	protected List<Clothes> clothing;
	protected Animation walkAnimation;
	protected Animation runAnimation;
	protected Animation jumpAnimation;
	protected Animation idleAnimation;

	public EntityLiving(Foxgame game, String displayName)
	{
		super(game, displayName);
		this.health = 100.0;
		this.maxHealth = 100.0;
		this.solid = true;
		this.inventory = new Inventory();
		this.clothing = new ArrayList<Clothes>();
		this.walkAnimation = new Animation(2);
		this.runAnimation = new Animation(2);
		this.jumpAnimation = new Animation(2);
		this.idleAnimation = new Animation(1);
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
	
	public void addItem(Item item)
	{
		inventory.addItem(item);
	}
	
	public void removeItem(Item item)
	{
		inventory.removeItem(item);
	}
	
	public void setInventory(Inventory inv)
	{
		this.inventory = inv;
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
	
	public void setHat(Hat hat)
	{
		this.hat = hat;
	}
	
	public Hat getHat()
	{
		return this.hat;
	}
	
	public void renderHat()
	{
		if(hat != null)
		{
			hat.x = x;
			hat.y = y;
			hat.scaleX = scaleX;
			hat.scaleY = scaleY;
		}
	}
	
	public void renderBody()
	{
		if(texture != null) stage.drawTexture(x, y, width * scaleX, height * scaleY, texture, color);
	}
	
	public void renderItem()
	{
		//if(mainItem != null) stage.drawTexture(x, y, 50 * scale, 50 * scale, mainItem.texture);
	}
}
