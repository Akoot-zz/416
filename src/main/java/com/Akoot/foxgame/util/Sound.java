package com.Akoot.foxgame.util;

import java.io.File;

public class Sound
{
	private File soundFile;
	
	public Sound(String location)
	{
		this.soundFile = new File(new ResourceLocation(location).getResourcePath());
		if(!this.soundFile.exists()) System.out.println("Sound file " + this.soundFile + " does not exist!");
	}
	
	public void play()
	{
		System.out.println("Playing: " + soundFile.getAbsolutePath());
	}
}
