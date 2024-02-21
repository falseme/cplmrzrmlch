package net.falseme.rmlch.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.event.Action;
import net.falseme.rmlch.event.ButtonActionListener;
import net.falseme.rmlch.ui.layout.ButtonLayout;

public class Button extends JComponent {
	private static final long serialVersionUID = 1l;

	private BufferedImage background;
	private BufferedImage icon = null;

	private JLabel label;

	public Button(String text) {

		setLayout(new ButtonLayout());

		label = new JLabel(text + "   ");
		label.setFont(Assets.w98);
		label.setHorizontalAlignment(JLabel.RIGHT);
		add(label);

		background = Assets.BUTTON;

	}

	public Button(String text, BufferedImage icon, Action action) {

		this(text);
		this.icon = icon;
		addMouseListener(new ButtonActionListener(this, action));

	}

	public void setBackground(BufferedImage bg) {
		background = bg;
		repaint();
	}

	public void paintComponent(Graphics g) {

		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		if (icon != null) {
			int icongap = 2;
			g.drawImage(icon, icongap, icongap, getHeight() - icongap * 2, getHeight() - icongap * 2, null);
		}

	}

}
