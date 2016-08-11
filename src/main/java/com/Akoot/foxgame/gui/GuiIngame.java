package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.entity.EntityPlayer;
import com.Akoot.foxgame.input.MouseHandler;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

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
		int barsWidth = 200;
		int barsX = 0;
		int barsY = 0;
		/* health */
		stage.drawRect(game.camera.x + barsX, game.camera.y + barsY, barsWidth, 25, Color.getColor(0x000000));
		stage.drawRect(game.camera.x + barsX, game.camera.y + barsY, (player.getHealth() / player.getMaxHealth()) * (double) (barsWidth), 25, Color.getColor(0xff0000));
		/* hunger */
		stage.drawRect(game.camera.x + barsX, game.camera.y + barsY + 25, barsWidth, 25, Color.getColor(0x000000));
		stage.drawRect(game.camera.x + barsX, game.camera.y + barsY + 25, (player.getHunger() / player.getMaxHunger()) * (double) (barsWidth), 25, Color.getColor(0xFFC425));
		
		//stage.drawTexture(MouseHandler.mouseX(player), MouseHandler.mouseY(player), 50, 50, new Texture(new ResourceLocation("assets/textures/grass.png")));
	}
}
