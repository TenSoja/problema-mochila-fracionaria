package br.com.micheldealmeida;

import java.util.ArrayList;

public class MochilaRetrocesso {
	
	/**
	 * @param itens
	 */
	public MochilaRetrocesso(Item[] itens) {
		this.itens = itens;
	}

	private Item[] itens = null;
	
	
	public enum Escolhido {
		SIM, NAO, NADA
	};

	public static class Solucao {
		public Item[] itensAdicionados;
		public int quantidade;
		public int valor;
		public int solucoes;

		public Solucao(Item[] itensAdicionados, int valor, int quantidade) {
			this.itensAdicionados = itensAdicionados;
			this.valor = valor;
			this.quantidade = quantidade;
		}
	}

	public  Solucao adicionaItens(int capacidade) {
		Solucao solucao = new Solucao(null, 0, 0);// começamos desse elemento
													// nulo
		ArrayList<Item> adicionado = new ArrayList<Item>();
		Escolhido[] escolhas = new Escolhido[this.itens.length];
		int indice, indiceCorrente = 0, valorCorrente = 0, quantidadeCorrente = 0;

		for (indice = 0; indice < this.itens.length; indice++)
			escolhas[indice] = Escolhido.NADA;
		while (this.itens.length > 0
				&& !(indiceCorrente == 0 && escolhas[indiceCorrente] == Escolhido.NAO)) {
			if (solucao.itensAdicionados != null && indiceCorrente > 0
					&& escolhas[indiceCorrente] == Escolhido.NADA) {

				if (valorCorrente
						+ adicionaFracao(this.itens, indiceCorrente, capacidade
								- quantidadeCorrente) <= solucao.valor) {
					indiceCorrente--;
					continue;
				}
			}
			if (escolhas[indiceCorrente] == Escolhido.NADA) {
				if (capacidade >= quantidadeCorrente
						+ this.itens[indiceCorrente].quantidade) {
					escolhas[indiceCorrente] = Escolhido.SIM;
					quantidadeCorrente += this.itens[indiceCorrente].quantidade;
					valorCorrente += this.itens[indiceCorrente].valor;
					adicionado.add(this.itens[indiceCorrente]);
				} else
					escolhas[indiceCorrente] = Escolhido.NAO;
			} else if (escolhas[indiceCorrente] == Escolhido.SIM) {
				escolhas[indiceCorrente] = Escolhido.NAO;
				quantidadeCorrente -= this.itens[indiceCorrente].quantidade;
				valorCorrente -= this.itens[indiceCorrente].valor;
				adicionado.remove(this.itens[indiceCorrente]);
			} else {
				indiceCorrente--;
				continue;
			}
			if (indiceCorrente == escolhas.length - 1) {
				if (solucao.itensAdicionados == null
						|| solucao.valor < valorCorrente) {
					solucao = popularSolucao(valorCorrente, quantidadeCorrente,
							adicionado, solucao);
					solucao.solucoes++;
				}
				if (adicionado.contains(this.itens[indiceCorrente])) {
					quantidadeCorrente -= this.itens[indiceCorrente].quantidade;
					valorCorrente -= this.itens[indiceCorrente].valor;
					adicionado.remove(this.itens[indiceCorrente]);
				}
				indiceCorrente--;
			} else
				escolhas[++indiceCorrente] = Escolhido.NADA;
		}
		return solucao;
	}

	public static Solucao popularSolucao(int value, int weight,
			ArrayList<Item> adicionado, Solucao current) {
		Solucao novaSolucao = new Solucao(new Item[adicionado.size()], value,
				weight);

		novaSolucao.solucoes = current.solucoes;
		novaSolucao.itensAdicionados = adicionado
				.toArray(novaSolucao.itensAdicionados);	
		return novaSolucao;
	}

	public static int adicionaFracao(Item[] itens, int indice, int quantidade) {
		int value = 0;

		for (; indice < itens.length && quantidade > 0; indice++) {
			if (itens[indice].quantidade <= quantidade)
				value += itens[indice].valor;
			else
				value += (int) (((double) itens[indice].valor)
						/ ((double) itens[indice].quantidade) * quantidade);
			quantidade -= itens[indice].quantidade;
		}
		return value;
	}
}
