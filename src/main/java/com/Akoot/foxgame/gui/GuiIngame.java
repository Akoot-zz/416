package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.EntityPlayer;
import com.Akoot.foxgame.util.Color;

public class GuiIngame extends GuiScreen
{
	private EntityPlayer player;
	
	public GuiIngame(Foxgame game)
	{
		super(game);
		this.player = game.getPlayer();
	}
	
	@Override
	public void render()
	{
		double health = player.getHealth();
		double maxHealth = player.getMaxHealth();
		double hunger = player.getHealth();
		double maxHunger = 20.0;
		
		double width = 200.0;
		
//		drawRect(5, 5, width, 25, Color.getColor(0x000000, 0.5));
//		drawRect(5, 5, (health / maxHealth) * width, 25, Color.getColor(0xff0000));
	}
}
