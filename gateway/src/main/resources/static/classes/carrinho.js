class Carrinho {
  mudarQuantidade(codProd, quantity) {
    if (Number.isNaN(quantity) || quantity <= 0) return;

    let item = this.recuperarItem(codProd);
    if (item === undefined) return;
    item.quantity = quantity;
  }

  recuperarItem(codProd) {
    return this.itens.find((x) => x.product.id == codProd);
  }

  adicionarItem(item) {
    this.itens.push(item);
  }

  limpar() {
    this.itens = [];
  }

  constructor() {
    this.itens = [];
  }
}
