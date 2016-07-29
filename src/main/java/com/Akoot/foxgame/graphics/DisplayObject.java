package com.Akoot.foxgame.graphics;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.Event;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.gui.Stage;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;

public class DisplayObject implements RenderListener
{
	public double x, y, width, height;
	public Texture texture;
	public Color color;
	protected Stage stage;
	
	public DisplayObject()
	{
		Foxgame.getFoxgame().eventHandler.addEventListener(Event.ENTER_FRAME, this);
	}
	
	@Override
	public void render() {}
	
	public void setSize(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	public boolean hitTestPoint(double x, double y)
	{
		if(this.x == x && this.y == y) return true;
		return false;
	}
	
	public boolean hitTest(DisplayObject o)
	{
		for(int xx = 0; (xx > o.x && xx < o.x + o.width); xx++)
		{
			for(int yy = 0; (yy > o.y && yy < o.y + o.height); yy++)
			{
				if(this.hitTestPoint(xx, yy)) return true;
			}
		}
		return false;
	}
}
