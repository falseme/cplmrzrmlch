package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class ButtonLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth(), H = parent.getHeight(); // WIDTH // HEIGHT //

		parent.getComponent(0).setBounds(0, 2, W, H);

	}

}
