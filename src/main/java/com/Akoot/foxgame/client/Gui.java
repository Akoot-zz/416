package com.Akoot.foxgame.client;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;

import com.Akoot.foxgame.Foxgame;

public class Gui
{
	protected Foxgame game;

	public Gui(Foxgame game)
	{
		this.game = game;
	}
	
	private double getX(double x)
	{
		x -= game.getWidth();
		return x /= game.getWidth();
	}
	
	private double getY(double y)
	{
		y -= game.getHeight();
		y /= game.getHeight();
		return -y;
	}
	
	private double getWidth(double width)
	{
		return width /= game.getWidth() / 2;
	}
	
	private double getHeight(double height)
	{
		return height /= game.getHeight() / 2;
	}
	
	public void displayImage(double x, double y, double width, double height, Texture texture)
	{
		displayImage(x, y, width, height, texture, 0xffffffff);
	}

	public void displayImage(double x, double y, double width, double height, Texture texture, int color)
	{
		float left = (float) (getX(x));
		float right = (float) (getX(x) + getWidth(width));
		float bottom = (float) (getY(y) - getHeight(height));
		float top = (float) (getY(y));
		
	    float r = (float) (0xff & (color >> 16) / 255);
	    float g = (float) (0xff & (color >> 8) / 255);
	    float b = (float) (0xff & (color) / 255);
	    float a = (float) (0xff & (color >> 24) / 255);
		
		texture.bind();
		
		glBegin(GL_QUADS);
		glColor4f(r, g, b, a);
		
		/* top-left */
		glTexCoord2f(0, 0);
		glVertex2f(left, top);

		/* top-right */
		glTexCoord2f(1, 0);
		glVertex2f(right, top);

		/* bottom-right */
		glTexCoord2f(1, 1);
		glVertex2f(right, bottom);

		/* bottom-left */
		glTexCoord2f(0, 1);
		glVertex2f(left, bottom);
		glEnd();
	}

	public void drawRect(double x, double y, double width, double height, int color)
	{
		float left = (float) (getX(x));
		float right = (float) (getX(x) + getWidth(width));
		float bottom = (float) (getY(y) - getHeight(height));
		float top = (float) (getY(y));
		
	    float r = (float) (0xff & (color >> 16) / 255);
	    float g = (float) (0xff & (color >> 8) / 255);
	    float b = (float) (0xff & (color) / 255);
	    float a = (float) (0xff & (color >> 24) / 255);

	    glEnable(GL_BLEND);
	    glDisable(GL_TEXTURE_2D);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	    glColor4f(r, g, b, a);
		glBegin(GL_QUADS);

		/* top-left */
		glVertex2f(left, top);

		/* top-right */
		glVertex2f(right, top);

		/* bottom-right */
		glVertex2f(right, bottom);

		/* bottom-left */
		glVertex2f(left, bottom);

		glEnd();
		glEnable(GL_TEXTURE_2D);
	    glDisable(GL_BLEND);
	}
}
