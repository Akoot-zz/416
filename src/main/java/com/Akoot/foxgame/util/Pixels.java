package com.Akoot.foxgame.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class Pixels
{
	public static int[] getPixels(BufferedImage image)
	{
		byte[] buf =  ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
		int intArr[] = new int[buf.length / 4];
		int offset = 0;
		for(int i = 0; i < intArr.length; i++)
		{
			intArr[i] = ((buf[1 + offset] & 0xFF) >> 0) | ((buf[2 + offset] & 0xFF) << 8) | ((buf[3 + offset] & 0xFF) << 16) | ((buf[0 + offset] & 0xFF) << 24);  
			offset += 4;
		}
		return intArr;
	}

	public static int[][] getPixels2D(BufferedImage image)
	{
		final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		final int width = image.getWidth();
		final int height = image.getHeight();
		final boolean hasAlphaChannel = image.getAlphaRaster() != null;

		int[][] result = new int[height][width];
		if (hasAlphaChannel)
		{
			final int pixelLength = 4;
			for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength)
			{
				int argb = 0;
				argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
				argb += ((int) pixels[pixel + 1] & 0xff); // blue
				argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
				argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
				result[row][col] = argb;
				col++;
				if (col == width)
				{
					col = 0;
					row++;
				}
			}
		}
		else
		{
			final int pixelLength = 3;
			for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength)
			{
				int argb = 0;
				argb += -16777216; // 255 alpha
				argb += ((int) pixels[pixel] & 0xff); // blue
				argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
				argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
				result[row][col] = argb;
				col++;
				if (col == width)
				{
					col = 0;
					row++;
				}
			}
		}
		return result;
	}
}
