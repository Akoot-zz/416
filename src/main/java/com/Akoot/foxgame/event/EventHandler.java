package com.Akoot.foxgame.event;

import java.util.ArrayList;
import java.util.HashMap;

public final class EventHandler
{
	/** Mapping of class events to active listeners **/
	@SuppressWarnings("rawtypes")
	private final HashMap<Class,ArrayList> map = new HashMap<Class,ArrayList >(10);

	/** Add a listener to an event class
	 * 
	 * @param eventClass The event
	 * @param listener The class that listens for an event
	 */
	public <L> void addEventListener(Event event, L listener)
	{
		@SuppressWarnings("unchecked")
		final ArrayList<L> listeners = listenersOf(event.getEvent());
		synchronized(listeners)
		{
			if (!listeners.contains(listener)) listeners.add(listener);
		}
	}

	/** Stop sending an event class to a given listener **/
	public <L> void mute(Class<? extends GameEvent<L>> eventClass, L listener)
	{
		final ArrayList<L> listeners = listenersOf(eventClass);
		synchronized(listeners)
		{
			listeners.remove(listener);
		}
	}

	/** Gets listeners for a given event class **/
	private <L> ArrayList<L> listenersOf(Class<? extends GameEvent<L>> eventClass)
	{
		synchronized (map)
		{
			@SuppressWarnings("unchecked")
			final ArrayList<L> existing = map.get(eventClass);
			if (existing != null) return existing;

			final ArrayList<L> emptyList = new ArrayList<L>(5);
			map.put(eventClass, emptyList);
			return emptyList;
		}
	}


	/** Notify a new event to registered listeners of this event class **/
	public <L> void dispatchEvent(final GameEvent<L> event)
	{
		@SuppressWarnings("unchecked")
		Class<GameEvent<L>> eventClass = (Class<GameEvent<L>>) event.getClass();

		for (L listener : listenersOf(eventClass)) event.notify(listener);
	}

}