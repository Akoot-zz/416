package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.graphics.Texture;
import com.Akoot.foxgame.input.KeyboardHandler;

public class EntityPlayer extends EntityLiving
{
	private double hunger;
	
	public EntityPlayer(Foxgame game, String username)
	{
		super(game, username);
		this.texture = new Texture("assets/textures/player.png");
		this.health = 200.0;
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if(KeyboardHandler.isKeyDown(65)) this.x -= 5;
		if(KeyboardHandler.isKeyDown(68)) this.x += 5;
		if(KeyboardHandler.isKeyDown(83)) this.y += 5;
		if(KeyboardHandler.isKeyDown(87)) this.y -= 5;
	}
	
	@Override
	public void render()
	{
		gui.drawTexture(x, y, width, height, texture);
	}
	
	public double getHunger()
	{
		return hunger;
	}
}
