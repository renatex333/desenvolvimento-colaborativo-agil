package br.edu.insper.desagil.backend.endpoint;

import br.edu.insper.desagil.backend.Backend;
import br.edu.insper.desagil.backend.core.Aluno;
import br.edu.insper.desagil.backend.dao.AlunoDAO;
import br.edu.insper.desagil.backend.httpserver.Args;
import br.edu.insper.desagil.backend.httpserver.Endpoint;
import br.edu.insper.desagil.backend.httpserver.Result;

public class AlunoEndpoint extends Endpoint<Aluno> {
	private AlunoDAO dao;

	public AlunoEndpoint() {
		super("/aluno");
		dao = new AlunoDAO();
	}

	@Override
	public Aluno get(Args args) {
		String key = args.get("key");
		Aluno aluno = dao.retrieve(key);
		return aluno;
	}

	@Override
	public Result post(Args args, Aluno aluno) {
		dao.create(aluno);
		return null;
	}

	@Override
	public Result put(Args args, Aluno aluno) {
		dao.update(aluno);
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