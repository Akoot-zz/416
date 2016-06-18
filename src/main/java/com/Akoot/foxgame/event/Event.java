package com.Akoot.foxgame.event;

import com.Akoot.foxgame.event.events.RenderEvent;
import com.Akoot.foxgame.event.events.TickEvent;

@SuppressWarnings("rawtypes")
public enum Event
{	
	ENTER_FRAME(RenderEvent.class),
	UPDATE(TickEvent.class);
	
	private Class event;
	
	private Event(Class event)
	{
		this.event = event;
	}
	
	public Class getEvent()
	{
		return event;
	}
}
