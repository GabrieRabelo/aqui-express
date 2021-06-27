class ServicoDeVendas {
  async autoriza(id, quantidade) {
    let url = this.baseUrl + "/estoque/autorizacao";
    url += "?codProd=" + id + "&qtdade=" + quantidade;

    try {
      let resposta = await fetch(url);
      if (resposta.ok) {
        let aprovacao = await resposta.json();
        return aprovacao;
      } else {
        console.error(resposta.status, resposta.statusText);
      }
    } catch (erro) {
      console.error(erro);
    }
    return false;
  }

  async calculaSubtotal(itens) {
    const url = this.baseUrl + "/estoque/subtotal";
    const param = [];

    itens.forEach((item) => {
      param.push({ id: item.product.id, quantity: item.quantity, currentPrice: item.currentPrice, productId: item.product.id });
    });

    const otherParam = {
      headers: { "content-type": "application/json" },
      body: JSON.stringify(param),
      method: "POST",
    };

    try {
      let resposta = await fetch(url, otherParam);
      if (resposta.ok) {
        let totais = await resposta.json();
        return totais;
      }
    } catch (erro) {
      console.log(erro);
    }
    return null;
  }

  async confirmaVenda(itens) {
    const url = this.baseUrl + "/vendas-fila/confirmacao";
    const param = [];

    itens.forEach((item) => {
      param.push({ quantity: item.quantity, currentPrice: item.currentPrice, productId: item.product.id });
    });

    const otherParam = {
      headers: { "content-type": "application/json" },
      body: JSON.stringify(param),
      method: "POST",
    };

    try {
      let resposta = await fetch(url, otherParam);
      if (resposta.ok) {
        let resp = await resposta.json();
        return resp;
      }
    } catch (erro) {
      console.log(erro);
    }
    return false;
  }

  async getProdutos() {
    const url = this.baseUrl + "/estoque/produtos";
    const produtos = [];

    try {
      let resposta = await fetch(url);
      if (resposta.ok) {
        let dados = await resposta.json();
        for (let i = 0; i < dados.length; i++) {
          produtos.push(
            new Product(
              dados[i].id,
              dados[i].description,
              dados[i].price,
            )
          );
        }
      }
    } catch (erro) {
      console.log(erro);
    }

    return produtos;
  }

  constructor(baseUrl) {
    this.baseUrl = baseUrl;
  }
}
