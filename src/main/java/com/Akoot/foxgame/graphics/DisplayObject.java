package com.Akoot.foxgame.graphics;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.Event;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.gui.Stage;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.Texture;

public class DisplayObject implements RenderListener
{
	public double x, y, width, height, scaleX, scaleY, defScale;
	public Texture texture;
	public Color color;
	protected Stage stage;

	public DisplayObject()
	{
		Foxgame.eventHandler.addEventListener(Event.ENTER_FRAME, this);
		this.stage = Foxgame.stage;
		this.defScale = 1;
	}

	@Override
	public void render() {}

	public void setSize(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void setScale(double scale)
	{
		this.defScale = scale;
		this.scaleX = scale;
		this.scaleY = scale;
	}

	public boolean hitTestPoint(double x, double y)
	{
//		if(this.x == x && this.y == y) return true; 										//top left
//		if(this.x + this.width / 2 == x && this.y == y) return true; 						//top center
//		if(this.x + this.width == x && this.y == y) return true; 							//top right
//		if(this.x == x && this.y + this.height / 2 == y) return true;						//mid left
//		if(this.x + this.width / 2 == x && this.y + this.height / 2 == y) return true; 		//middle
//		if(this.x + this.width == x && this.y + this.height / 2 == y) return true; 			//mid right
//		if(this.x == x && this.y + this.height == y) return true;							//bottom left
//		if(this.x + this.width / 2 == x && this.y + this.height == y) return true;			//bottom center
//		if(this.x + this.width == x && this.y + this.height == y) return true; 				//bottom right
		if(x <= this.x + this.width && x >= this.x && y <= this.y + this.height && y >= this.y) return true;
		return false;
	}

	public boolean hitTest(DisplayObject o)
	{
//		if(this.hitTestPoint(o.x, o.y)) return true;										//top left
//		if(this.hitTestPoint(o.x + o.width / 2, o.y)) return true;							//top center
//		if(this.hitTestPoint(o.x + o.width, o.y)) return true; 								//top right
//		if(this.hitTestPoint(o.x, o.y + o.height / 2)) return true; 						//mid left
//		if(this.hitTestPoint(o.x + o.width / 2, o.y + o.height / 2)) return true;			//middle
//		if(this.hitTestPoint(o.x + o.width, o.y + o.height / 2)) return true;				//mid right
//		if(this.hitTestPoint(o.x, o.y + height)) return true; 								//bottom left
//		if(this.hitTestPoint(o.x + o.width / 2, o.y + height)) return true;					//bottom center
//		if(this.hitTestPoint(o.x + o.width, o.y + height)) return true;						//bottom right
		if(((this.x <= o.x + o.width && this.x >= o.x) ||
		(this.x + this.width <= o.x + o.width && this.x + this.width >= o.x)) &&
		((this.y <= o.y + o.height && this.y >= o.y) ||
		(this.y + this.height <= o.y + o.height && this.y + this.height >= o.y))) return true;
		return false;
	}
}
