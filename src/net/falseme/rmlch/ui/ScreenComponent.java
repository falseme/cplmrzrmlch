package net.falseme.rmlch.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class ScreenComponent extends JComponent {
	protected static final long serialVersionUID = 1l;

	private BufferedImage[] corners = new BufferedImage[4];
	private BufferedImage[] sidesX = new BufferedImage[2];
	private BufferedImage[] sidesY = new BufferedImage[2];
	private BufferedImage center;
	private int gap = 0;

	public ScreenComponent(int gap, BufferedImage background) {

		this.gap = gap;
		setBackground(background);

	}

	public void setBackground(BufferedImage background) {

		// CORNERS
		for (int i = 0; i < corners.length; i++) {

			corners[i] = background.getSubimage((i % 2) * (background.getWidth() - gap),
					(i > 1 ? 1 : 0) * (background.getHeight() - gap), gap, gap);

		}

		// SIDES
		for (int i = 0; i < sidesX.length; i++) {

			sidesX[i] = background.getSubimage(gap, i * (background.getHeight() - gap), background.getWidth() - gap * 2,
					gap);

		}
		for (int i = 0; i < sidesY.length; i++) {

			sidesY[i] = background.getSubimage(i * (background.getWidth() - gap), gap, gap,
					background.getHeight() - gap * 2);
			
		}

		// CENTER
		center = background.getSubimage(gap, gap, background.getWidth() - gap * 2, background.getHeight() - gap * 2);

		repaint();
		
	}

	@Override
	public void paintComponent(Graphics g) {

		if (center != null) {
			// CORNERS
			for (int i = 0; i < corners.length; i++) {
				g.drawImage(corners[i], (i % 2) * (getWidth() - gap), (i > 1 ? 1 : 0) * (getHeight() - gap), gap, gap, null);
			}
			// SIDES
			for (int i = 0; i < sidesX.length; i++) {
				g.drawImage(sidesX[i], gap, i * (getHeight() - gap), getWidth() - gap * 2, gap, null);
			}
			for (int i = 0; i < sidesY.length; i++) {
				g.drawImage(sidesY[i], i * (getWidth() - gap), gap, gap, getHeight() - gap * 2, null);
			}
			// CENTER
			g.drawImage(center, gap, gap, getWidth() - gap * 2, getHeight() - gap * 2, null);
		}

	}

}
