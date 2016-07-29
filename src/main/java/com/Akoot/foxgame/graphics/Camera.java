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
	public void setSize(double width, double height)
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
}
