package net.falseme.rmlch.audio;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import com.mpatric.mp3agic.Mp3File;

import net.falseme.rmlch.assets.Loader;

public class Song {

	private String songTitle;
	private AudioFile audioFile;
	private Mp3File mp3File = null;
	private double songLength;
	private double frameRatePerMillisecond;

	public Song(String name) {

		audioFile = Loader.loadAudioFile("/assets/sounds/" + name);
		try {
			mp3File = new Mp3File(audioFile.getFile());
			songLength = mp3File.getLengthInMilliseconds();
			frameRatePerMillisecond = ((double) mp3File.getFrameCount()) / songLength;
		} catch (Exception e) {
			frameRatePerMillisecond = 0;
			songLength = 0;
			e.printStackTrace();
		}

		Tag tag = audioFile.getTag();
		if (tag != null)
			songTitle = tag.getFirst(FieldKey.TITLE);
		else
			songTitle = "N/A";

	}

	public String getTitle() {
		return songTitle;
	}

	public AudioFile getAudioFile() {
		return audioFile;
	}

	public double getFrameRatePerMilliseconds() {
		return frameRatePerMillisecond;
	}

	public double getLength() {
		return songLength;
	}
	
	public Mp3File getMp3File() {
		return mp3File;
	}

}
