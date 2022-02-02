
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.crud;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public final class CRUD {
	public static final void setUp(String path) throws IOException {
		FileInputStream stream = new FileInputStream(path);
		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(stream))
				.build();
		FirebaseApp.initializeApp(options);
	}

	public static final void tearDown() {
		FirebaseApp app = FirebaseApp.getInstance();
		app.delete();
	}
}
