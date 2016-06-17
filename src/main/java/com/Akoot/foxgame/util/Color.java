package com.Akoot.foxgame.util;

public class Color
{
	private int red;
	private int green;
	private int blue;
	private int alpha;
	private int rgb;
	private int argb;

	public Color(int hex, double alpha)
	{
		this.red = 0xFF & (hex >> 16);
		this.green = 0xFF & (hex >> 8);
		this.blue = 0xFF & (hex >> 0);
		this.alpha = (int) (alpha * 255.0);

		this.rgb = (this.red << 16) | (this.green << 8) | this. blue;
		this.argb = (this.alpha << 24) | (this.red << 16) | (this.green << 8) | this. blue;
	}

	public Color(int hex)
	{
		this(hex, 1.0);
	}

	public Color(String hex)
	{
		this(Integer.parseInt(hex, 16), 1.0);
	}

	public Color(String hex, double alpha)
	{
		this(Integer.parseInt(hex, 16), alpha);
	}

	public float redf()
	{
		return (float) ((double) (red) / 255.0);
	}

	public float greenf()
	{
		return (float) ((double) (green) / 255.0);
	}

	public float bluef()
	{
		return (float) ((double) (blue) / 255.0);
	}

	public float alphaf()
	{
		return (float) ((double) (alpha) / 255.0);
	}

	public int red()
	{
		return red;
	}

	public int green()
	{
		return green;
	}

	public int blue()
	{
		return blue;
	}

	public int alpha()
	{
		return alpha;
	}

	public int getRGB()
	{
		return rgb;
	}

	public int getARGB()
	{
		return argb;
	}
}
