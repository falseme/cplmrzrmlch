package net.falseme.rmlch.ui.window;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.event.WindowMotionEvent;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.ScreenComponent;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class Window extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	public static List<Window> openedWindows = new LinkedList<Window>();

	public static int WIDTH = 700, HEIGHT = 560;

	protected Header header;
	private String path;
	private BufferedImage icon;
	private boolean hidden = false;

	public Window(String title, String path, BufferedImage icon, Screen parent, int w, int h) {
		super(3, 3, Assets.WINDOW.getSubimage(0, Assets.WINDOW.getHeight() / 2 + 1, Assets.WINDOW.getWidth(),
				Assets.WINDOW.getHeight() / 2 - 1));

		setLayout(new WindowLayout());
		header = new Header(title, icon, parent);
		this.icon = icon;
		add(header);

		name = title;
		this.path = path;

		Random rand = new Random();
		int W = w <= 0 ? WIDTH : w;
		int H = h <= 0 ? HEIGHT : h;
		setBounds(rand.nextInt(parent.getWidth() - W - 100) + 50, rand.nextInt(parent.getHeight() - H - 100) + 50, W,
				H);

		WindowMotionEvent windowMotionEvent = new WindowMotionEvent(this);
		header.addMouseListener(windowMotionEvent);
		header.addMouseMotionListener(windowMotionEvent);

	}

	public BufferedImage getIcon() {
		return icon;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void doLayout() {
		super.doLayout();
		header.doLayout();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(header, path);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Window other = (Window) obj;
		return Objects.equals(header, other.header) && Objects.equals(path, other.path);
	}

}
