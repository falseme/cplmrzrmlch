package net.falseme.rmlch.ui.window;

import java.awt.Container;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.TextField;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class SecretWindow extends Window {
	private static final long serialVersionUID = 1l;

	private Button acceptBtn;
	private TextField textField;

	public SecretWindow(String title, String secretKey, String secretMessage, Screen parent) {
		super(title, null, Assets.LOCKED[0], parent, 300, 200);

		setLayout(new SecretLayout());

		textField = new TextField("Contraseña");
		add(textField);

		acceptBtn = new Button("Aceptar", null, () -> {
			if (textField.getText().equals(secretKey)) {
				parent.close(SecretWindow.this);
				parent.open(new MessageWindow(title, secretMessage, parent, getX() + 25, getY() + 40));
			}
		});
		add(acceptBtn);

	}

	public void doLayout() {
		super.doLayout();
		acceptBtn.doLayout();
	}

}

class SecretLayout extends WindowLayout {

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);

		int W = parent.getWidth();
		int H = parent.getHeight();

		// JTEXTFIELD
		int w = (int) (W * 0.85);
		int h = (int) (H * 0.2);
		parent.getComponent(1).setBounds((W - w) / 2, H / 2 - h / 2, w, h);

		// BUTTON
		w = (int) (W * 0.4);
		h = (int) (H * 0.2);
		parent.getComponent(2).setBounds((W - w) / 2, (int) (H - h * 1.5), w, h);

	}

}
