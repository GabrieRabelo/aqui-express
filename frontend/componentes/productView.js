class ProductView {
  constructor(product) {
    this.product = product;
    this.btnSelect = null;
  }

  criarElemento() {
    let template = `
      <div class="product">  
        <div class="inner">
          <div class="description"></div>
          <div class="price"></div>
          <button class="select">Selecionar</button>
        </div>
      </div>
    `.trim();

    let temp = document.createElement("template");
    temp.innerHTML = template;
    const elemento = temp.content.firstChild;

    const description = elemento.querySelector(".description");
    const select = elemento.querySelector(".select");
    const price = elemento.querySelector(".price");

    price.innerHTML = "R$ " + this.product.price.toFixed(2);
    description.innerHTML = this.product.description;
    this.btnSelect = select;

    return elemento;
  }
}
