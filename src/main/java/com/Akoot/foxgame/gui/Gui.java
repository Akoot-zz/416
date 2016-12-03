package com.Akoot.foxgame.gui;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.graphics.DisplayObject;

public class Gui extends DisplayObject
{
	protected Foxgame game;
	protected Stage stage;

	public Gui(Foxgame game)
	{
		this.game = game;
		this.stage = Foxgame.stage;
	}
}
