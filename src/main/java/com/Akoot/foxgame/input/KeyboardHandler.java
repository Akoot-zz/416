package com.Akoot.foxgame.input;

import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.*;

public class KeyboardHandler extends GLFWKeyCallback{

	public static boolean[] keys = new boolean[65536];
	
	@Override
	public void invoke(long window, int key, int scancode, int action, int mods)
	{
		keys[key] = action != GLFW_RELEASE;
		if(action == GLFW_PRESS) System.out.println("Key Pressed: " + key);
	}
	
	public static boolean isKeyDown(int keycode)
	{
		return keys[keycode];
	}
}
