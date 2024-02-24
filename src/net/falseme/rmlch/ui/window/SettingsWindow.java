package net.falseme.rmlch.ui.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.Slider;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class SettingsWindow extends Window {
	private static final long serialVersionUID = 1l;

	private Color backgroundColor;
	private Slider slider;

	public SettingsWindow(Screen parent) {
		super("Ajustes", null, Assets.SETTINGS, parent, 500, 400);

		backgroundColor = parent.getDesktopBackground();

		setLayout(new SettingsLayout());

		JLabel label = new JLabel("Fondo de Pantalla", JLabel.CENTER);
		label.setFont(Assets.w98);
		label.setForeground(Color.BLACK);
		add(label);

		slider = new Slider(60, 120, backgroundColor.getGreen(), (event) -> {
			backgroundColor = new Color(backgroundColor.getRed(), getSliderValue(), backgroundColor.getBlue());
			repaint();
		});
		add(slider);

		add(new Button("Guardar", null, () -> {
			parent.setDesktopBackground(backgroundColor);
		}));

	}

	private int getSliderValue() {
		return slider.getValue();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = (int) (getWidth() * 0.4);
		g.setColor(backgroundColor);
		g.fillRect((getWidth() - w) / 2, 100, w, w * 2 / 3);

	}

	public void doLayout() {
		super.doLayout();
		for (Component c : getComponents())
			c.doLayout();
	}

}

class SettingsLayout extends WindowLayout {

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);

		int W = (int) (parent.getWidth() * 0.7);
		parent.getComponent(1).setBounds((parent.getWidth() - W) / 2, 60, W, 20);
		parent.getComponent(2).setBounds((parent.getWidth() - W) / 2, parent.getHeight() - 130, W, 21);
		W = (int) (parent.getWidth() * 0.25);
		parent.getComponent(3).setBounds((parent.getWidth() - W) / 2, parent.getHeight() - 70, W, 32);

	}

}
