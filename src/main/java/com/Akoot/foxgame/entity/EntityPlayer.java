package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.input.KeyboardHandler;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class EntityPlayer extends EntityLiving
{
	private double hunger;
	
	public EntityPlayer(Foxgame game, String username)
	{
		super(game, username);
		this.textureLocation = new ResourceLocation("assets/textures/player.png");
		this.texture = new Texture(textureLocation);
		this.health = 200.0;
		this.height = 75;
		this.width = 50;
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if(KeyboardHandler.isKeyDown(65)) this.x -= speed;
		if(KeyboardHandler.isKeyDown(68)) this.x += speed;
		if(KeyboardHandler.isKeyDown(83)) this.y += speed;
		if(KeyboardHandler.isKeyDown(87)) this.y -= speed;
		if(KeyboardHandler.isKeyDown(256)) this.health -= 5;
	}
	
	@Override
	public void render()
	{
		gui.drawTexture(x, y, width, height, texture, color);
	}
	
	public double getHunger()
	{
		return hunger;
	}
}
