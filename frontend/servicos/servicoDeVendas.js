class ServicoDeVendas {
  async autoriza(id, quantidade) {
    let url = this.baseUrl + "/vendas/autorizacao";
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
    return [50.0, 10.0, 60.0];


    const url = this.baseUrl + "/vendas/subtotal";
    const param = [];

    itens.forEach((item) => {
      param.push({ id: item.product.id, quantidade: item.qtdade });
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
      //        resp[0] = subtotal;
      //        resp[1] = imposto;
      //        resp[2] = subtotal + imposto;

      console.log(erro);
    }
    return null;
  }

  async confirmaVenda(itens) {
    debugger
    const url = this.baseUrl + "/vendas/confirmacao";
    const param = [];

    itens.forEach((item) => {
      param.push({ id: item.product.id, quantity: item.quantity, price: item.price });
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
    const url = this.baseUrl + "/vendas/produtos";
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
