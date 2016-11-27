package br.unipe.pos.carros.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unipe.pos.carros.Model.Carro;

public interface CarroRepository extends MongoRepository<Carro, String> {
	
	public List<Carro> findByFabrica(int fabrica);

}
