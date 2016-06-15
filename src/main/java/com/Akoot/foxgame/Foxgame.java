package com.Akoot.foxgame;

import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.ByteBuffer;

import org.lwjgl.Sys;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Foxgame
{
	/** Reference callback instances. */
	private GLFWErrorCallback errorCallback;
	private GLFWKeyCallback   keyCallback;

	/** The window */
	private long window;
	
	/* Basic information */
	public static final String version = "0.0.1";
	public static final String name = "Foxgame", fullname = name + "-" + version;
	
	public static final int height = 700, width = 1100;
	
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
		if ( glfwInit() != GL11.GL_TRUE )
			throw new IllegalStateException("Unable to initialize GLFW");

		/* Configure the window */
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

		/* Create the window */
		window = glfwCreateWindow(width, height, fullname, NULL, NULL);
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
		glfwSetWindowPos(window, (GLFWvidmode.width(vidmode) - width) / 2, (GLFWvidmode.height(vidmode) - height) / 2);

		/* Make the openGL context current */
		glfwMakeContextCurrent(window);
		
		/* Enable V-Sync */
		glfwSwapInterval(1);

		/* Display the window */
		glfwShowWindow(window);
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

		/* Sets the clear color (RGBA)*/
		glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

		/* Run until closed */
		while (glfwWindowShouldClose(window) == GL_FALSE)
		{
			/* Clear frame buffer */
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

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
