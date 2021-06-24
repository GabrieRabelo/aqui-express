class ItemCarrinhoView {
  definirQuantidade(qtd) {
    const price = (this.itemCarrinho.product.price * qtd).toFixed(2);
    this.price.textContent = "R$ " + price;
    this.qtd.value = qtd;

    this.itemCarrinho.quantity = qtd;
  }

  criarElemento() {
    if (this.elemento) return this.elemento;

    let template = `
      <div class="product">  
        <div class="inner">
          <div class="descricao"></div>
          <div class="price"></div>
          <div class="qtd">
            <label>Qtd:</label>
            <input type="text" value="1" />
          </div>
        </div>
      </div>
    `.trim();

    let temp = document.createElement("template");
    temp.innerHTML = template;
    const elemento = temp.content.firstChild;

    this.descricao = elemento.querySelector(".descricao");
    this.price = elemento.querySelector(".price");
    this.qtd = elemento.querySelector("input");

    this.descricao.innerHTML = this.itemCarrinho.product.description;
    this.definirQuantidade(this.itemCarrinho.quantity);

    this.elemento = elemento;
    return elemento;
  }

  remover() {
    if (this.elemento) this.elemento.remove();
    this.elemento = null;
  }

  constructor(itemCarrinho) {
    this.itemCarrinho = itemCarrinho;
    this.descricao = null;
    this.elemento = null;
    this.price = null;
    this.qtd = null;
  }
}
