package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Stage
{
	public Foxgame game;
	
	public Stage(Foxgame game)
	{
		this.game = game;
	}
	
	public void drawTexture(double x, double y, double width, double height, Texture texture)
	{
		drawTexture(x, y, width, height, texture, Color.getColor(0xffffff));
	}
	
	public void drawTexture(double x, double y, double width, double height, Texture texture, double alpha)
	{
		drawTexture(x, y, width, height, texture, Color.getColor(0xffffff, alpha));
	}

	public void drawTexture(double x, double y, double width, double height, Texture texture, Color color)
	{
		float left = (float) (x);
		float right = (float) (x + width);
		float bottom = (float) (y + height);
		float top = (float) y;
		texture.bind();

		glMatrixMode(GL_TEXTURE);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glBegin(GL_QUADS);
		glColor4f(color.redf(), color.greenf(), color.bluef(), color.alphaf());

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
		glDisable(GL_TEXTURE_2D);
		glDisable(GL_BLEND);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void drawRect(double x, double y, double width, double height, Color color)
	{
		float left = (float) (x);
		float right = (float) (x + width);
		float bottom = (float) (y + height);
		float top = (float) y;
		
		glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glColor4f(color.redf(), color.greenf(), color.bluef(), color.alphaf());
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
		glDisable(GL_BLEND);
	}
}
