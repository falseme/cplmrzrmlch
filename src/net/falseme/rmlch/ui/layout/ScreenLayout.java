package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class ScreenLayout extends LayoutAdapter {

	private final int MENU_BAR_HEIGHT = 40;

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth(), H = parent.getHeight(); // WIDTH // HEIGHT //

		// Menu Bar
		parent.getComponent(0).setBounds(0, H - MENU_BAR_HEIGHT, W, MENU_BAR_HEIGHT);

	}

}
