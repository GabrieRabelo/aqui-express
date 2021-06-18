class ProdutoListView {
  _adicionarProduto(product) {
    const produtoView = new ProductView(product);
    const element = produtoView.criarElemento();
    this.root.appendChild(element);
    this.views.push(produtoView);
  }

  carregarProdutos(produtos) {
    produtos.forEach((x) => this._adicionarProduto(x));
  }

  constructor(servico, root) {
    this.servico = servico;
    this.root = root;
    this.views = [];
  }
}
