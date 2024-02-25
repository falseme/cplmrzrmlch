package net.falseme.rmlch.ui.window;

import java.awt.Component;
import java.awt.Container;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class MineSweeperWindow extends Window {
	private static final long serialVersionUID = 1L;

	public MineSweeperWindow(Screen parent) {
		super("MineSweeper", null, Assets.WINMINE, parent, 400, 420);

		setLayout(new MineSweeperLayout());

		int w = 6;

		boolean[] bombs = new boolean[w * w];
		bombs[4] = true;
		bombs[7] = true;
		bombs[15] = true;
		bombs[18] = true;
		bombs[26] = true;
		bombs[35] = true;

		boolean[] activated = new boolean[w * w];

		Button[] buttons = new Button[w * w];
		for (int i = 0; i < w * w; i++) {
			final int I = i;
			buttons[i] = new Button("", null, () -> {
				int y = I / w;
				int x = I - w * y;

				buttons[I].setBackground(Assets.BUTTON_PRESSED);

				// CHECK IF BOMB
				if (bombs[I]) {
					for (int j = 0; j < w * w; j++) {
						if (!activated[j])
							buttons[j].removeMouseListener(buttons[j].getMouseListeners()[0]);
						if (bombs[j]) {
							buttons[j].setIcon(Assets.WINMINE);
							buttons[j].setBackground(Assets.BUTTON_ERROR);
						}
						buttons[j].repaint();
					}
					doLayout();
					repaint();
					return;
				}

				// CHECK NEAR BOMBS
				int nearBombs = 0;
				int I0;
				// up-left
				I0 = (x - 1) + (y - 1) * w;
				if (I0 >= 0 && x > 0)
					if (bombs[I0])
						nearBombs++;
				// up
				I0 = x + (y - 1) * w;
				if (I0 >= 0)
					if (bombs[I0])
						nearBombs++;
				// up-right
				I0 = x + 1 + (y - 1) * w;
				if (I0 >= 0 && x < w - 1)
					if (bombs[I0])
						nearBombs++;
				// left
				I0 = (x - 1) + y * w;
				if (I0 >= 0 && x > 0)
					if (bombs[I0])
						nearBombs++;
				// right
				I0 = x + 1 + y * w;
				if (I0 <= bombs.length - 1 && x < w - 1)
					if (bombs[I0])
						nearBombs++;
				// bottom-left
				I0 = (x - 1) + (y + 1) * w;
				if (I0 <= bombs.length - 1 && x > 0)
					if (bombs[I0])
						nearBombs++;
				// bottom
				I0 = x + (y + 1) * w;
				if (I0 <= bombs.length - 1)
					if (bombs[I0])
						nearBombs++;
				// bottom-right
				I0 = x + 1 + (y + 1) * w;
				if (I0 <= bombs.length - 1 && x < w - 1)
					if (bombs[I0])
						nearBombs++;

				if (nearBombs > 0) {

					buttons[I].setText("" + nearBombs);
					activated[I] = true;
					buttons[I].removeMouseListener(buttons[I].getMouseListeners()[0]);
					buttons[I].doLayout();
					return;

				}

				// ACTIVE OTHER WHEN EMPTY
				activated[I] = true;
				buttons[I].removeMouseListener(buttons[I].getMouseListeners()[0]);
				// up-left
				I0 = (x - 1) + (y - 1) * w;
				if (I0 >= 0 && x > 0)
					if (!activated[I0])
						buttons[I0].action().run();
				// up
				I0 = x + (y - 1) * w;
				if (I0 >= 0)
					if (!activated[I0])
						buttons[I0].action().run();
				// up-right
				I0 = x + 1 + (y - 1) * w;
				if (I0 >= 0 && x < w - 1)
					if (!activated[I0])
						buttons[I0].action().run();
				// left
				I0 = (x - 1) + y * w;
				if (I0 >= 0 && x > 0)
					if (!activated[I0])
						buttons[I0].action().run();
				// right
				I0 = x + 1 + y * w;
				if (I0 <= buttons.length - 1 && x < w - 1)
					if (!activated[I0])
						buttons[I0].action().run();
				// bottom-left
				I0 = (x - 1) + (y + 1) * w;
				if (I0 <= buttons.length - 1 && x > 0)
					if (!activated[I0])
						buttons[I0].action().run();
				// bottom
				I0 = x + (y + 1) * w;
				if (I0 <= buttons.length - 1)
					if (!activated[I0])
						buttons[I0].action().run();
				// bottom-right
				I0 = x + 1 + (y + 1) * w;
				if (I0 <= buttons.length - 1 && x < w - 1)
					if (!activated[I0])
						buttons[I0].action().run();

				buttons[I].doLayout();
				buttons[I].repaint();
				doLayout();
				repaint();

			});
			add(buttons[i]);
		}

	}

	public void doLayout() {
		super.doLayout();
		for (Component c : getComponents())
			c.doLayout();
	}

}

class MineSweeperLayout extends WindowLayout {

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);

		int W = (int) (parent.getWidth() * 0.8);

		final int COUNT = (int) Math.sqrt(parent.getComponentCount() - 1);
		final int SIZE = W / COUNT;
		final int GAP = (parent.getWidth() - SIZE * COUNT) / 2;
		int GAPY = ((parent.getHeight() - HEADER_HEIGHT) - SIZE * COUNT) / 2;

		int x = GAP;
		int y = GAPY + HEADER_HEIGHT;
		for (int i = 1; i < parent.getComponentCount(); i++) {

			if ((i - 1) % COUNT == 0 && i > 1) {
				x = GAP;
				y += SIZE;
			}

			parent.getComponent(i).setBounds(x, y, SIZE, SIZE);
			x += SIZE;

		}

	}

}
