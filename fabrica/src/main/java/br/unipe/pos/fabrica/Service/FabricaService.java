package br.unipe.pos.fabrica.Service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.pos.fabrica.Model.Fabrica;
import br.unipe.pos.fabrica.Repository.FabricaRepository;

@Service
public class FabricaService {

	@Autowired
	private FabricaRepository repository;
	
	public Fabrica novaFabrica(@NotNull Fabrica fabrica){
		return repository.save(fabrica);
	}
	public List<Fabrica> getFabrica(){
		return repository.findAll();
	}
	public Fabrica buscarFabrica(int id){
		return repository.findOne(id);
	}
	public Fabrica updateFabrica(Fabrica fabrica){
		return repository.save(fabrica);
	}
	public void deletarFabrica(Fabrica fabrica){
		repository.delete(fabrica);
	}
}
