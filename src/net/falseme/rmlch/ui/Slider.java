package net.falseme.rmlch.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import net.falseme.rmlch.assets.Assets;

public class Slider extends JSlider {
	private static final long serialVersionUID = 1l;

	protected ScreenComponent background;
	protected BufferedImage handler;

	public Slider(int min, int max, int value, ChangeListener listener) {
		super(min, max, value);
		addChangeListener(listener);
		background = new ScreenComponent(2, 2, Assets.SLIDER_BACKGROUND);
		handler = Assets.SLIDER_HANDLER;
	}

	@Override
	public void paintComponent(Graphics g) {

		// ESTO ES HORRIBLE NO LO MIERES PORFA T_T SON LAS 5AM TENGO SUEÑO
		// ESTO NO SE HACE
		// NUNCA
		// NUNCA
		// NUNCA
		// NUNCA
		// NUNCA

		g.setColor(new Color(212, 208, 200));
		g.fillRect(0, 0, getWidth(), getHeight());

		if (background.center != null) {

			int H = 5;

			// CORNERS
			for (int i = 0; i < background.corners.length; i++) {
				g.drawImage(background.corners[i], (i % 2) * (getWidth() - background.screenGap),
						(i > 1 ? 1 : 0) * (H - background.screenGap) + getHeight() / 2, background.screenGap,
						background.screenGap, null);
			}
			// SIDES
			for (int i = 0; i < background.sidesX.length; i++) {
				g.drawImage(background.sidesX[i], background.screenGap,
						i * (H - background.screenGap) + getHeight() / 2, getWidth() - background.screenGap * 2,
						background.screenGap, null);
			}
			for (int i = 0; i < background.sidesY.length; i++) {
				g.drawImage(background.sidesY[i], i * (getWidth() - background.screenGap),
						background.screenGap + getHeight() / 2, background.screenGap, H - background.screenGap * 2,
						null);
			}
			// CENTER
			g.drawImage(background.center, background.screenGap, background.screenGap + getHeight() / 2,
					getWidth() - background.screenGap * 2, H - background.screenGap * 2, null);
		}

		int xPercent = (getValue() - getMinimum()) * 100 / (getMaximum() - getMinimum());
		int x = (getWidth() - 10) * xPercent / 100;
		g.drawImage(handler, x - handler.getWidth() / 2, (getHeight() - handler.getHeight()) / 2, handler.getWidth(),
				handler.getHeight(), null);

	}

}
