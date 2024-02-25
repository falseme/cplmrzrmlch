package net.falseme.rmlch.ui.window;

import java.awt.Container;

import javax.swing.event.ChangeListener;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.audio.MusicPlayer;
import net.falseme.rmlch.audio.Song;
import net.falseme.rmlch.event.Action;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.Slider;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class Mp3PlayerWindow extends Window {
	private static final long serialVersionUID = 1l;

	private SongSlider songSlider;

	public Mp3PlayerWindow(String mp3File, Screen parent) {
		super("Mp3Player - " + mp3File, null, Assets.MUSIC[0], parent, 500, 200);

		setLayout(new Mp3PlayerLayout());

		Song song = new Song(mp3File);
		songSlider = new SongSlider(0, (int) song.getLength(), 0, null);
		add(songSlider);

		MusicPlayer player = new MusicPlayer(songSlider);
		player.loadSong(song);

		add(new Button("", Assets.PLAY, () -> {
			player.playSong();
		}));
		add(new Button("", Assets.PAUSE, () -> {
			player.pauseSong();
		}));
		add(new Button("", Assets.STOP, () -> {
			player.stopSong();
		}));

		Action action = header.close.action();
		header.close.setAction(() -> {
			action.run();
			player.stopSong();
		});

	}

}

class Mp3PlayerLayout extends WindowLayout {

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);

		int W = (int) (parent.getWidth() * 0.8);
		int H = (int) ((parent.getHeight() - HEADER_HEIGHT) * 0.3);
		int YGAP = (parent.getHeight() - HEADER_HEIGHT - H * 2) / 3;

		parent.getComponent(1).setBounds((parent.getWidth() - W) / 2, YGAP + HEADER_HEIGHT, W, H);
		W = (int) (H * 1.2);
		int XGAP = 15;
		parent.getComponent(2).setBounds((parent.getWidth() - W) / 2 - XGAP - W, YGAP * 2 + H + HEADER_HEIGHT, H, H);
		parent.getComponent(3).setBounds((parent.getWidth() - W) / 2, YGAP * 2 + H + HEADER_HEIGHT, H, H);
		parent.getComponent(4).setBounds((parent.getWidth() + W) / 2 + XGAP, YGAP * 2 + H + HEADER_HEIGHT, H, H);

	}

}

class SongSlider extends Slider {
	private static final long serialVersionUID = 1l;

	public SongSlider(int min, int max, int value, ChangeListener listener) {
		super(min, max, value, listener);
		handler = Assets.SLIDER_HANDLER_SQUARE;
		removeMouseListener(getMouseListeners()[0]);
	}

}
