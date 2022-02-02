// NÃO MODIFIQUE NEM SUBSTITUA ESTE ARQUIVO

package br.edu.insper.desagil.backend.endpoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import br.edu.insper.desagil.backend.core.Artist;
import br.edu.insper.desagil.backend.core.CollaborationTrack;
import br.edu.insper.desagil.backend.core.Playlist;
import br.edu.insper.desagil.backend.core.Stain;
import br.edu.insper.desagil.backend.core.Track;
import br.edu.insper.desagil.backend.httpserver.Args;
import br.edu.insper.desagil.backend.httpserver.Endpoint;

public class StainEndpoint extends Endpoint<Stain> {
	private Map<String, Stain> stains;

	public StainEndpoint() {
		super("/playlist");

		Artist artist = new Artist("Anitta");

		Playlist playlist = new Playlist(5);
		playlist.addTrack(new Track(artist, "Atencion", 160));
		playlist.addTrack(new CollaborationTrack(artist, Arrays.asList(new Artist("Becky G")), "Banana", 195));
		playlist.addTrack(new CollaborationTrack(artist, Arrays.asList(new Artist("Ludmilla"), new Artist("Snoop Dog")), "Onda Diferente", 160));
		playlist.putRating("anitta", 6);
		playlist.putRating("ludmilla", 0);

		stains = new HashMap<>();
		stains.put(Integer.toString(playlist.getId()), new Stain(playlist));
	}

	@Override
	public Stain get(Args args) {
		String id = args.get("id");
		return stains.get(id);
	}
}
