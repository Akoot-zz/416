package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.entity.EntityPlayer;
import com.Akoot.foxgame.util.Color;

public class GuiIngame extends GuiScreen
{
	private EntityPlayer player;
	
	public GuiIngame()
	{
		player = game.user.player;
	}
	
	@Override
	public void render()
	{
		System.out.println("Rendering");
		stage.drawRect(0, 0, (player.getHealth() / player.getMaxHealth()) / 100.0, 25, Color.getColor(0xff0000));
	}
}
