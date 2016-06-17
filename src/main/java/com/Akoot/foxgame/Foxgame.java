package com.Akoot.foxgame;

import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.Sys;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import com.Akoot.foxgame.client.Gui;
import com.Akoot.foxgame.client.Texture;

public class Foxgame
{
	/** Reference callback instances. */
	private GLFWErrorCallback errorCallback;
	private GLFWKeyCallback   keyCallback;

	/** The window */
	private long window;

	/* Basic information */
	public final String version = "0.0.1";
	public final String name = "Foxgame", fullname = name + "-" + version;

	public final int initHeight = 700, initWidth = 1100;

	/** Run */
	public void run()
	{
		System.out.println("Hello LWJGL " + Sys.getVersion() + "!");
		try
		{
			init();
			loop();

			/* Release window and window callbacks */
			glfwDestroyWindow(window);
			keyCallback.release();
		}
		finally
		{
			/* Terminate GLFW and release the GLFWerrorfun */
			glfwTerminate();
			errorCallback.release();
		}
	}

	/** Init */
	private void init()
	{

		/* Setup an error callback. The default implementation will print the error message in System.err. */
		glfwSetErrorCallback(errorCallback = errorCallbackPrint(System.err));

		/* Initialize GLFW. Most GLFW functions will not work before doing this. */
		if ( glfwInit() != GL_TRUE )
			throw new IllegalStateException("Unable to initialize GLFW");

		/* Configure the window */
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

		/* Create the window */
		window = glfwCreateWindow(initWidth, initHeight, fullname, NULL, NULL);
		if (window == NULL) throw new RuntimeException("Failed to create the GLFW window.");

		/* Setup a key callback. It will be called every time a key is pressed, repeated or released. */
		glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback()
		{
			@Override
			public void invoke(long window, int key, int scancode, int action, int mods)
			{
				if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) glfwSetWindowShouldClose(window, GL_TRUE); // We will detect this in our rendering loop
			}
		});

		/* Get primary monitor resolution */
		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

		/* Center of the window */
		glfwSetWindowPos(window, (GLFWvidmode.width(vidmode) - initWidth) / 2, (GLFWvidmode.height(vidmode) - initHeight) / 2);

		/* Make the openGL context current */
		glfwMakeContextCurrent(window);

		/* Enable V-Sync */
		glfwSwapInterval(1);

		/* Display the window */
		glfwShowWindow(window);
	}

	public int getWidth()
	{
		ByteBuffer w = BufferUtils.createByteBuffer(4);
		ByteBuffer h = BufferUtils.createByteBuffer(4);
		glfwGetWindowSize(window, w, h);
		return w.getInt(0);
	}

	public int getHeight()
	{
		ByteBuffer w = BufferUtils.createByteBuffer(4);
		ByteBuffer h = BufferUtils.createByteBuffer(4);
		glfwGetWindowSize(window, w, h);
		return h.getInt(0);
	}

	/** Main game loop */
	private void loop()
	{
		/*
		 * Detects the context that is current in the current thread
		 * creates the ContextCapabilities instance
		 * and makes the OpenGL bindings available for use.
		 */
		GLContext.createFromCurrent();

		Texture texture = new Texture("assets/textures/bricks.png");
		Gui gui = new Gui(this);

		System.out.println("ttt");

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL_TEXTURE_2D);

		/* Sets the background color (RGBA)*/
		glClearColor(1,1,1,1);

		/* Run until closed */
		while (glfwWindowShouldClose(window) == GL_FALSE)
		{
			/* Clear frame buffer */
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);		
			int size = 100;
			for(int i = 0; i < 15; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					gui.displayImage(i * size * 2, j * size * 2, size, size, texture, 0xffffffff);
				}
			}

			/* Swap color buffers */
			glfwSwapBuffers(window);

			/* Poll for window events */
			glfwPollEvents();
		}
	}

	/** Main method of the entire program */
	public static void main(String[] args)
	{
		/* Load native libraries */
		SharedLibraryLoader.load();
		/* Launch the game */
		new Foxgame().run();
	}

}
