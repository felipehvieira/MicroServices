package br.unipe.pos.carros.Controller;

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
import br.unipe.pos.carros.Service.CarroService;

@RestController
@CrossOrigin
public class CarroController {

	@Autowired
	private CarroService service;

	@RequestMapping(value = "/carro", method = RequestMethod.POST)
	public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro) {
		service.savarCarro(carro);
		try {
			return new ResponseEntity<Carro>(carro, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Carro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/carro")
	public ResponseEntity<List<Carro>> listaCarro() {

		try {
			return new ResponseEntity<List<Carro>>(service.getCarros(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Carro>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/buscarModelo/{modelo}")
	public ResponseEntity<Carro> buscaModelo(@PathVariable String modelo) {
		Carro carro = service.buscarModelo(modelo);
		if (carro == null)
			return new ResponseEntity<Carro>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Carro>(carro, HttpStatus.OK);
	}

	@RequestMapping("/carroFabrica/{idFabrica}")
	public ResponseEntity<List<Carro>> listaCarrosFabrica(@PathVariable("idFabrica") int idFabrica) {
		List<Carro> carros = service.buscarFabrica(idFabrica);
		if (carros == null)
			return new ResponseEntity<List<Carro>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Carro>>(carros, HttpStatus.OK);
	}

	@RequestMapping(value = "/carro", method = RequestMethod.PUT)
	public ResponseEntity<Carro> modificarCarro(@RequestBody Carro carro) {

		try {
			return new ResponseEntity<Carro>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Carro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/carro/{modelo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarCarro(@PathVariable("modelo") String modelo) {
		try {
			service.deletarCarro(modelo);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
