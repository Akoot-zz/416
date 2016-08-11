package com.Akoot.foxgame.util;

import com.Akoot.foxgame.graphics.DisplayObject;

public class Animation extends DisplayObject
{
	private Frame currentFrame;
	private Frame[] frames;
	private boolean playing;
	
	public Animation(int frames)
	{
		this.frames = new Frame[frames];
		this.frames[0] = new Frame(null, "init", 0, false, false, 0);
		this.currentFrame = this.frames[0];
	}
	
	public void setFrames(Frame... frames)
	{
		this.frames = frames;
	}
	
	public void play()
	{
		this.playing = true;
	}
	
	public void stop()
	{
		this.playing = false;
	}
	
	public void gotoAndStop(int frame)
	{
		this.currentFrame = frames[frame];
		stop();
	}
	
	public void gotoAndPlay(int frame)
	{
		this.currentFrame = frames[frame];
		play();
	}
	
	@Override
	public void render()
	{
		if(playing)
		{
			if(1 < 2)
			{
				currentFrame = frames[currentFrame.num + 1];
			}
		}
		if(currentFrame.texture != null) stage.drawTexture(x, y, width * scaleX, height * scaleY, currentFrame.texture, color);
	}
	
	public static class Frame
	{
		public Texture texture;
		public String label;
		public long time;
		public int num;
		public boolean flipX;
		public boolean flipY;
		public double rotation;
		
		public Frame(Texture texture, String label, long time, boolean flipX, boolean flipY, double rotation)
		{
			this.texture = texture;
			this.label = label;
			this.time = time;
			this.flipX = flipX;
			this.flipY = flipY;
			this.rotation = rotation;
		}
	}
}
