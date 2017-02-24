import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			Component.p.up = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			Component.p.down = true;
		}
		if (key == KeyEvent.VK_LEFT) {
			Component.p.left = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			Component.p.right = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			Component.p.up = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			Component.p.down = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			Component.p.left = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			Component.p.right = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
}
