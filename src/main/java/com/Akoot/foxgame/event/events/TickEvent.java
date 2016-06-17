package com.Akoot.foxgame.event.events;

import com.Akoot.foxgame.event.GameEvent;
import com.Akoot.foxgame.event.listeners.TickListener;

public final class TickEvent implements GameEvent<TickListener>
{
	public void notify(final TickListener listener)
	{
		listener.tick();
	}
}
