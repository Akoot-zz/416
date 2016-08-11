package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;

public class EntityMob extends EntityLiving
{
	public EntityMob(Foxgame game, String displayName)
	{
		super(game, displayName);
		this.height = 100;
		this.width = 100;
	}
}
