
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.crud.database.firestore;

public abstract class AutokeyFirestoreObject extends FirestoreObject {
	private String key;

	public final String getKey() {
		return key;
	}

	public final void setKey(String key) {
		this.key = key;
	}

	@Override
	public final String key() {
		return getKey();
	}
}
