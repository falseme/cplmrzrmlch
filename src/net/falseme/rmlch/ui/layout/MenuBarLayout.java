package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class MenuBarLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth();
		int H = parent.getHeight(); // WIDTH // HEIGHT //

		// EXIT BUTTON
		int size = (int) (H * 0.9);
		int gap = (H - size) / 2;
		parent.getComponent(0).setBounds(gap, gap, size * 2, size);

		// CLOCK
		parent.getComponent(1).setBounds(W - size * 3 - gap, gap, size * 3, size);

	}

}
