package net.falseme.rmlch.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.falseme.rmlch.ui.layout.ScreenLayout;

public class Screen extends JFrame {
	private static final long serialVersionUID = 1l;

	private JPanel panel;

	public Screen() {

		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		panel = new JPanel(new ScreenLayout());
		panel.setBackground(new Color(0, 96, 255));
		add(panel);
		
		panel.add(new Desktop());
		panel.add(new MenuBar());

	}

}
