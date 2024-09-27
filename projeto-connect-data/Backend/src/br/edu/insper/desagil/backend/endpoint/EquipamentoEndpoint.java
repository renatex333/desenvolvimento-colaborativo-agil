package br.edu.insper.desagil.backend.endpoint;
import java.util.List;
import br.edu.insper.desagil.backend.core.Equipamento;
import br.edu.insper.desagil.backend.dao.EquipamentoDAO;
import br.edu.insper.desagil.backend.httpserver.Args;
import br.edu.insper.desagil.backend.httpserver.Endpoint;
import br.edu.insper.desagil.backend.httpserver.Result;


public class EquipamentoEndpoint extends Endpoint<Equipamento> {
	private EquipamentoDAO dao;
	
	public EquipamentoEndpoint() {
		super("/equipamento");
		dao = new EquipamentoDAO();
	}

	@Override
	public Equipamento get(Args args) {
		String key = args.get("key");
		return dao.retrieve(key);
	}
	
	@Override
	public List<Equipamento> getList(Args args) {
		if (args.containsKey("keys")) {
			List<String> keys = args.getList("keys", ",");
			if (args.containsKey("other") && args.getBoolean("other")) {
				return dao.retrieveExcept(keys);
			} else {
				return dao.retrieve(keys);
			}

		} else {
			return dao.retrieveAll();
			
		}
		
	}
	
	
	@Override
	public Result post(Args args, Equipamento equipamento) {
		dao.create(equipamento);
		Result result = new Result();
		result.put("key", equipamento.getKey());
		System.out.println(result);
		return result;
	}

	@Override
	public Result put(Args args, Equipamento equipamento) {
		dao.update(equipamento);
		return new Result();
	}

	@Override
	public Result delete(Args args) {
		String key = args.get("key");
		dao.delete(key);
		return new Result();
	}

	@Override
	public Result deleteList(Args args) {
		dao.deleteAll();
		return new Result();
	}
}