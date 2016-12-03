package com.Akoot.foxgame.input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.graphics.DisplayObject;

public class MouseHandler extends GLFWCursorPosCallback
{
	public static double mouseX;
	public static double mouseY;
	
	@Override
	public void invoke(long window, double xpos, double ypos)
	{
		//System.out.println("X: " + xpos + " Y: " + ypos);
		mouseX = xpos;
		mouseY = ypos;
	}
	
	public static void showCursor(boolean show)
	{
		if(!show) GLFW.glfwSetInputMode(Foxgame.getFoxgame().window, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_HIDDEN);
		else GLFW.glfwSetInputMode(Foxgame.getFoxgame().window, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_NORMAL);
	}
	
	public static double mouseX(DisplayObject o)
	{
		double w = Foxgame.getFoxgame().camera.width / 2;
		return (mouseX + o.x) - w + (o.width / 2);
	}
	
	public static double mouseY(DisplayObject o)
	{
		double h = Foxgame.getFoxgame().camera.height / 2;
		return (mouseY + o.y) - h + (o.height / 2);
	}
}
