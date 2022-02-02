
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.crud.database.firestore;

import br.edu.insper.desagil.crud.database.DatabaseException;

public class FirestoreInterruptedException extends DatabaseException {
	private static final long serialVersionUID = -7120340463326344022L;

	public FirestoreInterruptedException(InterruptedException exception) {
		super("Firestore execution interrupted", exception);
	}
}
