package br.com.micheldealmeida;

public class Item {
	/**
	 * @param quantidade
	 * @param valor
	 * @param nome
	 */

	public double quantidade;
	public double valor;
	public String nome;

	public Item(double quantidade, double valor, String nome) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.nome = nome;
	}

}
