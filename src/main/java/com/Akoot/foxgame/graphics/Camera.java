package com.Akoot.foxgame.graphics;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import com.Akoot.foxgame.Foxgame;

public class Camera extends DisplayObject
{
	public Camera(Foxgame game)
	{
		setSize(game.initWidth, game.initHeight);
	}
	
	@Override
	public void render()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(x, x + width, y + height, y, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
}
