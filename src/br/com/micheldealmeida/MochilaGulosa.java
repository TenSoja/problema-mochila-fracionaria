package br.com.micheldealmeida;


public class MochilaGulosa {

	private Item[] itens = null;

	/**
	 * @param itens
	 */
	public MochilaGulosa(Item[] itens) {
		this.itens = itens;
	}

	/**
	 * @param capacidade
	 * @return
	 */
	public Item[] adicionaItens(int capacidade) {

		Item[] itensAdicionados = new Item[this.itens.length];

		int itemIndice = 0;
		// pegar itens até que a mochila esteja cheia ou não haja mais itens
		// para colocar
		while (capacidade > 0 && itemIndice < this.itens.length) {
			if (this.itens[itemIndice].quantidade <= capacidade) {
				// se cabe inteiro, pegue
				capacidade -= this.itens[itemIndice].quantidade;
				itensAdicionados[itemIndice] = new Item(
						this.itens[itemIndice].nome,
						this.itens[itemIndice].valor,
						this.itens[itemIndice].quantidade);
			} else {
				// se não cabe inteiro, pegue a fração que puder
				itensAdicionados[itemIndice] = new Item(
						this.itens[itemIndice].nome,
						this.itens[itemIndice].valor, capacidade);
				capacidade = 0;
			}
			itemIndice++;
		}

		// adiciona outros itens de quantidade 0
		for (int i = itemIndice; i < this.itens.length; i++) {
			itensAdicionados[i] = new Item(this.itens[i].nome,
					this.itens[i].valor, 0);
		}

		return itensAdicionados;
	}

}
