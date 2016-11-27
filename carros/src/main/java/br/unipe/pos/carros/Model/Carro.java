package br.unipe.pos.carros.Model;

import org.springframework.data.annotation.Id;

public class Carro {

	@Id
	private String modelo;
	private int cilindradas;
	private String cor;
	private int fabrica;

	public Carro() {

	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getFabrica() {
		return fabrica;
	}

	public void setFabrica(int fabrica) {
		this.fabrica = fabrica;
	}

}
