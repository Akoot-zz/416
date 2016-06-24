package com.Akoot.foxgame.graphics;

import static org.lwjgl.opengl.GL11.*;

import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;
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

	public void drawTexture(double x, double y, double width, double height, Texture texture, double alpha)
	{
		drawTexture(x, y, width, height, texture, new Color(0xffffff, alpha));
	}

	public void drawTexture(double x, double y, double width, double height, Texture texture)
	{
		float left = (float) (getX(x));
		float right = (float) (getX(x) + getWidth(width));
		float bottom = (float) (getY(y) - getHeight(height));
		float top = (float) (getY(y));
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
		float left = (float) (getX(x));
		float right = (float) (getX(x) + getWidth(width));
		float bottom = (float) (getY(y) - getHeight(height));
		float top = (float) (getY(y));
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
		float left = (float) (getX(x));
		float right = (float) (getX(x) + getWidth(width));
		float bottom = (float) (getY(y) - getHeight(height));
		float top = (float) (getY(y));

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
