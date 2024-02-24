package net.falseme.rmlch.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.falseme.rmlch.ui.layout.ScreenLayout;
import net.falseme.rmlch.ui.menubar.MenuBar;
import net.falseme.rmlch.ui.window.Window;

public class Screen extends JFrame {
	private static final long serialVersionUID = 1l;

	private JPanel mainPanel;
	private Desktop desktop;
	private MenuBar menuBar;
	private LoadingPanel loadingPanel;

	public Screen() {

		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		loadingPanel = new LoadingPanel(this);
		add(loadingPanel);

		mainPanel = new JPanel(new ScreenLayout());
		mainPanel.setBackground(new Color(0, 96, 255));

		desktop = new Desktop(this);
		menuBar = new MenuBar();

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

	public void open(Window window) {
		if (Window.openedWindows.contains(window))
			return;
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

	public int getDesktopHeight() {
		return getHeight() - menuBar.getHeight();
	}

}
