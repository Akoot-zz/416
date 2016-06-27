package com.Akoot.foxgame.entity;

import com.Akoot.foxgame.Foxgame;
import com.Akoot.foxgame.input.KeyboardHandler;
import com.Akoot.foxgame.util.ResourceLocation;
import com.Akoot.foxgame.util.Texture;

public class EntityPlayer extends EntityLiving
{
	private double hunger;

	public EntityPlayer(Foxgame game, String username)
	{
		super(game, username);
		this.textureLocation = new ResourceLocation("assets/textures/player.png");
		this.texture = new Texture(textureLocation);
		this.height = 50;
		this.width = 50;
		this.speed = 8;
		this.jumpHeight = 8;
	}

	@Override
	public void init()
	{
		startX = 100;
		startY = 100;
		reset();
	}

	public void reset()
	{
		this.x = startX;
		this.y = startY;
		health = 100;
		speedl = 0;
		speedr = 0;
		grav = 0;
	}

	@Override
	public void tick()
	{
		if (health <= 0)
		{
			health = 0;
			this.dead = true;
		}
		else this.dead = false;
		if (!dead)
		{
			inertia = speed / 10;
			if (speedr < 0) speedr = 0;
			if (speedl < 0) speedl = 0;
			this.x -= speedl;
			this.x += speedr;

			if (crouching && onGround)
			{
				if (speed > 1) speed = 1;
			}
			else speed = 8;

			if (KeyboardHandler.isKeyDown(68))
			{
				//scaleX = 1;
				if (speedr <= speed)
				{
					speedr += inertia;
				}
				else
				{
					speedr -= inertia;
				}
			}
			else if (speedr > 0)
			{
				speedr -= inertia;
			}

			if (KeyboardHandler.isKeyDown(65))
			{
				//scaleX = -1;
				if (speedl <= speed)
				{
					speedl += inertia;
				}
				else
				{
					speedl -= inertia;
				}
			}
			else if (speedl > 0)
			{
				speedl -= inertia;
			}

			if (KeyboardHandler.isKeyDown(87) && grav < 3 && /*!relJumpKey &&*/ !onCeiling && canJump)
			{
				grav = 0;
				jump = true;
			}

			if (jump)
			{
				//this.gotoAndStop("jump");
				this.y -= jumpHeight;
			}

			if (KeyboardHandler.isKeyDown(83))
			{
				crouch(true);
			}
			else
			{
				if (!onCeiling)
				{
					crouch(false);
				}
			}

			if (grav <= 25)
			{
				grav += 0.5;
			}
			this.y += grav;
			checkCollision();

			if (speedl <= 0 && speedr <= 0 && grav < 3 && !crouching)
			{
				//this.gotoAndStop("idle");
			}
			if (jump && !crouching)
			{
				//this.gotoAndStop("jump");
			}
			if (!jump && !crouching && onGround && !onCeiling)
			{
				//this.gotoAndStop("idle");
			}
		}
		else
		{
			reset();
		}
	}

	@Override
	public void render()
	{
		gui.drawTexture(x, y, width, height, texture, color);
	}

	public double getHunger()
	{
		return hunger;
	}
}
