
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.crud.database.firestore;

import java.util.concurrent.ExecutionException;

import br.edu.insper.desagil.crud.database.DatabaseException;

public class FirestoreExecutionException extends DatabaseException {
	private static final long serialVersionUID = 1504460157379968648L;

	public FirestoreExecutionException(ExecutionException exception) {
		super("Firestore execution failed", exception);
	}
}
