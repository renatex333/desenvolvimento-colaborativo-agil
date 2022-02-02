// NÃO MODIFIQUE NEM SUBSTITUA ESTE ARQUIVO

package br.edu.insper.desagil.backend;

import br.edu.insper.desagil.backend.httpserver.HTTPServer;

public final class Backend {
	public static final void main(String[] args) {
		HTTPServer.start(8080, false);
	}
}
