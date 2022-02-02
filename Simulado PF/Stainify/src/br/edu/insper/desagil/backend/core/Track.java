package br.edu.insper.desagil.backend.core;

public class Track {
	private Artist artist;
	private String name;
	private Integer duration;
	
	public Track(Artist artist, String name, Integer duration) {
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}

	public Artist getArtist() {
		return this.artist;
	}

	public String getName() {
		return this.name;
	}

	public Integer getDuration() {
		return this.duration;
	}
	
	public String getDurationString() {
		int secInMins = 60;
		int secsRemainder = this.duration % secInMins;
		int fullMinsInSecs = this.duration - secsRemainder;
		int mins = fullMinsInSecs/secInMins;
		String durationString;
		if (secsRemainder < 10) {
			durationString = mins + ":0" + secsRemainder;
		} else {
			durationString = mins + ":" + secsRemainder;
		}
		
		return durationString;
	}
	
	public String getFullArtistName() {
		return this.artist.getName();
	}
	
	
	
}
