package com.Akoot.foxgame;

import com.Akoot.foxgame.entity.EntityPlayer;

public class User
{
	public EntityPlayer player;
	private Foxgame game;
	public String steamID;
	
	public User(Foxgame game, String username)
	{
		this.game = game;
		this.player = new EntityPlayer(game, username);	
	}
}
