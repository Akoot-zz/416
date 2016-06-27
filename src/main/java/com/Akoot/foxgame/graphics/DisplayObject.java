package com.Akoot.foxgame.graphics;

public class DisplayObject
{
	public double x, y, width, height;
	
	public DisplayObject() {}
	
	public boolean hitTestPoint(double x, double y)
	{
		if(this.x == x && this.y == y) return true;
		return false;
	}
}
