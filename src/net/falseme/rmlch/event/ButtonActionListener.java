package net.falseme.rmlch.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Button;

public class ButtonActionListener implements MouseListener {

	private Action action;
	private Button btn;
	private boolean in = false;

	public ButtonActionListener(Button btn, Action action) {
		this.btn = btn;
		this.action = action;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		btn.setBackground(Assets.BUTTON_PRESSED);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(in) {
			action.run();
			btn.setBackground(Assets.BUTTON_HOVER);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		btn.setBackground(Assets.BUTTON_HOVER);
		in = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		btn.setBackground(Assets.BUTTON);
		in = false;
	}

}
