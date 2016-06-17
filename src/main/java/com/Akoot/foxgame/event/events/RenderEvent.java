package com.Akoot.foxgame.event.events;

import com.Akoot.foxgame.event.GameEvent;
import com.Akoot.foxgame.event.listeners.RenderListener;

public class RenderEvent implements GameEvent<RenderListener>
{
	public void notify(final RenderListener listener)
	{
		listener.render();
	}
}
