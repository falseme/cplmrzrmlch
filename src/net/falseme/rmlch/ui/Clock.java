package net.falseme.rmlch.ui;

import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.Timer;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.layout.ButtonLayout;

public class Clock extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	private JLabel label;

	public Clock() {
		super(2, 4, Assets.INNER);

		setLayout(new ButtonLayout());

		label = new JLabel("00:00 AM", JLabel.CENTER);
		label.setFont(Assets.w98);
		add(label);

		Thread thr = new Thread(() -> {

			Timer timer = new Timer(1000, (event) -> {

				LocalDateTime ldt = LocalDateTime.now();
				boolean am = true;
				int h = ldt.getHour();
				if (h + 1 > 12)
					am = false;
				if (h == 0)
					h = 12;
				String hs = "" + h;
				if (hs.length() < 2)
					hs = "0" + hs;
				String min = "" + ldt.getMinute();
				if (min.length() < 2)
					min = "0" + min;
				Clock.this.label.setText(hs + ":" + min + " " + (am ? "AM" : "PM"));

			});

			timer.start();

		}, "Clock Thread");
		thr.start();

	}

}
