package br.com.micheldealmeida;

public class Item {

	public double quantidade;
	public double valor;
	public String nome;

	/**
	 * @param quantidade
	 * @param valor
	 * @param nome
	 */
	public Item(double quantidade, double valor, String nome) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.nome = nome;
	}

}
