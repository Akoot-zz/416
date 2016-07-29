package com.Akoot.foxgame.items.guns;

import com.Akoot.foxgame.item.AmmoType;
import com.Akoot.foxgame.item.ItemGun;
import com.Akoot.foxgame.util.Animation;

public class Shotgun extends ItemGun
{
	public Shotgun()
	{
		this.displayname = "Shotgun";
		this.ammoType = AmmoType.SHOTGUN;
		this.bulletDamage = 5.0;
		this.ammoPerClip = 6;
		this.reloadAnimation = new Animation("items/guns/shotgun/reload.anim");
	}
}
