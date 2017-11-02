package com.Akoot.foxgame.config;

import java.io.File;

import com.Akoot.util.CthFileConfiguration;

public class GameSettings
{
	private File dir;
	private CthFileConfiguration main;
	
	public double maxFPS;
	public String uiColor;
	public boolean capFrames;
	
	public GameSettings()
	{
		dir = new File("config");
		dir.mkdirs();
		main = new CthFileConfiguration(dir, "config", "cth");
		if(!main.exists())
		{
			main.create();
			setFPSMax(300);
			setUIColor("#FF0000");
			capFrames(false);
		}
		else load();
	}
	
	public void capFrames(boolean cap)
	{
		capFrames = cap;
		main.set("cap-frames", cap);
	}
	
	public void setUIColor(String color)
	{
		uiColor = color;
		main.set("ui-color", color);
	}
	
	public void setFPSMax(double FPS)
	{
		maxFPS = FPS;
		main.set("max-fps", FPS);
	}
	
	public void load()
	{
		maxFPS = main.getDouble("max-fps");
		uiColor = main.getString("ui-color");
		capFrames = main.getBoolean("cap-frames");
	}
}
