package net.falseme.rmlch.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import net.falseme.rmlch.assets.Assets;

public class TextField extends JTextField {
	private static final long serialVersionUID = 1l;

	ScreenComponent background;

	public TextField(String placeholder) {
		super(placeholder, JTextField.LEFT);
		
		setBorder(BorderFactory.createLoweredBevelBorder());
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(Assets.w98);

		background = new ScreenComponent(2, 2, Assets.TOGGLE_ACTIVE);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		background.paintComponent(g);
	}

}
