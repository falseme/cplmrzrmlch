package net.falseme.rmlch.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.falseme.rmlch.ui.layout.ScreenLayout;
import net.falseme.rmlch.ui.menu.MenuBar;
import net.falseme.rmlch.ui.menu.StartMenu;
import net.falseme.rmlch.ui.window.Window;

public class Screen extends JFrame {
	private static final long serialVersionUID = 1l;

	private JPanel mainPanel;
	private Desktop desktop;
	private MenuBar menuBar;
	private LoadingPanel loadingPanel;
	private StartMenu startMenu;

	public Screen() {

		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		loadingPanel = new LoadingPanel(this);
		add(loadingPanel);

		mainPanel = new JPanel(new ScreenLayout());
		mainPanel.setBackground(new Color(0, 96, 255));

		desktop = new Desktop(this);
		menuBar = new MenuBar(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void loadOS() {

		System.out.println("STARTING REMOLACHA-OS");

		remove(loadingPanel);
		mainPanel.add(desktop);
		mainPanel.add(menuBar);
		mainPanel.setComponentZOrder(menuBar, 0);
		add(mainPanel);

		setSize(0, 0);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	public boolean open(Window window) {
		if (Window.openedWindows.contains(window))
			return false;
		Window.openedWindows.add(window);
		mainPanel.add(window);
		mainPanel.setComponentZOrder(window, 1);
		Button barbtn = new Button("", window.getIcon(), () -> {
			if (window.isHidden()) {
				mainPanel.add(window);
			}
			mainPanel.setComponentZOrder(window, 1);
			window.repaint();
			window.doLayout();
		});
		barbtn.setCompName(window.getCompName());
		menuBar.add(barbtn);
		menuBar.doLayout();
		window.repaint();
		window.doLayout();
		return true;
	}

	public void close(Window window) {
		if (!Window.openedWindows.contains(window))
			return;
		Window.openedWindows.remove(window);
		mainPanel.remove(window);
		menuBar.close(window.getCompName());
		repaint();
	}

	public void hide(Window window) {
		if (!Window.openedWindows.contains(window))
			return;
		window.setHidden(true);
		mainPanel.remove(window);
		repaint();
	}

	public void showStartMenu() {

		if (startMenu == null)
			startMenu = new StartMenu(this);

		for (Component c : mainPanel.getComponents()) {
			if (c == startMenu) {
				mainPanel.remove(startMenu);
				mainPanel.doLayout();
				mainPanel.repaint();
				return;
			}
		}

		mainPanel.add(startMenu);
		mainPanel.setComponentZOrder(startMenu, 1);
		mainPanel.repaint();
		startMenu.doLayout();

	}

	public void hideStartMenu() {

		if (startMenu == null)
			return;

		for (Component c : mainPanel.getComponents()) {
			if (c == startMenu) {
				mainPanel.remove(startMenu);
				mainPanel.doLayout();
				mainPanel.repaint();
				break;
			}
		}

	}

	public void setDesktopBackground(Color background) {
		mainPanel.setBackground(background);
	}

	public Color getDesktopBackground() {
		return mainPanel.getBackground();
	}

	public int getDesktopHeight() {
		return getHeight() - menuBar.getHeight();
	}

}
