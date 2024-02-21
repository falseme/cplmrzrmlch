package net.falseme.rmlch.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.falseme.rmlch.ui.layout.ScreenLayout;
import net.falseme.rmlch.ui.menubar.MenuBar;
import net.falseme.rmlch.ui.window.Window;

public class Screen extends JFrame {
	private static final long serialVersionUID = 1l;

	private JPanel panel;
	private MenuBar menuBar;

	public Screen() {

		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		panel = new JPanel(new ScreenLayout());
		panel.setBackground(new Color(0, 96, 255));
		add(panel);

		panel.add(new Desktop(this));
		menuBar = new MenuBar();
		panel.add(menuBar);

	}

	public void open(Window window) {
		if (Window.openedWindows.contains(window))
			return;
		Window.openedWindows.add(window);
		panel.add(window);
		panel.setComponentZOrder(window, 0);
		Button barbtn = new Button("", window.getIcon(), () -> {
			if (window.isHidden()) {
				panel.add(window);
				panel.setComponentZOrder(window, 0);
				window.repaint();
				window.doLayout();
			}
		});
		barbtn.setCompName(window.getCompName());
		menuBar.add(barbtn);
		menuBar.doLayout();
		window.repaint();
		window.doLayout();
	}

	public void close(Window window) {
		if (!Window.openedWindows.contains(window))
			return;
		Window.openedWindows.remove(window);
		panel.remove(window);
		menuBar.close(window.getCompName());
		repaint();
	}

	public void hide(Window window) {
		if (!Window.openedWindows.contains(window))
			return;
		window.setHidden(true);
		panel.remove(window);
		repaint();
	}

}
