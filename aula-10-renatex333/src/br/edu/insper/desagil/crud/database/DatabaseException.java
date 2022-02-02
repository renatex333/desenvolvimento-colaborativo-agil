
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.crud.database;

public class DatabaseException extends Exception {
	private static final long serialVersionUID = -8844324968161855473L;

	public DatabaseException(String name, Exception exception) {
		super(name + ": " + exception.getMessage());
	}
}
