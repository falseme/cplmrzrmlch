package net.falseme.rmlch.ui.menubar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Clock;
import net.falseme.rmlch.ui.ScreenComponent;
import net.falseme.rmlch.ui.layout.MenuBarLayout;

public class MenuBar extends JComponent {
	private static final long serialVersionUID = 1l;

	public MenuBar() {

		setBackground(new Color(192, 192, 192));
		setLayout(new MenuBarLayout());

		Button startBtn = new Button("    Salir", Assets.ICON, () -> {
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

	public void close(String compName) {
		for (Component c : getComponents()) {
			if (c.getClass().getName().startsWith("net.falseme")) {
				if (((ScreenComponent) c).getCompName() == null)
					continue;
				if (((ScreenComponent) c).getCompName().equals(compName)) {
					remove(c);
					return;
				}
			}
		}
	}

}
