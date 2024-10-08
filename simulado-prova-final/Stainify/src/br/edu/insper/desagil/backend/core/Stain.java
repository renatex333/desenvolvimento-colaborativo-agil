// NÃO MODIFIQUE NEM SUBSTITUA ESTE ARQUIVO

package br.edu.insper.desagil.backend.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stain {
	private List<Map<String, String>> tracks;
	private double rating;

	public Stain(Playlist playlist) {
		tracks = new ArrayList<>();
		for (Track track : playlist.getTracks()) {
			Map<String, String> map = new HashMap<>();
			map.put("performer", track.getFullArtistName());
			map.put("name", track.getName());
			map.put("duration", track.getDurationString());
			tracks.add(map);
		}
		rating = playlist.averageRatings();
	}

	public List<Map<String, String>> getTracks() {
		return tracks;
	}

	public double getRating() {
		return rating;
	}
}
