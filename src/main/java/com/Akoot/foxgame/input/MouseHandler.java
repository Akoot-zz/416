package com.Akoot.foxgame.input;

import org.lwjgl.glfw.GLFWCursorPosCallback;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.graphics.DisplayObject;

public class MouseHandler extends GLFWCursorPosCallback
{
	public static double mouseX;
	public static double mouseY;
	public static DisplayObject cursor = new DisplayObject();
	
	@Override
	public void invoke(long window, double xpos, double ypos)
	{
		//System.out.println("X: " + xpos + " Y: " + ypos);
		mouseX = xpos;
		mouseY = ypos;
	}
	
	public DisplayObject getCursor()
	{
		return cursor;
	}
	
	public static double mouseX(DisplayObject o)
	{
		double w = Foxgame.getFoxgame().initWidth / 2;
		return mouseX + o.x - w;
	}
	
	public static double mouseY(DisplayObject o)
	{
		double h = Foxgame.getFoxgame().initHeight / 2;
		return mouseY + o.y - h;
	}
}
