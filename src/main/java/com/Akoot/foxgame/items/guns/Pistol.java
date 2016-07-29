package com.Akoot.foxgame.items.guns;

import com.Akoot.foxgame.item.AmmoType;
import com.Akoot.foxgame.item.ItemGun;
import com.Akoot.foxgame.util.Animation;

public class Pistol extends ItemGun
{
	public Pistol()
	{
		this.displayname = "Pistol";
		this.ammoType = AmmoType.PISTOL;
		this.bulletDamage = 25.0;
		this.ammoPerClip = 12;
		this.msPerShot = 300;
		this.reloadAnimation = new Animation("items/guns/pistol/reload.anim");
	}
}
