package com.Akoot.foxgame;

import com.Akoot.foxgame.entity.EntityPlayer;

public class User
{
	public EntityPlayer player;
	public String steamID;
	
	public User(Foxgame game, String username)
	{
		this.player = new EntityPlayer(game, username);	
	}
}
