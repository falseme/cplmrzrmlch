package net.falseme.rmlch.ui.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.decode.Decoder;
import net.falseme.rmlch.event.Action;
import net.falseme.rmlch.event.DecodecEvent;
import net.falseme.rmlch.ui.RadioButton;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.TextField;
import net.falseme.rmlch.ui.layout.LayoutAdapter;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class DecodecWindow extends Window {
	private static final long serialVersionUID = 1l;

	TextField input;
	TextField output;
	JPanel radioContainer;

	public DecodecWindow(Screen parent) {
		super("DeCodec", "C:/Equipo/Decodec.exe", Assets.EXE[0], parent, 450, 320);

		setLayout(new DecodecWindowLayout());

		input = new TextField("entrada");
		output = new TextField("salida");
		output.setEditable(false);

		radioContainer = new JPanel(new RadioLayout());
		radioContainer.setBackground(new Color(0, 0, 0, 0));
		long radiogroup = 0;
		DecodecEvent decoEvent = new DecodecEvent(input, output, radiogroup);
		input.addCaretListener(decoEvent);

		Action action = () -> {
			decoEvent.caretUpdate(null);
		};
		radioContainer.add(new RadioButton("Tipo 0", Decoder.TYPE0, radiogroup, action));
		radioContainer.add(new RadioButton("Tipo 1", Decoder.TYPE1, radiogroup, action));
		radioContainer.add(new RadioButton("Tipo 2", Decoder.TYPE2, radiogroup, action));

		add(input);
		add(radioContainer);
		add(output);

	}

	public void doLayout() {
		super.doLayout();
		radioContainer.doLayout();
		for (Component c : radioContainer.getComponents()) {
			c.doLayout();
		}
		repaint();
	}

}

class RadioLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container parent) {

		int W = parent.getWidth();
		int H = parent.getHeight();

		int w = W / 3;
		for (int i = 0; i < parent.getComponentCount(); i++) {
			parent.getComponent(i).setBounds(i * w, 0, w, H);
		}

	}

}

class DecodecWindowLayout extends WindowLayout {

	// ESTO ES UN DESASTRE NO LO MIRES PORFA

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);
		int headerH = parent.getComponent(0).getHeight();

		int W = parent.getWidth();
		int H = parent.getHeight() - headerH;

		int H0 = H / 3;
		int w = (int) (W * 0.8);
		int h = (int) (H0 * 0.7);

		int x = (W - w) / 2;

		parent.getComponent(1).setBounds(x, H0 - h + headerH, w, h);
		parent.getComponent(3).setBounds(x, H0 * 2 + headerH, w, h);
		parent.getComponent(2).setBounds(x, 2 * H0 - h - (H0 - h) / 2 + headerH, w, h);

	}

}
