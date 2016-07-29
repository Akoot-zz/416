package com.Akoot.foxgame.util;

import java.io.File;

public class Animation
{
	private File animFile;
	
	public Animation(String location)
	{
		this.animFile = new File(new ResourceLocation("animations/" + location).getResourcePath());
		//if(!this.animFile.exists()) System.out.println("Animation file " + this.animFile + " does not exist!");
	}
}
