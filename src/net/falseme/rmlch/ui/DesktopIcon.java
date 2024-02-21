package net.falseme.rmlch.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.event.Action;
import net.falseme.rmlch.event.DesktopIconEvent;
import net.falseme.rmlch.ui.layout.DesktopIconLayout;

public class DesktopIcon extends JComponent {
	private static final long serialVersionUID = 1l;

	private BufferedImage[] icons;
	private int icon;
	private JLabel label;

	public DesktopIcon(String text, BufferedImage[] icons, Action action) {

		setLayout(new DesktopIconLayout());

		label = new JLabel(text, JLabel.CENTER) {
			private static final long serialVersionUID = 1l;

			@Override
			public void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		label.setVerticalAlignment(JLabel.BOTTOM);
		label.setFont(Assets.w98);
		label.setForeground(Color.WHITE);
		add(label);

		this.icons = icons;
		icon = 0;

		addMouseListener(new DesktopIconEvent(this, action));
		label.setBackground(new Color(0, 0, 0, 0));

	}

	public void setFocus(boolean focus) {
		if (focus) {
			label.setBackground(new Color(0, 0, 192, 96));
			icon = 1;
		} else {
			label.setBackground(new Color(0, 0, 0, 0));
			icon = 0;
		}
		repaint();
		label.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

//		g.setColor(Color.RED);
//		g.fillRect(0, 0, getWidth(), getHeight());

		int size = (int) (getHeight() * 0.6);
		int y = (int) (getHeight() * 0.08);
		g.drawImage(icons[icon], (getWidth() - size) / 2, y, size, size, null);

	}

}
