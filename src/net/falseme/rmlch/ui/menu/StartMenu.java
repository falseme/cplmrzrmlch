package net.falseme.rmlch.ui.menu;

import java.awt.Component;
import java.awt.Container;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.event.Action;
import net.falseme.rmlch.event.StartMenuButtonEvent;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.ScreenComponent;
import net.falseme.rmlch.ui.layout.LayoutAdapter;
import net.falseme.rmlch.ui.window.DirWindow;
import net.falseme.rmlch.ui.window.HelpWindow;
import net.falseme.rmlch.ui.window.MineSweeperWindow;
import net.falseme.rmlch.ui.window.SettingsWindow;

public class StartMenu extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	public StartMenu(Screen screen) {
		super(2, 2, Assets.BUTTON);

		setBounds(0, screen.getDesktopHeight() - 350, 180, 350);
		setLayout(new StartMenuLayout());

		JButton mypc = new JButton("Equipo", new ImageIcon(Assets.MYPC[0]));
		mypc.addMouseListener(new StartMenuButtonEvent(mypc));
		mypc.addActionListener((event) -> {
			screen.hideStartMenu();
			screen.open(new DirWindow("Mi Equipo", "C:/Equipo/", Assets.MYPC[0], screen));
		});
		add(mypc);

		JButton settings = new JButton("Ajustes", new ImageIcon(Assets.SETTINGS));
		settings.addMouseListener(new StartMenuButtonEvent(settings));
		settings.addActionListener((event) -> {
			screen.hideStartMenu();
			screen.open(new SettingsWindow(screen));
		});
		add(settings);

		JButton minesweeper = new JButton("Buscaminas", new ImageIcon(Assets.WINMINE));
		minesweeper.addMouseListener(new StartMenuButtonEvent(minesweeper));
		minesweeper.addActionListener((event) -> {
			screen.hideStartMenu();
			screen.open(new MineSweeperWindow(screen));
		});
		add(minesweeper);

		JButton help = new JButton("Ayuda", new ImageIcon(Assets.HELP));
		help.addMouseListener(new StartMenuButtonEvent(help));
		help.addActionListener((event) -> {
			screen.hideStartMenu();
			screen.open(new HelpWindow(screen));
		});
		add(help);

		add(new Separator());

		JButton exit = new JButton("Apagar", new ImageIcon(Assets.TURNOFF));
		exit.addMouseListener(new StartMenuButtonEvent(exit));
		exit.addActionListener((event) -> {
			System.exit(0);
		});
		add(exit);

	}

	public void doLayout() {
		super.doLayout();
		for (Component c : getComponents()) {
			c.doLayout();
		}
	}

}

class MenuButton extends Button {
	private static final long serialVersionUID = 1l;

	public MenuButton(String text, BufferedImage icon, Action action) {
		super(text, icon, action);

	}

}

class StartMenuLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int w = parent.getWidth() - 4; // 4-pixel border
		int h = (parent.getHeight() - 3 - 4) / (parent.getComponentCount() - 1); // 3-pixel separator line

		for (int i = 0; i < parent.getComponentCount() - 1; i++) {
			parent.getComponent(i).setBounds(2, 2 + i * h, w, h);
		}
		parent.getComponent(parent.getComponentCount() - 2).setSize(w, 3);
		parent.getComponent(parent.getComponentCount() - 1).setBounds(2, parent.getHeight() - h - 2, w, h);

	}

}
