package net.falseme.rmlch.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.event.Action;
import net.falseme.rmlch.event.ButtonActionListener;
import net.falseme.rmlch.ui.layout.ButtonLayout;

public class Button extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	private BufferedImage icon = null;

	private JLabel label;

	public Button(String text) {
		super(2, 4, Assets.BUTTON);

		setLayout(new ButtonLayout());

		label = new JLabel(text, JLabel.CENTER);
		label.setFont(Assets.w98);
		add(label);

	}

	public Button(String text, BufferedImage icon, Action action) {

		this(text);
		this.icon = icon;
		addMouseListener(new ButtonActionListener(this, action));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (icon != null) {
			int icongap = 2;
			g.drawImage(icon, icongap, icongap, getHeight() - icongap * 2, getHeight() - icongap * 2, null);
		}

	}

}
