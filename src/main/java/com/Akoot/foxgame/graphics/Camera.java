package com.Akoot.foxgame.graphics;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.entity.Entity;
import com.Akoot.foxgame.event.listeners.RenderListener;

public class Camera implements RenderListener
{
	private double x;
	private double y;
	private double width;
	private double height;
	private Foxgame game;
	private Entity target;
	
	public Camera(Foxgame game)
	{
		this.x = 0;
		this.y = 0;
	}
	
	@Override
	public void render()
	{
		this.width = game.getWidth();
		this.height = game.getHeight();
	}
	
	/** Get camera width
	 * @return Width of the camera
	 */
	public double getWidth()
	{
		return width;
	}
	
	/** Get camera height
	 * @return Height of the camera
	 */
	public double getHeight()
	{
		return height;
	}
	
	/** Get camera's X position
	 * @return Y position of the camera
	 */
	public double getX()
	{
		return x;
	}
	
	/** Get camera's Y position
	 * @return Y position of the camera
	 */
	public double getY()
	{
		return y;
	}
}
