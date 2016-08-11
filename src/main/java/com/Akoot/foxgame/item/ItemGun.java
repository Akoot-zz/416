package com.Akoot.foxgame.item;

import com.Akoot.foxgame.util.Animation;

public class ItemGun extends Item
{
	protected double bulletDamage;
	public int totalAmmo;
	protected int ammo;
	protected int ammoPerClip;
	protected AmmoType ammoType;
	protected Animation shootAnimation;
	protected boolean automatic;
	protected double bulletSpeed;

	private long lastShot;
	protected long msPerShot;
	protected long reloadTime;

	public boolean reloading;
	
	public ItemGun(int ammoInClip)
	{
		this.ammo = ammoInClip;
		this.meleeDamage = 25;
		this.bulletSpeed = -1;
		this.msPerShot = 500;
		this.reloadTime = 1500;
		this.shootAnimation = new Animation(2);
	}

	public ItemGun()
	{
		this(0);
	}

	public void onShoot()
	{
		//Shoot
	}

	public void shoot()
	{
		if(canShoot())
		{
			ammo -= 1;
			onShoot();
			lastShot = System.currentTimeMillis();
		}
		else
		{
			if(totalAmmo > 0 && ammo == 0) reload();
		}
	}

	public boolean canShoot()
	{
		if(ammo > 0)
		{
			if(System.currentTimeMillis() >= lastShot + msPerShot && !reloading) return true;
		}
		return false;
	}

	public void reload()
	{
		if(totalAmmo > 0)
		{
			if(!reloading && ammo < ammoPerClip)
			{
				System.out.println("Reloading...");
				reloading = true;
				if(totalAmmo >= ammoPerClip)
				{
					totalAmmo -= ammoPerClip;
					ammo = ammoPerClip;
				}
				else
				{
					ammo = totalAmmo;
					totalAmmo = 0;
				}
				reloading = false;
			}
		}
	}

	public void addAmmo(int ammo)
	{
		this.totalAmmo += ammo;
	}

	public String toString()
	{
		return "[" + this.displayname + "] "
				+ "\"" + this.description + "\"\n"
				+ "Ammo per clip: " + this.ammoPerClip + "\n"
				+ "Ammo type: " + this.ammoType + "\n"
				+ "Bullet Damage: " + this.bulletDamage + "\n"
				+ "Melee Damage: " + this.meleeDamage + "\n"
				+ "Reload Time: " + this.reloadTime + "\n"
				+ "Mode: " + (this.automatic ? "Automatic" : "Semi-Auto");
	}
}
