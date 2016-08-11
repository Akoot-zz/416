package com.Akoot.foxgame.container;

import java.util.ArrayList;
import java.util.List;

import com.Akoot.foxgame.item.Item;

public class Inventory
{
	public List<Item> contents;
	public int size;

	public Inventory()
	{
		this.size = 4;
		this.contents = new ArrayList<Item>();
	}

	public void addItem(Item item)
	{
		if(this.contents.size() < size)
		{
			for(Item i: contents)
			{
				if(i.equals(item))
				{
					i.amount += 1;
					return;
				}
			}
			this.contents.add(item);
		}
	}

	public void removeItem(Item item)
	{
		if(this.contents.contains(item))
		{
			this.contents.remove(item);
		}
	}
}
