package net.falseme.rmlch.ui.window;

import java.awt.Component;
import java.awt.Container;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.ScreenComponent;
import net.falseme.rmlch.ui.TextField;
import net.falseme.rmlch.ui.layout.LayoutAdapter;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class DirWindow extends Window {
	private static final long serialVersionUID = 1l;

	public DirWindow(String title, String path, BufferedImage icon, Screen parent) {
		super(title, path, icon, parent, 0, 0);

		setLayout(new DirWindowLayout());
		add(new DirPathHeader(path));
		add(new DirPanel());

	}

	public void doLayout() {
		super.doLayout();
		for (Component c : getComponents()) {
			c.doLayout();
		}
	}

}

class DirWindowLayout extends WindowLayout {

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);
		final int headerH = parent.getComponent(0).getHeight();

		int W = parent.getWidth();
		int H = parent.getHeight() - headerH;
		int w = (int) (W * 0.98);
		int gap = (W - w) / 4;
		int headerDirH = (int) (headerH * 1.5);

		// dirpathheader
		parent.getComponent(1).setBounds((W - w) / 2, headerH + gap, w, headerDirH);
		// dirpanel
		parent.getComponent(2).setBounds((W - w) / 2, gap * 2 + headerH + headerDirH, w, H - headerDirH - gap * 4);

	}

}

class DirPathHeader extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	public DirPathHeader(String path) {
		super(2, 2, Assets.BUTTON_INACTIVE);

		setLayout(new DirPathHeaderLayout());
		JLabel label = new JLabel("Dirección", JLabel.CENTER);
		label.setFont(Assets.w98);
		add(label);

		TextField dirdisplay = new TextField("  " + path);
		dirdisplay.setEditable(false);
		add(dirdisplay);

	}

}

class DirPathHeaderLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth();
		int H = parent.getHeight();
		int h = (int) (H * 0.8);
		int gap = (H - h) / 2;

		parent.getComponent(0).setBounds(gap, gap, h * 3, h);
		parent.getComponent(1).setBounds(gap * 2 + parent.getComponent(0).getWidth(), gap,
				W - parent.getComponent(0).getWidth() - gap * 3, h);

	}

}

class DirPanel extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	public DirPanel() {
		super(2, 2, Assets.INNER);
	}

}

class DirPanelLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

	}

}
