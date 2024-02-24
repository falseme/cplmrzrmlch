package net.falseme.rmlch.ui;

import java.awt.Color;
import java.awt.Container;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.layout.LayoutAdapter;

public class LoadingPanel extends JPanel {
	private static final long serialVersionUID = 1l;

	private final String[] lines = new String[] { " \n", "Starting...\n ", "Product Key: Beetroot 96", " \n \n",
			"License provided by Root Technology. Inc..", "CD-ROM device driver",
			"(C)Copyright Root Technology Inc. 1996\n       Device Name            :  BRTCD005E\n       Transfer Mode          :  Programmed I/O\n       Number of Drives       :  1",
			" \n \n", "MODE prepare code page function completed\n ", "MODE select code page function completed" };
	private int count = 0;

	private Thread thr;
	private Timer timer;

	public LoadingPanel(Screen parent) {

		setBackground(Color.BLACK);
		setLayout(new LoadingLayout());

		thr = new Thread(() -> {
			timer = new Timer(500, (event) -> {

				if (count >= lines.length) {
					stopThread();
					parent.loadOS();
					return;
				}

				updateDelay();

				String ss[] = lines[count++].split("\n");
				for (String s : ss) {
					JLabel label = new JLabel(s);
					label.setFont(Assets.w98);
					label.setForeground(Color.WHITE);
					add(label);
				}
				doLayout();
				repaint();

			});
			timer.start();
		});
		thr.start();

	}

	private void stopThread() {
		timer.stop();
		thr.interrupt();
	}

	private void updateDelay() {
		Random rand = new Random();
		timer.setDelay(rand.nextInt(100) + 50);
	}

}

class LoadingLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		for (int i = 0; i < parent.getComponentCount(); i++) {

			int h = parent.getComponent(i).getPreferredSize().height;
			parent.getComponent(i).setBounds(5, i * h, parent.getWidth() / 2, h);

		}

	}

}