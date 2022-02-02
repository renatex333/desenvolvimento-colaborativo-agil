
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.crud.database.firestore;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteBatch;
import com.google.firebase.cloud.FirestoreClient;

import br.edu.insper.desagil.crud.database.DatabaseDAO;
import br.edu.insper.desagil.crud.database.DatabaseException;
import br.edu.insper.desagil.crud.database.InternalException;

public abstract class FirestoreDAO<T extends FirestoreObject> implements DatabaseDAO<String, T> {
	private final Class<T> klass;
	private final Firestore firestore;
	private final CollectionReference collection;

	@SuppressWarnings("unchecked")
	public FirestoreDAO(String path) {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		this.klass = (Class<T>) types[0];

		this.firestore = FirestoreClient.getFirestore();

		this.collection = this.firestore.collection(path);
	}

	private final List<T> execute(Query query) throws DatabaseException {
		QuerySnapshot documents;
		try {
			documents = query.get().get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
		List<T> values = new ArrayList<>();
		for (DocumentSnapshot document : documents) {
			values.add(document.toObject(klass));
		}
		return values;
	}

	@Override
	public boolean exists(String key) throws DatabaseException {
		if (key == null) {
			throw new InternalException("Key cannot be null");
		}
		if (key.isBlank()) {
			throw new InternalException("Key cannot be blank");
		}
		DocumentSnapshot document;
		try {
			document = collection.document(key).get().get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
		return document.exists();
	}

	@Override
	public boolean exists(List<String> keys) throws DatabaseException {
		if (keys == null) {
			throw new InternalException("List of keys cannot be null");
		}
		if (keys.isEmpty()) {
			throw new InternalException("List of keys cannot be empty");
		}
		for (String key : keys) {
			if (key == null) {
				throw new InternalException("Key cannot be null");
			}
			if (key.isBlank()) {
				throw new InternalException("Key cannot be blank");
			}
		}
		QuerySnapshot documents;
		Query query = collection.whereIn(FieldPath.documentId(), keys);
		try {
			documents = query.get().get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
		return keys.size() == documents.size();
	}

	@Override
	public void create(T value) throws DatabaseException {
		if (value == null) {
			throw new InternalException("Value cannot be null");
		}
		DocumentReference document;
		try {
			if (value instanceof AutokeyFirestoreObject) {
				document = collection.add(value).get();
				((AutokeyFirestoreObject) value).setKey(document.getId());
			} else {
				String key = value.key();
				if (key == null) {
					throw new InternalException("Key cannot be null");
				}
				if (key.isBlank()) {
					throw new InternalException("Key cannot be blank");
				}
				document = collection.document(key);
				if (document.get().get().exists()) {
					throw new InternalException("Key " + key + " already exists");
				}
			}
			document.set(value).get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
	}

	@Override
	public T retrieve(String key) throws DatabaseException {
		if (key == null) {
			throw new InternalException("Key cannot be null");
		}
		if (key.isBlank()) {
			throw new InternalException("Key cannot be blank");
		}
		DocumentSnapshot document;
		try {
			document = collection.document(key).get().get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
		if (!document.exists()) {
			throw new InternalException("Key " + key + " not found");
		}
		return document.toObject(klass);
	}

	@Override
	public List<T> retrieve(List<String> keys) throws DatabaseException {
		if (keys == null) {
			throw new InternalException("List of keys cannot be null");
		}
		if (keys.isEmpty()) {
			throw new InternalException("List of keys cannot be empty");
		}
		for (String key : keys) {
			if (key == null) {
				throw new InternalException("Key cannot be null");
			}
			if (key.isBlank()) {
				throw new InternalException("Key cannot be blank");
			}
		}
		return execute(collection.whereIn(FieldPath.documentId(), keys));
	}

	@Override
	public List<T> retrieveAll() throws DatabaseException {
		return execute(collection);
	}

	@Override
	public void update(T value) throws DatabaseException {
		if (value == null) {
			throw new InternalException("Value cannot be null");
		}
		String key = value.key();
		if (key == null) {
			throw new InternalException("Key cannot be null");
		}
		if (key.isBlank()) {
			throw new InternalException("Key cannot be blank");
		}
		DocumentReference document = collection.document(key);
		try {
			if (!document.get().get().exists()) {
				throw new InternalException("Key " + key + " not found");
			}
			document.set(value).get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
	}

	@Override
	public void delete(String key) throws DatabaseException {
		if (key == null) {
			throw new InternalException("Key cannot be null");
		}
		if (key.isBlank()) {
			throw new InternalException("Key cannot be blank");
		}
		DocumentReference document = collection.document(key);
		try {
			if (!document.get().get().exists()) {
				throw new InternalException("Key " + key + " not found");
			}
			document.delete().get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
	}

	@Override
	public void delete(List<String> keys) throws DatabaseException {
		if (keys == null) {
			throw new InternalException("List of keys cannot be null");
		}
		if (keys.isEmpty()) {
			throw new InternalException("List of keys cannot be empty");
		}
		WriteBatch batch = firestore.batch();
		for (String key : keys) {
			if (key == null) {
				throw new InternalException("Key cannot be null");
			}
			if (key.isBlank()) {
				throw new InternalException("Key cannot be blank");
			}
			batch.delete(collection.document(key));
		}
		try {
			batch.commit().get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
	}

	@Override
	public void deleteAll() throws DatabaseException {
		WriteBatch batch = firestore.batch();
		for (DocumentReference document : collection.listDocuments()) {
			batch.delete(document);
		}
		try {
			batch.commit().get();
		} catch (ExecutionException exception) {
			throw new FirestoreExecutionException(exception);
		} catch (InterruptedException exception) {
			throw new FirestoreInterruptedException(exception);
		}
	}
}
