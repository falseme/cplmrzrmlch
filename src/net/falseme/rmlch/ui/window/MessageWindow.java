package net.falseme.rmlch.ui.window;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class MessageWindow extends Window {
	private static final long serialVersionUID = 1l;

	private JLabel label;

	public MessageWindow(String title, String message, Screen parent) {
		super(title, null, Assets.CHECK, parent, 300, 100);

		setLayout(new MessageWindowLayout());

		label = new JLabel(message, JLabel.CENTER);
		add(label);
		label.setForeground(Color.BLACK);
		label.setFont(Assets.w98);

	}

}

class MessageWindowLayout extends WindowLayout {

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);

		int W = parent.getWidth();
		int H = parent.getHeight() - parent.getComponent(0).getHeight();
		int h = (int) (H * 0.3);
		parent.getComponent(1).setBounds(0, (H - h) / 2 + parent.getComponent(0).getHeight(), W, h);

	}

}
