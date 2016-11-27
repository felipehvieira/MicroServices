package br.unipe.pos.fabrica.Feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.pos.carros.Model.Carro;


@FeignClient("carros")
public interface CarroClient {
	
	@RequestMapping("/buscarModelo/{modelo}")
	Carro buscaModelo(@PathVariable("modelo") String modelo);
	
	@RequestMapping("/carroFabrica/{idFabrica}")
	List<Carro> listaCarrosFabrica(@PathVariable("idFabrica") int idFabrica);
}
