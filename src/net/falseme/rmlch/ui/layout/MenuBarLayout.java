package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class MenuBarLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth();
		int H = parent.getHeight(); // WIDTH // HEIGHT //

		int size = (int) (H * 0.9);
		int gap = (H - size) / 2;

		// EXIT BUTTON
		parent.getComponent(0).setBounds(gap, gap, size * 2, size);

		// SEPARATORS
		parent.getComponent(1).setBounds(gap * 3 + size * 2, gap, 4, size);
		parent.getComponent(2).setBounds(W - size * 3 - gap * 5, gap, 4, size);

		// CLOCK
		parent.getComponent(3).setBounds(W - size * 3 - gap, gap, size * 3, size);

		// WINDOW ICONS
		for (int i = 4; i < parent.getComponentCount(); i++) {
			parent.getComponent(i).setBounds(gap * 6 + size * 2 + (i - 4) * (size + gap * 2), gap, size, size);
		}

	}

}
