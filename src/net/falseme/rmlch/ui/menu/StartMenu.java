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

public class StartMenu extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	public StartMenu(Screen screen) {
		super(2, 2, Assets.BUTTON);

		setBounds(0, screen.getDesktopHeight() - 280, 180, 280);
		setLayout(new StartMenuLayout());

		JButton minesweeper = new JButton("Buscaminas", new ImageIcon(Assets.FOLDER[0]));
		minesweeper.addMouseListener(new StartMenuButtonEvent(minesweeper));
		minesweeper.addActionListener((event) -> {
			System.out.println("Buscaminas");
		});
		add(minesweeper);

		JButton help = new JButton("Ayuda", new ImageIcon(Assets.FOLDER[0]));
		help.addMouseListener(new StartMenuButtonEvent(help));
		help.addActionListener((event) -> {
			System.out.println("Ayuda");
		});
		add(help);

		JButton settings = new JButton("Ajustes", new ImageIcon(Assets.FOLDER[0]));
		settings.addMouseListener(new StartMenuButtonEvent(settings));
		settings.addActionListener((event) -> {
			System.out.println("Ajustes");
		});
		add(settings);
		
		add(new Separator());
		
		JButton exit = new JButton("Apagar", new ImageIcon(Assets.FOLDER[0]));
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
