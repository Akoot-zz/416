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
import org.lwjgl.opengl.GLContext;

import com.Akoot.foxgame.client.Gui;
import com.Akoot.foxgame.client.Texture;
import com.Akoot.foxgame.util.Color;

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

	private Gui gui;
	private Texture texture;

	/** Run */
	public void run()
	{
		/* Print message */
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

	/** Retrieves the display window's width.
	 *  @return displayWidth */
	public int getWidth()
	{
		ByteBuffer w = BufferUtils.createByteBuffer(4);
		ByteBuffer h = BufferUtils.createByteBuffer(4);
		glfwGetWindowSize(window, w, h);
		return w.getInt(0);
	}

	/** Retrieves the display window's height.
	 *  @return displayHeight */
	public int getHeight()
	{
		ByteBuffer w = BufferUtils.createByteBuffer(4);
		ByteBuffer h = BufferUtils.createByteBuffer(4);
		glfwGetWindowSize(window, w, h);
		return h.getInt(0);
	}

	/* Main game loop */
	public void loop()
	{
		GLContext.createFromCurrent();		
		/** Everything must be initiated AFTER this line */

		gui = new Gui(this);
		texture = new Texture("assets/textures/bricks.png");

		/** glState anything here */

		/* Enable alpha channels */
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		/* Enable textures */
		glEnable(GL_TEXTURE_2D);

		/* Set the background color*/
		glClearColor(1,1,1,1);

		/** Setup loop */

		/* Get nanoseconds */
		long lastTime = System.nanoTime();

		/* Nanoseconds per tick */
		double nsPerTick = 1000000000D / 20D; //20 ticks per second
		/* Nanoseconds per frame */
		double nsPerFrame = 1000000000D / 60D; //60 frames per second

		/* counters */
		int ticks = 0;
		int frames = 0;

		/* Get milliseconds */
		long lastTimer = System.currentTimeMillis();
		double deltaTicks = 0;
		double deltaFrames = 0;

		/* Main game loop */
		while (glfwWindowShouldClose(window) == GL_FALSE)
		{
			/* Get current nanoseconds */
			long now = System.nanoTime();

			/* Increase deltas */
			deltaTicks += (now - lastTime) / nsPerTick;
			deltaFrames += (now - lastTime) / nsPerFrame;

			/* Reset time */
			lastTime = now;

			/* Don't render yet */
			boolean shouldRender = false;

			/* Should the game tick */
			while (deltaTicks >= 1)
			{
				ticks++;
				tick();
				deltaTicks -= 1;
			}

			/* Should the game render */
			while(deltaFrames >= 1)
			{
				deltaFrames -= 1;
				shouldRender = true;
			}

			/* Sleep a little */
			try
			{
				Thread.sleep(2);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			/* Render ONLY if it should */
			if (shouldRender)
			{
				frames++;
				/* Clear frame buffer */
				glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	
				render();
				/* Swap color buffers */
				glfwSwapBuffers(window);

				/* Poll for window events */
				glfwPollEvents();
			}

			/* Reset every second */
			if (System.currentTimeMillis() - lastTimer >= 1000)
			{
				lastTimer += 1000;
				System.out.println(ticks + " ticks, " + frames + " frames");
				frames = 0;
				ticks = 0;
			}
		}
	}

	/* Render all of the game */
	public void render()
	{	
		int size = 100;
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				gui.displayImage(i * size * 2, j * size * 2, size, size, texture, new Color(0x00ff00, 0.5));
			}
		}

		gui.drawRect(0, 0, 100, 100, new Color(0xff0000, 0.1));
	}

	/* Tick */
	public void tick()
	{
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
