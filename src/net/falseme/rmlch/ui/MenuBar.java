package net.falseme.rmlch.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.layout.MenuBarLayout;

public class MenuBar extends JComponent {
	private static final long serialVersionUID = 1l;

	public MenuBar() {

		setBackground(new Color(192, 192, 192));
		setLayout(new MenuBarLayout());

		Button startBtn = new Button("    Exit", Assets.ICON, () -> {
			System.exit(0);
		});
		add(startBtn);
		add(new Separator());
		add(new Separator());
		add(new Clock());

	}

	public void paintComponent(Graphics g) {

		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());

	}

}
