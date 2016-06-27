package com.Akoot.foxgame;

import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.Sys;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GLContext;

import com.Akoot.foxgame.entity.EntityPlayer;
import com.Akoot.foxgame.event.EventHandler;
import com.Akoot.foxgame.event.events.RenderEvent;
import com.Akoot.foxgame.event.events.TickEvent;
import com.Akoot.foxgame.graphics.Gui;
import com.Akoot.foxgame.gui.GuiIngame;
import com.Akoot.foxgame.gui.GuiScreen;
import com.Akoot.foxgame.input.KeyboardHandler;
import com.Akoot.foxgame.level.World;
import com.Akoot.foxgame.level.TestLevel;
import com.Akoot.foxgame.util.Color;
import com.Akoot.foxgame.util.SharedLibraryLoader;

public class Foxgame
{
	/** Reference callback instances. */
	private GLFWErrorCallback errorCallback;
	private GLFWKeyCallback   keyCallback;

	/* The window */
	private long window;

	/* Basic information */
	public final String version = "0.0.1";
	public final String name = "Foxgame", fullname = name + "-" + version;

	public final int initHeight = 700, initWidth = 1100;

	private static Foxgame game;
	private EntityPlayer player;
	public Gui gui;
	private GuiScreen currentScreen;
	private EventHandler events;
	private World level;

	/** Run */
	public void run()
	{
		/* Print message */
		System.out.println("Hello LWJGL " + Sys.getVersion() + "!");
		game = this;
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
		glfwSetKeyCallback(window, keyCallback = new KeyboardHandler()); 

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

	public static Foxgame getFoxgame()
	{
		return game;
	}

	public EventHandler getEvents()
	{
		return events;
	}

	public World getCurrentLevel()
	{
		return level;
	}

	public void setLevel(World level)
	{
		this.level = level;
	}

	public GuiScreen getCurrentScreen()
	{
		return currentScreen;
	}

	public void setGuiScreen(GuiScreen screen)
	{
		this.currentScreen = screen;
	}

	public EntityPlayer getPlayer()
	{
		return player;
	}

	/** Main game loop */
	public void loop()
	{
		GLContext.createFromCurrent();		
		/** Everything must be initiated AFTER this line */

		events = new EventHandler();
		gui = new Gui(this);
		level = new TestLevel(this);	
		player = new EntityPlayer(this, "@Harold");
		player.startX = 100;
		player.startY = 100;
		player.init();
		currentScreen = new GuiIngame(this);

		player.setColor(Color.getColor(0xffba00));
		player.chat("I am alive.");
		
		level.getEntities().add(player);

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
		double nsPerTick = 1000000000D / 60D; //60 ticks per second
		/* Nanoseconds per frame */
		double nsPerFrame = 1000000000D / 60D; //60 frames per second

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
			}
		}
	}

	/** Render all of the game */
	public void render()
	{
		/* Render the level */
		if(level != null) level.render();

		/* Render everything else in the game */
		events.dispatchEvent(new RenderEvent());
		currentScreen.render();
	}

	/** Tick */
	public void tick()
	{
		currentScreen.tick();
		if(level != null) level.tick();
		events.dispatchEvent(new TickEvent());
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
