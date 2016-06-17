package com.Akoot.foxgame.client;

import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameterf;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import de.matthiasmann.twl.utils.PNGDecoder;
import de.matthiasmann.twl.utils.PNGDecoder.Format;

public class Texture
{
	private int id;
	public int height, width;	

	public Texture(String location)
	{
		try
		{
			PNGDecoder decoder = new PNGDecoder(new FileInputStream(location));

			width = decoder.getWidth();
			height = decoder.getHeight();

			ByteBuffer buffer = ByteBuffer.allocateDirect(width* height * 4);
			decoder.decode(buffer, width * 4, Format.RGBA);
			buffer.flip();

			id = glGenTextures();

			glBindTexture(GL_TEXTURE_2D, id);
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void bind()
	{
		glBindTexture(GL_TEXTURE_2D, id);
	}
}
