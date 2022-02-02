package br.edu.insper.desagil.backend.endpoint;

import br.edu.insper.desagil.backend.Backend;
import br.edu.insper.desagil.backend.core.Turma;
import br.edu.insper.desagil.backend.dao.TurmaDAO;
import br.edu.insper.desagil.backend.httpserver.Args;
import br.edu.insper.desagil.backend.httpserver.Endpoint;
import br.edu.insper.desagil.backend.httpserver.Result;

public class TurmaEndpoint extends Endpoint<Turma> {
	private TurmaDAO dao;

	public TurmaEndpoint() {
		super("/turma");
		dao = new TurmaDAO();
	}

	@Override
	public Turma get(Args args) {
		String key = args.get("key");
		Turma turma = dao.retrieve(key);
		return turma;
	}

	@Override
	public Result post(Args args, Turma turma) {
		dao.create(turma);
		Result result = new Result();
		result.put("key", turma.getKey());
		return result;
	}

	@Override
	public Result put(Args args, Turma turma) {
		dao.update(turma);
		return null;
	}

	@Override
	public Result delete(Args args) {
		if (Backend.TEST && args.containsKey("all") && args.getBoolean("all")) {
			dao.deleteAll();
			return null;
		}
		String key = args.get("key");
		dao.delete(key);
		return null;
	}
}