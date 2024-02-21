package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class MenuBarLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

//		int W = parent.getWidth();
		int H = parent.getHeight(); // WIDTH // HEIGHT //

		int size = (int) (H * 0.9);
		int gap = (H - size) / 2;
		parent.getComponent(0).setBounds(gap, gap, size*2, size);

	}

}
