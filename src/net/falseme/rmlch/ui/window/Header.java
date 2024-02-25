package net.falseme.rmlch.ui.window;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.ScreenComponent;
import net.falseme.rmlch.ui.layout.WindowHeaderLayout;

public class Header extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	private JLabel label;
	protected Button min, close;

	public Header(String text, BufferedImage icon, Screen parent) {
		super(3, 3, Assets.WINDOW.getSubimage(0, 0, Assets.WINDOW.getWidth(), Assets.WINDOW.getHeight() / 2));

		setLayout(new WindowHeaderLayout());

		label = new JLabel(text, new ImageIcon(icon), JLabel.LEFT);
		label.setFont(Assets.w98);
		label.setForeground(Color.WHITE);
		add(label);

		min = new Button("", Assets.MIN, () -> {
			parent.hide((Window) getParent());
		});
		add(min);

		close = new Button("", Assets.CLOSE, () -> {
			parent.close((Window) getParent());
		});
		add(close);

	}

	public JLabel getLabel() {
		return label;
	}

}
