package net.falseme.rmlch.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import net.falseme.rmlch.ui.RadioButton;

public class RadioButtonEvent implements MouseListener {

	private RadioButton rb;
	private boolean in = false;

	public RadioButtonEvent(RadioButton rb) {
		this.rb = rb;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (in) {
			rb.setActive();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		in = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		in = false;
	}

}
