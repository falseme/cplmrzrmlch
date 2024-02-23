package net.falseme.rmlch.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.layout.DesktopLayout;
import net.falseme.rmlch.ui.window.DecodecWindow;
import net.falseme.rmlch.ui.window.DirWindow;
import net.falseme.rmlch.ui.window.SecretWindow;

public class Desktop extends JComponent {
	private static final long serialVersionUID = 1l;

	private static DesktopIcon focusIcon;

	public Desktop(Screen parent) {

		setLayout(new DesktopLayout());

		add(new DesktopIcon("Mi Equipo", Assets.MYPC, () -> {
			parent.open(new DirWindow("Mi Equipo", "C:/Equipo", Assets.MYPC[0], parent));
		}));

		add(new DesktopIcon("Documentos", Assets.DOCUMENTS, () -> {
			parent.open(new DirWindow("Documentos", "C:/Equipo/Documentos", Assets.DOCUMENTS[0], parent));
		}));

		add(new DesktopIcon("Decodec", Assets.EXE, () -> {
			parent.open(new DecodecWindow(parent));
		}));

		add(new DesktopIcon("SECRET", Assets.LOCKED, () -> {
			parent.open(new SecretWindow("SECRET2", "1234", "• • • • • • • • • • •", parent));
		}));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setFocus(null);
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

}
