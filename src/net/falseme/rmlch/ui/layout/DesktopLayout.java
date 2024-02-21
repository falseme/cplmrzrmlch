package net.falseme.rmlch.ui.layout;

import java.awt.Container;

public class DesktopLayout extends LayoutAdapter {

	private final int ICONS_X = 12;
	private final int ICONS_Y = 7;
	
	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth();
		int H = parent.getHeight();

		// icon desktop matrix [7x14]
		int CW = W / ICONS_X;
		int CH = H / ICONS_Y;

		for (int i = 0; i < parent.getComponentCount(); i++) {

			int y = (i % ICONS_X) * CH;
			int x = (i / ICONS_Y) * CW;
			parent.getComponent(i).setBounds(x, y, CW, CH);

		}

	}

}
