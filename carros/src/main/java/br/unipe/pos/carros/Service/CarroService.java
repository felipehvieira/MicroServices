package br.unipe.pos.carros.Service;


import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unipe.pos.carros.Model.Carro;
import br.unipe.pos.carros.Repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository repository;
	
	public List<Carro> getCarros(){
		return repository.findAll();
	}
	
	@Transactional
	public Carro savarCarro(@NotNull Carro car){
		
		return repository.save(car);
	}
	
	public Carro buscarModelo(String modelo){
		return repository.findOne(modelo);
	}
	public List<Carro> buscarFabrica(int idfabrica){
		List<Carro> carros = repository.findByFabrica(idfabrica);
		return carros;
	}
	public Carro modificarCarro(Carro carro){
		return repository.save(carro);
	}
	public void deletarCarro(String modelo){
		Carro carro = repository.findOne(modelo);
		repository.delete(carro);
	}
		
}
