package br.unipe.pos.fabrica.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unipe.pos.fabrica.Model.Fabrica;

public interface FabricaRepository extends MongoRepository<Fabrica, Integer> {

}
