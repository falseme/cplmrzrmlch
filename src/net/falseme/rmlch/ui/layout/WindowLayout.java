package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class WindowLayout extends LayoutAdapter {

	protected static final int HEADER_HEIGHT = 32;

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth();
		parent.getComponent(0).setBounds(0, 0, W, HEADER_HEIGHT);

	}

}
