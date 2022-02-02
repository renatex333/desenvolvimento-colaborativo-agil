package br.edu.insper.desagil.pickle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileManager {
	private CharsetDecoder decoder;

	public FileManager() {
		this.decoder = Charset.forName("UTF-8").newDecoder();
	}

	public String load(String path) throws LoadException {		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), decoder))) {
			String line;
			StringBuilder builder = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				builder.append(line + '\n');
			}
			return builder.toString();

		} catch (FileNotFoundException exception) {
			throw new LoadException("Arquivo não encontrado: " + exception.getMessage());
			
		} catch (IOException exception) {
			throw new LoadException("Erro de leitura: " + exception.getMessage());
			
		}

	}

	public void save(String path, String content) throws SaveException {
		try (FileWriter writer = new FileWriter(path)) {
			writer.write(content);

		} catch (IOException exception) {
			throw new SaveException("Erro de escrita: " + exception.getMessage());
		}
	}
}
