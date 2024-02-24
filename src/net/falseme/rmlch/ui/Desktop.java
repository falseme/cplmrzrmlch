package net.falseme.rmlch.ui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.main.Directories;
import net.falseme.rmlch.ui.layout.DesktopLayout;
import net.falseme.rmlch.ui.window.DirWindow;

public class Desktop extends JComponent {
	private static final long serialVersionUID = 1l;

	private static DesktopIcon focusIcon;

	public Desktop(Screen parent) {

		setLayout(new DesktopLayout());

		add(new DesktopIcon("Mi Equipo", Assets.MYPC, () -> {
			parent.open(new DirWindow("Mi Equipo", "C:/Equipo/", Assets.MYPC[0], parent));
		}));

		add(new DesktopIcon("Documentos", Assets.DOCUMENTS, () -> {
			parent.open(new DirWindow("Documentos", "C:/Equipo/Documentos/", Assets.DOCUMENTS[0], parent));
		}));

		add(new DesktopIcon("Decodec", Assets.EXE, () -> {
			parent.open(Directories.application("Decodec", parent));
		}));

		add(new DesktopIcon("Secret2.exe", Assets.LOCKED, () -> {
			parent.open(Directories.application("Secret2.exe", parent));
		}));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setFocus(null);
				parent.hideStartMenu();
			}
		});

	}

	public static void setFocus(DesktopIcon icon) {
		if (focusIcon != null)
			focusIcon.setFocus(false);
		if (icon == null)
			return;
		icon.setFocus(true);
		focusIcon = icon;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(Assets.DESKTOP_SECRET, 0, 0, getWidth(), getHeight(), null);
	}

}
