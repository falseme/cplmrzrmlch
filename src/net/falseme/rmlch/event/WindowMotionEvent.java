package net.falseme.rmlch.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import net.falseme.rmlch.ui.window.Window;

public class WindowMotionEvent implements MouseListener, MouseMotionListener {

	private Window window;
	private int X, Y; // window
	private int x, y; // mouse

	public WindowMotionEvent(Window window) {

		this.window = window;

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		int x2 = e.getX();
		int y2 = e.getY();

		X += (x2 - x);
		Y += (y2 - y);

		window.setLocation(X, Y);

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		x = e.getX();
		y = e.getY();

		X = window.getBounds().x;
		Y = window.getBounds().y;

		window.getParent().setComponentZOrder(window, 1);

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
