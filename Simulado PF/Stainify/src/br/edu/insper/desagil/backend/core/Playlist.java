package br.edu.insper.desagil.backend.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private Integer id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	public Playlist(Integer id, List<Track> tracks) {
		this.id = id;
		this.tracks = tracks;
		this.ratings = new HashMap<>();
	}

	public Integer getId() {
		return this.id;
	}

	public List<Track> getTracks() {
		return this.tracks;
	}

	public Map<String, Integer> getRatings() {
		return this.ratings;
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String username, Integer rating) {
		this.ratings.put(username, rating);
	}
	
	//public double averageRatings
}
