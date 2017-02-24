import java.awt.Graphics;

public class Player {
	
	public boolean up, down, left, right;
	public int x, y, speed, width, height;
	
	public Player() {
		up = false;
		down = false;
		left = false;
		right = false;
		x = 350;
		y = 400;
		speed = 5;
		width = 30;
		height = 30;
	}
	
	public void tick() {
		if (up && y - speed >= 0) {
			y -= speed;
		}
		if (down && y + speed <= 540 - height) {
			y += speed;
		}
		if (left && x - speed >= 0) {
			x -= speed;
		}
		if (right && x + speed <= 700 - width) {
			x += speed;
		}
	}
	
	public void render(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
}
