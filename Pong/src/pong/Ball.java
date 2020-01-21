package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	public double x, y;
	public int width, height;

	public double dx,dy;
	public double speed = 1.4;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		int angle = new Random().nextInt(120 - 45) + 45;		
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	
	public void reset() {
		new Game();
		return;
	}

	public void tick() {
			
		if(x+(dx*speed)+width > Game.WIDTH) {
			dx*=-1;
		}else if(x+(dx*speed)+width < 0) {
			dx*=-1;
		}
		
		if(y > Game.HEIGHT) {
			System.out.println("Ponto do inimigo");
			reset();
		}else if (y < 0) {
			System.out.println("ponto do jogador filha da putaaaaaaaa");
			reset();
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dx*speed)),width,height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.width,Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(y > 0) {
				dy*=-1;
			}
			speed = speed + 0.1;
		}else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(y < 0) {
				dy*=-1;
			}
			speed = speed + 0.1;
		}
		
		if(speed > 2.2) {
			speed = 1.2;
		}
		
		x += dx*speed;
		y += dy*speed;

	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);
	}

}
