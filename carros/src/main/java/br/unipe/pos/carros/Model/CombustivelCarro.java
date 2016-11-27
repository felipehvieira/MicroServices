package br.unipe.pos.carros.Model;

public enum CombustivelCarro {

	DIESEL("Diesel"),
	GASOLINA("Gasolina"),
	ETANOL("Etanol");
	
	private String descricao;
	

	private CombustivelCarro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
	
	
}
