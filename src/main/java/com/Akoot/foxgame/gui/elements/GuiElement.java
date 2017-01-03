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
		this.camera = Foxgame.getFoxgame().camera;
	}
	
	public boolean mouseHover()
	{
		return (MouseHandler.mouseX(camera) >= this.x && MouseHandler.mouseY(camera) >= this.y && MouseHandler.mouseX(camera) <= this.x + this.width && MouseHandler.mouseY(camera) <= this.y + this.height);
	}
}
