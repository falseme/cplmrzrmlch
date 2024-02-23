package net.falseme.rmlch.event;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import net.falseme.rmlch.decode.Decoder;
import net.falseme.rmlch.ui.RadioButton;
import net.falseme.rmlch.ui.TextField;

public class DecodecEvent implements CaretListener {

	private TextField input, output;
	private long radiogroup;

	public DecodecEvent(TextField input, TextField output, long radiogroup) {

		this.input = input;
		this.output = output;

	}

	@Override
	public void caretUpdate(CaretEvent e) {

		output.setText(Decoder.decode(input.getText(),
				RadioButton.getActive(radiogroup) == null ? -1 : RadioButton.getActive(radiogroup).getId()));

	}

}
