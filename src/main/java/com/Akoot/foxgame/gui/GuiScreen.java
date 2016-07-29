package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.event.listeners.RenderListener;
import com.Akoot.foxgame.event.listeners.TickListener;

public class GuiScreen extends Gui implements TickListener, RenderListener
{
	public GuiScreen()
	{
		super(Foxgame.getFoxgame());
	}
	
	@Override
	public void render() {}
	
	@Override
	public void tick() {}
}
