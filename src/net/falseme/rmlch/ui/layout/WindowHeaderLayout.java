package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class WindowHeaderLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth(), H = parent.getHeight();
		final int BUTTON_SIZE = (int) (H * 0.85);

		parent.getComponent(0).setBounds(0, 0, parent.getComponent(0).getPreferredSize().width, H); // LABEL // TITLE
		parent.getComponent(1).setBounds(W - H * 2, (H - BUTTON_SIZE) / 2 + 2, BUTTON_SIZE, BUTTON_SIZE); // MIN BUTTON
		parent.getComponent(2).setBounds(W - H, (H - BUTTON_SIZE) / 2 + 2, BUTTON_SIZE, BUTTON_SIZE); // CLOSE BUTTON

	}

}
