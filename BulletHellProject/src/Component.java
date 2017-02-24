import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class Component extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static boolean isRunning;
	public static Dimension size;
	public static JFrame frame;
	private String name;
	private Image screen;
	public static Player p;

	public Component() {
		name = "Bullet Hell";
		isRunning = false;
		size = new Dimension(700, 540);
		setPreferredSize(size);
		p = new Player();
		this.addKeyListener(new Listener());
	}

	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000d / 60;
		int ticks = 0;
		int frames = 0;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		while (isRunning) {
			screen = createVolatileImage(size.width, size.height);
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta--;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println("Ticks: " + ticks + " Frames: " + frames);
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void tick() {
		p.tick();
	}

	public void render() {
		Graphics g = screen.getGraphics();

		p.render(g);

		g = getGraphics();

		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, size.width,
				size.height, null);
		g.dispose();
	}

	public void start() {
		isRunning = true;

		frame = new JFrame();
		frame.add(this);
		frame.pack();
		frame.setTitle(name);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		new Thread(this).start();
	}

	public static void stop() {
		isRunning = false;
	}

	public static void main(String args[]) {
		new Component().start();
	}

}
