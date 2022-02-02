package br.edu.insper.desagil.backend;

import br.edu.insper.desagil.backend.database.firestore.Firestore;
import br.edu.insper.desagil.backend.httpserver.HTTPServer;

public final class Backend {
	private static final int PORT = 8080;

	private static final boolean EXPOSE = false;

	private static final String CREDENTIALS = "firestore.json";

	public static final String URL = "http://192.168.15.39:8080";

	public static final boolean TEST = true;

	public static final String CREDENTIALS_TEST = "firestore_test.json";

	public static final void main(String[] args) {
		if (TEST) {
			Firestore.start(CREDENTIALS_TEST);
		} else {
			Firestore.start(CREDENTIALS);
		}
		HTTPServer.start(PORT, EXPOSE);
	}
}