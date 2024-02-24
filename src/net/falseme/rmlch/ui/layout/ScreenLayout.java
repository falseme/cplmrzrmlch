package net.falseme.rmlch.ui.layout;

import java.awt.Component;
import java.awt.Container;

public class ScreenLayout extends LayoutAdapter {

	private final int MENU_BAR_HEIGHT = 45;

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth(), H = parent.getHeight(); // WIDTH // HEIGHT //

		for (Component c : parent.getComponents()) {

			if (c.getClass().getName().equals("net.falseme.rmlch.ui.Desktop"))
				c.setBounds(0, 0, W, H - MENU_BAR_HEIGHT);
			else if (c.getClass().getName().equals("net.falseme.rmlch.ui.menu.MenuBar"))
				c.setBounds(0, H - MENU_BAR_HEIGHT, W, MENU_BAR_HEIGHT);

		}

	}

}
