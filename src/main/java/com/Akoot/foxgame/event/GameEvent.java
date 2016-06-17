package com.Akoot.foxgame.event;

public interface GameEvent<L>
{
	public void notify(final L listener);
}
