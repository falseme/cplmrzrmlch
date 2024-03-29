package net.falseme.rmlch.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Objects;

import javax.swing.JComponent;

public class ScreenComponent extends JComponent {
	private static final long serialVersionUID = 1l;

	protected BufferedImage[] corners = new BufferedImage[4];
	protected BufferedImage[] sidesX = new BufferedImage[2];
	protected BufferedImage[] sidesY = new BufferedImage[2];
	protected BufferedImage center;
	protected int gap = 0, screenGap = 0;

	protected String name;

	public ScreenComponent(int gap, int screen_gap, BufferedImage background) {

		this.gap = gap;
		this.screenGap = screen_gap;
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

	public void setCompName(String name) {
		this.name = name;
	}

	public String getCompName() {
		return name;
	}

	@Override
	public void paintComponent(Graphics g) {

		if (center != null) {
			// CORNERS
			for (int i = 0; i < corners.length; i++) {
				g.drawImage(corners[i], (i % 2) * (getWidth() - screenGap), (i > 1 ? 1 : 0) * (getHeight() - screenGap),
						screenGap, screenGap, null);
			}
			// SIDES
			for (int i = 0; i < sidesX.length; i++) {
				g.drawImage(sidesX[i], screenGap, i * (getHeight() - screenGap), getWidth() - screenGap * 2, screenGap,
						null);
			}
			for (int i = 0; i < sidesY.length; i++) {
				g.drawImage(sidesY[i], i * (getWidth() - screenGap), screenGap, screenGap, getHeight() - screenGap * 2,
						null);
			}
			// CENTER
			g.drawImage(center, screenGap, screenGap, getWidth() - screenGap * 2, getHeight() - screenGap * 2, null);
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScreenComponent other = (ScreenComponent) obj;
		return Objects.equals(name, other.name);
	}

}
