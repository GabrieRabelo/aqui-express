class CarrinhoView {
  mudarQuantidade(codProd, quantity) {
    let view = this.views.find(
      (view) => view.itemCarrinho.product.id === codProd
    );

    if (view === undefined) return;

    this.carrinho.mudarQuantidade(codProd, quantity);
    view.definirQuantidade(quantity);
  }

  mostrarTextoVazio(mostrar) {
    if (mostrar) this.txtVazio.style.display = "block";
    else this.txtVazio.style.display = "none";
  }

  adicionarItem(product) {
    let item = new ItemCarrinho(product, 1, product.price);
    let view = new ItemCarrinhoView(item);

    this.carrinho.adicionarItem(item);
    this.views.push(view);

    let elemento = view.criarElemento();
    this.root.appendChild(elemento);
    this.mostrarTextoVazio(false);

    return view;
  }

  quantidade(codProd) {
    let item = this.carrinho.recuperarItem(codProd)
    if (item === undefined) return -1;
    return item.quantity;
  }

  limpar() {
    this.views.forEach((x) => x.remover());
    this.mostrarTextoVazio(true);
    this.carrinho.limpar();
    this.views = [];
  }

  constructor(carrinho, root) {
    this.txtVazio = root.querySelector("p");
    this.carrinho = carrinho;
    this.root = root;
    this.views = [];
  }
}
