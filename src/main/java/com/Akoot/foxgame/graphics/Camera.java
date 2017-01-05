package com.Akoot.foxgame.graphics;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.gui.Cursor;

public class Camera extends DisplayObject
{
	public Cursor cursor;
	private DisplayObject target;
	
	public Camera(Foxgame game)
	{
		this.target = this;
		setSize(game.initWidth, game.initHeight);
		cursor = new Cursor();
	}
	
	public void setTarget(DisplayObject target)
	{
		this.target = target;
	}
	
	@Override
	public void render()
	{	
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(x, x + width, y + height, y, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		x = target.x - (width / 2.0F) + (target.width / 2.0F);
		y = target.y - (height / 2.0F) + (target.height / 2.0F);
	}
}
