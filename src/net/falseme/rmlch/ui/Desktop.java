package net.falseme.rmlch.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.layout.DesktopLayout;

public class Desktop extends JComponent {
	private static final long serialVersionUID = 1l;

	private static DesktopIcon focusIcon;

	public Desktop() {

		setLayout(new DesktopLayout());

		add(new DesktopIcon("Mi Equipo", Assets.MYPC, () -> {
			System.out.println("ASDASDAS");
		}));

		add(new DesktopIcon("Documentos", Assets.DOCUMENTS, () -> {

		}));

		add(new DesktopIcon("Decodec", Assets.EXE, () -> {

		}));

		add(new DesktopIcon("Test", Assets.FOLDER, () -> {

		}));

		add(new DesktopIcon("SECRET", Assets.LOCKED, () -> {

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
