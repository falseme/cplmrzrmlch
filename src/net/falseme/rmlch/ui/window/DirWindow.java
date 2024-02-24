package net.falseme.rmlch.ui.window;

import java.awt.Component;
import java.awt.Container;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.main.Directories;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.DesktopIcon;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.ScreenComponent;
import net.falseme.rmlch.ui.TextField;
import net.falseme.rmlch.ui.layout.LayoutAdapter;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class DirWindow extends Window {
	private static final long serialVersionUID = 1l;

	Screen parent;
	DirPathHeader dirHeader;
	DirPanel panel;

	public DirWindow(String title, String path, BufferedImage icon, Screen parent) {
		super(title, path, icon, parent, 0, 0);

		this.parent = parent;

		setLayout(new DirWindowLayout());
		dirHeader = new DirPathHeader(this, path);
		add(dirHeader);
		panel = new DirPanel(this, path, parent);
		add(panel);

	}

	public void doLayout() {
		super.doLayout();
		for (Component c : getComponents()) {
			c.doLayout();
		}
	}

	public void changeDir(String path) {

		dirHeader.setDir("  " + path);
		remove(panel);
		panel = new DirPanel(this, path, parent);
		add(panel);
		doLayout();

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

	JLabel label;
	TextField dirdisplay;

	public DirPathHeader(DirWindow parent, String path) {
		super(2, 2, Assets.BUTTON_INACTIVE);

		setLayout(new DirPathHeaderLayout());
		label = new JLabel("Dirección", JLabel.CENTER);
		label.setFont(Assets.w98);
		add(label);

		dirdisplay = new TextField("  " + path);
		dirdisplay.setEditable(false);
		add(dirdisplay);

		add(new Button("", Assets.BACK, () -> {
			String p = dirdisplay.getText().trim();
			p = p.substring(0, p.lastIndexOf('/'));
			if (charCount(p, '/') <= 1)
				return;
			parent.changeDir(p.substring(0, p.lastIndexOf('/') + 1));
		}));

	}

	public void setDir(String text) {
		dirdisplay.setText(text);
	}

	private int charCount(String s, char c) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				count++;
		}
		return count;
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
				W - parent.getComponent(0).getWidth() - gap * 4 - h, h);
		parent.getComponent(2).setBounds(W - h - gap, gap, h, h);

	}

}

class DirPanel extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	public DirPanel(DirWindow parent, String path, Screen screen) {
		super(2, 2, Assets.INNER);

		System.out.println(path);
		setLayout(new DirPanelLayout());

		for (String s : Directories.get(path)) {

			if (s.endsWith("/"))
				add(new DesktopIcon(s.substring(0, s.length() - 1), Assets.FOLDER, () -> {
					parent.changeDir(path + s);
				}));
			else if (s.endsWith(".exe"))
				add(new DesktopIcon(s, s.toLowerCase().startsWith("secret") ? Assets.LOCKED : Assets.EXE, () -> {
					screen.open(Directories.application(s, screen));
				}));

		}

	}

	public void doLayout() {
		super.doLayout();
		for (Component c : getComponents()) {
			c.doLayout();
		}
	}

}

class DirPanelLayout extends LayoutAdapter {

	private static final int MIN_SIZE = 100;

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth();

		int count = W / MIN_SIZE;
		int SIZE = W / count;
		int GAP = (W - (SIZE * count)) / 2;

		int x = GAP;
		int y = 0;
		for (int i = 0; i < parent.getComponentCount(); i++) {
			if (i % count == 0 && i != 0) {
				x = GAP;
				y += SIZE;
			}
			parent.getComponent(i).setBounds(x, y, SIZE, SIZE);
			x += SIZE;
		}

	}

}
