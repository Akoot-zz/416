package com.Akoot.foxgame.items.guns;

import com.Akoot.foxgame.item.AmmoType;
import com.Akoot.foxgame.item.ItemGun;
import com.Akoot.foxgame.util.Animation;

public class Revolver extends ItemGun
{
	public Revolver()
	{
		this.displayname = "Revolver";
		this.ammoType = AmmoType.REVOLVER;
		this.bulletDamage = 55.0;
		this.ammoPerClip = 6;
		this.msPerShot = 550;
		this.reloadTime = 4050;
		this.reloadAnimation = new Animation("items/guns/revolver/reload.anim");
	}
	
	public void onShoot()
	{
		System.out.println("SHOOT");
	}
}
