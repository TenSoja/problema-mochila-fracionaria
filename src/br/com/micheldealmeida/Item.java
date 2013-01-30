package br.com.micheldealmeida;

public class Item {
	
	public String nome;
	public double quantidade;
	public double valor;

	/**
	 * @param nome
	 * @param valor
	 * @param quantidade
	 */
	public Item(String nome, double valor, double quantidade) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}
	
	

}
