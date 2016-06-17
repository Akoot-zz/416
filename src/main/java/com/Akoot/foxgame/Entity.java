package com.Akoot.foxgame;

import com.Akoot.foxgame.event.events.TickEvent;
import com.Akoot.foxgame.event.listeners.TickListener;

public class Entity implements TickListener
{
	public String displayName;
	private Foxgame game;
	
	public Entity(Foxgame game, String displayName)
	{
		this.displayName = displayName;
		this.game = game;
		init();
	}
	
	public void init()
	{
		game.getEvents().addEventListener(TickEvent.class, this);
	}
	
	@Override
	public void tick()
	{
		System.out.println(displayName + ": im vibrating");
	}
}
