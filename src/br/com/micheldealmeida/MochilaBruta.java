package br.com.micheldealmeida;

import java.util.ArrayList;
import java.util.List;

public class MochilaBruta {

	private Item[] itens = null;

	/**
	 * @param itens
	 */
	public MochilaBruta(Item[] itens) {
		this.itens = itens;
	}

	public List<Item[]> subconjuntos(Item[] itens2) {

		int qtdSubconjuntos = 1 << itens2.length;
		int indiceLista = 0;

		List<Item[]> listaSubconjuntos = new ArrayList<Item[]>(qtdSubconjuntos);

		for (int i = 0; i < qtdSubconjuntos; i++) {
			int pos = itens2.length - 1;
			int bitmask = i;
			Item[] listaAux = new Item[itens2.length];
			while (bitmask > 0) {
				if ((bitmask & 1) == 1) {

					// System.out.print(itens2[pos].nome + ",");

					listaAux[indiceLista] = new Item(itens2[pos].nome,
							itens2[pos].valor, itens2[pos].quantidade);
					indiceLista++;
				}

				bitmask >>= 1;
				pos--;

			}

			listaSubconjuntos.add(listaAux);
			indiceLista = 0;
		}
		return listaSubconjuntos;
	}

}
