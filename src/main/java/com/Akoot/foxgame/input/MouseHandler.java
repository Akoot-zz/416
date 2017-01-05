package com.Akoot.foxgame.input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

import com.Akoot.foxgame.Foxgame;

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
	
	public static float mouseX()
	{
		float w = Foxgame.camera.width / 2.0F;
		return (float) ((mouseX + Foxgame.camera.x) - w + (Foxgame.camera.width / 2));
	}
	
	public static float mouseY()
	{
		double h = Foxgame.camera.height / 2.0F;
		return (float) ((mouseY + Foxgame.camera.y) - h + (Foxgame.camera.height / 2));
	}
}
