package net.falseme.rmlch.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import net.falseme.rmlch.ui.Desktop;
import net.falseme.rmlch.ui.DesktopIcon;

public class DesktopIconEvent implements MouseListener {

	private Action action;
	private DesktopIcon desktopIcon;
	boolean in = false;

	public DesktopIconEvent(DesktopIcon desktopIcon, Action action) {
		this.desktopIcon = desktopIcon;
		this.action = action;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Desktop.setFocus(desktopIcon);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getClickCount() >= 2) {
			action.run();
			desktopIcon.setFocus(false);
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
