package net.falseme.rmlch.audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import net.falseme.rmlch.ui.Slider;

public class MusicPlayer extends PlaybackListener {

	private static final Object playSignal = new Object();

	private Song currentSong;
	private Slider songSlider;

	private AdvancedPlayer advancedPlayer;
	private boolean songFinished = false;
	private boolean isPaused = false;
	private boolean isPlaying = false;
	private int pausedTime = 0;
	private int currentTimeMillis = 0;

	public MusicPlayer(Slider slider) {
		songSlider = slider;
	}

	public void loadSong(Song song) {

		currentSong = song;

		if (currentSong == null)
			return;

		songSlider.setMaximum(song.getMp3File().getFrameCount());
		songSlider.setValue(0);
		playSong();

	}

	public void playSong() {
		if (currentSong == null)
			return;

		if (isPlaying)
			return;

		try {

			FileInputStream fileStream = new FileInputStream(currentSong.getAudioFile().getFile());
			BufferedInputStream bufferedStream = new BufferedInputStream(fileStream);

			advancedPlayer = new AdvancedPlayer(bufferedStream);
			advancedPlayer.setPlayBackListener(this);

			isPlaying = true;

			startMusicThread();
			startPlaybackSliderThread();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pauseSong() {

		if (advancedPlayer == null)
			return;

		if (songFinished)
			return;

		isPaused = true;
		stopSong();

	}

	public void stopSong() {

		if (advancedPlayer == null)
			return;

		if (songFinished)
			return;

		advancedPlayer.stop();
		advancedPlayer.close();
		advancedPlayer = null;

	}

	private void startMusicThread() {

		new Thread(() -> {

			try {

				if (isPaused) {
					synchronized (playSignal) {
						isPaused = false;

						playSignal.notify();
					}

					advancedPlayer.play(pausedTime, Integer.MAX_VALUE);
				} else {
					advancedPlayer.play();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}, "AudioPlayer Thread").start();

	}

	private void startPlaybackSliderThread() {

		System.out.println("paused: " + isPaused);
		System.out.println("finished: " + songFinished);

		new Thread(() -> {
			if (isPaused) {
				try {
					synchronized (playSignal) {
						playSignal.wait();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			long start = System.nanoTime();
			while (!isPaused && !songFinished) {
				try {

					long current = System.nanoTime();

					currentTimeMillis += current / 1000000 - start / 1000000;
					int calculatedFrame = (int) ((double) currentTimeMillis
							* currentSong.getFrameRatePerMilliseconds());
					songSlider.setValue(calculatedFrame);

					start = current;
					Thread.sleep(1);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	public int getCurrentTimeMillis() {
		return currentTimeMillis;
	}

	@Override
	public void playbackStarted(PlaybackEvent e) {

		System.out.println("MusicPlayer Playback Started!");
		songFinished = false;

	}

	@Override
	public void playbackFinished(PlaybackEvent e) {

		System.out.println("MusicPlayer Playback Finished!");

		if (isPaused) {
			pausedTime += (int) ((double) e.getFrame() * currentSong.getFrameRatePerMilliseconds());
		} else {
			songFinished = true;
			pausedTime = 0;
			currentTimeMillis = 0;
		}

		isPlaying = false;
		System.out.println("Stopped At: " + pausedTime + " : " + currentTimeMillis);

	}

}
