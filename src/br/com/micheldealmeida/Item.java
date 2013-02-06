package br.com.micheldealmeida;

public class Item implements Comparable<Item> {

	public String nome;
	public int quantidade;
	public int valor;

	/**
	 * @param nome
	 * @param valor
	 * @param quantidade
	 */

	public Item(String nome, int valor, int quantidade) {
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

	@Override
	public int compareTo(Item outroItem) {
		if (this.valor < outroItem.valor) {
			return 1;
		}
		if (this.valor > outroItem.valor) {
			return -1;
		}
		return 0;
	}
}
