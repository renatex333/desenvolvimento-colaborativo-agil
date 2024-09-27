package br.edu.insper.desagil.backend.core;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track{
	private List<Artist> collaborators;
	
	public CollaborationTrack(Artist artist, String name, Integer duration, List<Artist> collaborators) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	
	}
	
	@Override
	public String getFullArtistName() {
		String fullArtistName;
		String mainArtistName = this.getArtist().getName();
		List<String> collabArtistsNames = new ArrayList<>();
		for(Artist artist: this.collaborators) {
			collabArtistsNames.add(artist.getName());
		}
		String artistsNamesString = String.join(",", collabArtistsNames);
		
		fullArtistName = mainArtistName + " (feat. " + artistsNamesString + ")";
		
		return fullArtistName;
	}

}
