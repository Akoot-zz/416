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
		float left = 0;
		float right = 0;
		float bottom = 0;
		float top = 0;
		texture.bind();

		glEnable(GL_BLEND);
		glBegin(GL_QUADS);
		glColor4f(1, 1, 1, 1);

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
		glDisable(GL_BLEND);
	}

	public void drawTexture(double x, double y, double width, double height, Texture texture, Color color)
	{
		float left = 0;
		float right = 0;
		float bottom = 0;
		float top = 0;
		texture.bind();

		glEnable(GL_BLEND);
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
		glDisable(GL_BLEND);
	}
	
	public void drawRect(double x, double y, double width, double height, Color color)
	{
		float left = 0;
		float right = 0;
		float bottom = 0;
		float top = 0;
		
		glEnable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
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
		glEnable(GL_TEXTURE_2D);
		glDisable(GL_BLEND);
	}
}
