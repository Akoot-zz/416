package com.Akoot.foxgame.items.guns;

import com.Akoot.foxgame.item.AmmoType;
import com.Akoot.foxgame.item.ItemGun;

public class BoltAction extends ItemGun
{
	public BoltAction()
	{
		this.displayname = "Bolt-Action Rifle";
		this.ammoType = AmmoType.RIFLE;
		this.bulletDamage = 85.0;
		this.ammoPerClip = 10;
		this.msPerShot = 1950;
	}
}
