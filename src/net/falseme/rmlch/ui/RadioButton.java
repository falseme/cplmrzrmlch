package net.falseme.rmlch.ui;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.event.RadioButtonEvent;
import net.falseme.rmlch.ui.layout.ButtonLayout;

public class RadioButton extends ScreenComponent {
	private static final long serialVersionUID = 1l;

	private static HashMap<Long, LinkedList<RadioButton>> radioGroup = new HashMap<Long, LinkedList<RadioButton>>();

	private boolean active = false;
	private long group;
	private int id;

	public RadioButton(String text, int id, long group) {
		super(1, 1, Assets.RADIO);

		this.group = group;
		this.id = id;

		setLayout(new ButtonLayout());
		JLabel label = new JLabel(text, JLabel.CENTER);
		label.setFont(Assets.w98);
		add(label);

		if (radioGroup.containsKey(group)) {
			radioGroup.get(group).add(this);
		} else {
			radioGroup.put(group, new LinkedList<RadioButton>());
			active = true;
			setBackground(Assets.RADIO_ACTIVE);
			radioGroup.get(group).add(this);
		}

		addMouseListener(new RadioButtonEvent(this));

	}

	public void setActive() {
		active = true;
		setBackground(Assets.RADIO_ACTIVE);
		for (RadioButton rb : radioGroup.get(group)) {
			if (rb == this)
				continue;
			rb.active = false;
			rb.setBackground(Assets.RADIO);
		}
		getParent().getParent().doLayout();
	}

	public boolean isActive() {
		return active;
	}

	public long getGroup() {
		return group;
	}

	public int getId() {
		return id;
	}

	public static RadioButton getActive(long group) {
		if (!radioGroup.containsKey(group))
			return null;
		for (RadioButton rb : radioGroup.get(group))
			if (rb.isActive())
				return rb;
		return null;
	}

	public void paintComponent(Graphics g) {
		int gap = (getHeight() - center.getHeight()) / 2;
		g.drawImage(center, gap / 2, gap, null);
	}

}
