package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class WindowLayout extends LayoutAdapter {

	private static final int HEADER_HEIGHT = 32;

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth(), gap = 3;
		parent.getComponent(0).setBounds(gap, gap, W - gap * 2, HEADER_HEIGHT);

	}

}
