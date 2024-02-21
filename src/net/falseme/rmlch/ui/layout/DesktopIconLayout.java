package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class DesktopIconLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth(), H = parent.getHeight(); // WIDTH // HEIGHT //
		int h = parent.getComponent(0).getPreferredSize().height;
		int w = (int) (W * 0.95);

		parent.getComponent(0).setBounds((W - w) / 2, H - h, w, h);

	}

}
