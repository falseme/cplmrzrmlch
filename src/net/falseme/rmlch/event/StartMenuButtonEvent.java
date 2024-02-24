package net.falseme.rmlch.event;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import net.falseme.rmlch.assets.Assets;

public class StartMenuButtonEvent implements MouseListener {

	private JButton btn;
	private boolean in = false;

	public StartMenuButtonEvent(JButton btn) {
		this.btn = btn;
		btn.removeMouseListener(btn.getMouseListeners()[0]);
		this.btn.setBackground(new Color(192, 192, 192));
		this.btn.setIconTextGap(10);
		this.btn.setHorizontalAlignment(JButton.LEFT);
		this.btn.setFont(Assets.w98);
		this.btn.setBorder(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		btn.setBackground(new Color(0, 0, 128));
		btn.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (in)
			btn.getActionListeners()[0].actionPerformed(null);
		btn.setBackground(new Color(192, 192, 192));
		btn.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		in = true;
		btn.setBackground(new Color(174, 174, 174));
		btn.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		in = false;
		btn.setBackground(new Color(192, 192, 192));
		btn.repaint();
	}

}
