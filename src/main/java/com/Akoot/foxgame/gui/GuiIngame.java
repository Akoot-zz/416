package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.EntityPlayer;
import com.Akoot.foxgame.util.Color;

public class GuiIngame extends Gui
{
	private EntityPlayer player;
	private float left, right, top, bottom;

	public GuiIngame(Foxgame game)
	{
		super(game);
		player = game.user.player;
	}

	@Override
	public void render()
	{	
		renderHUD();
		left = Foxgame.camera.x;
		right = Foxgame.camera.x + Foxgame.camera.width;
		top = Foxgame.camera.y;
		bottom = Foxgame.camera.y + Foxgame.camera.height;
	}

	public void renderHUD()
	{
		int barsWidth = 200;
		int barsX = 0;
		int barsY = 0;
		/* health */
		stage.drawRect(left + barsX, top + barsY, barsWidth, 25, Color.getColor(0x000000, 0.5));
		stage.drawRect(left + barsX, top + barsY, (float) (player.getHealth() / player.getMaxHealth()) * (float) (barsWidth), 25, Color.getColor(0xff0000));
		stage.drawString("Health: " + player.getHealth(), right + barsX, bottom + barsY, 20);
		/* hunger */
		stage.drawRect(left + barsX, top + barsY + 25, barsWidth, 25, Color.getColor(0x000000, 0.5));
		stage.drawRect(left + barsX, top + barsY + 25, (float) (player.getHunger() / player.getMaxHunger()) * (float) (barsWidth), 25, Color.getColor(0xFFC425));

		//stage.drawTexture(MouseHandler.mouseX(player), MouseHandler.mouseY(player), 50, 50, new Texture(new ResourceLocation("assets/textures/grass.png")), 0.5);
	}
}