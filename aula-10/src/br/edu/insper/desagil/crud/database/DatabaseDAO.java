
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA INTERFACE

package br.edu.insper.desagil.crud.database;

import java.util.List;

public interface DatabaseDAO<K, V> {
	boolean exists(K key) throws DatabaseException;
	boolean exists(List<K> keys) throws DatabaseException;
	void create(V value) throws DatabaseException;
	V retrieve(K key) throws DatabaseException;
	List<V> retrieve(List<K> keys) throws DatabaseException;
	List<V> retrieveAll() throws DatabaseException;
	void update(V value) throws DatabaseException;
	void delete(K key) throws DatabaseException;
	void delete(List<K> keys) throws DatabaseException;
	void deleteAll() throws DatabaseException;
}
