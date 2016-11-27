package br.unipe.pos.fabrica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.pos.carros.Model.Carro;
import br.unipe.pos.fabrica.Feign.CarroClient;
import br.unipe.pos.fabrica.Model.Fabrica;
import br.unipe.pos.fabrica.Service.FabricaService;

@RestController
@CrossOrigin
public class FabricaController {

	@Autowired
	private FabricaService service;

	@Autowired
	CarroClient client;

	@RequestMapping("/buscarModelo/{modelo}")
	public Carro buscaModelo(@PathVariable("modelo") String modelo) {
		return client.buscaModelo(modelo);
	}
	@RequestMapping("/carroFabrica/{idfabrica}")
	public List<Carro> listaCarrosFabrica(@PathVariable("idfabrica") int idfabrica){
		return client.listaCarrosFabrica(idfabrica);
	}
	
	@RequestMapping(value = "/fabricas")
	public ResponseEntity<List<Fabrica>> listaFabricas() {
		return new ResponseEntity<List<Fabrica>>(service.getFabrica(), HttpStatus.OK);
	}

	@RequestMapping(value = "/fabricas", method = RequestMethod.POST)
	public ResponseEntity<Fabrica> cadastraFabrica(@RequestBody Fabrica fabrica) {
		service.novaFabrica(fabrica);
		return new ResponseEntity<Fabrica>(fabrica, HttpStatus.CREATED);
	}
	@RequestMapping(value ="/fabricas", method = RequestMethod.PUT)
	public ResponseEntity<Fabrica> modificarFabrica(@RequestBody Fabrica fabrica){
		try {
			return new ResponseEntity<Fabrica>(service.updateFabrica(fabrica), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value = "/fabricas/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletaFabrica(@PathVariable("id") int id){
		try {
			Fabrica factory = service.buscarFabrica(id);
			service.deletarFabrica(factory);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
