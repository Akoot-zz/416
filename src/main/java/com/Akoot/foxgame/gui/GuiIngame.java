package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.EntityPlayer;
import com.Akoot.foxgame.input.MouseHandler;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class GuiIngame extends Gui
{
	private EntityPlayer player;
	private double left, right, top, bottom;
	
	public GuiIngame(Foxgame game)
	{
		super(game);
		player = game.user.player;
	}

	@Override
	public void render()
	{
		left = game.camera.x;
		right = game.camera.x + game.camera.width;
		top = game.camera.y;
		bottom = game.camera.y + game.camera.height;
		renderHUD();
	}
	
	public void renderHUD()
	{
		int barsWidth = 200;
		int barsX = 0;
		int barsY = 0;
		/* health */
		stage.drawRect(left + barsX, top + barsY, barsWidth, 25, Color.getColor(0x000000, 0.5));
		stage.drawRect(left + barsX, top + barsY, (player.getHealth() / player.getMaxHealth()) * (double) (barsWidth), 25, Color.getColor(0xff0000));
		/* hunger */
		stage.drawRect(left + barsX, top + barsY + 25, barsWidth, 25, Color.getColor(0x000000, 0.5));
		stage.drawRect(left + barsX, top + barsY + 25, (player.getHunger() / player.getMaxHunger()) * (double) (barsWidth), 25, Color.getColor(0xFFC425));
		
		//stage.drawTexture(MouseHandler.mouseX(player), MouseHandler.mouseY(player), 50, 50, new Texture(new ResourceLocation("assets/textures/grass.png")), 0.5);
	}
}