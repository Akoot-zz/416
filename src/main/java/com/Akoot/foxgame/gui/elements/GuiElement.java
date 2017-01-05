package com.Akoot.foxgame.gui.elements;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.graphics.Camera;
import com.Akoot.foxgame.graphics.DisplayObject;
import com.Akoot.foxgame.gui.Stage;
import com.Akoot.foxgame.input.MouseHandler;

public class GuiElement extends DisplayObject
{
	protected Stage stage;
	protected Camera camera;
	
	public GuiElement()
	{
		this.camera = Foxgame.camera;
	}
	
	public boolean mouseHover()
	{
		return (MouseHandler.mouseX() >= this.x && MouseHandler.mouseY() >= this.y && MouseHandler.mouseX() <= this.x + this.width && MouseHandler.mouseY() <= this.y + this.height);
	}
}
