// Referência para acentos e caracteres especiais em HTML/JS
// http://www.javascripter.net/faq/accentedcharacters.htm

const btnCheckout = document.getElementById("btnCheckout");
const btnClear = document.getElementById("btnClear");

const carrinhoRoot = document.getElementById("carrinho");
const produtosRoot = document.getElementById("produtos");
const saidaRoot = document.getElementById("txtSaida");
const totalRoot = document.getElementById("total");

var produtos;
var carrinho;
var servico;
var saida;
var total;

async function mudarQuantidade(itemCarrinhoView) {
  const id = itemCarrinhoView.itemCarrinho.product.id;
  const valor = itemCarrinhoView.qtd.value;
  const num = Number.parseInt(valor);
  var quantity = 1;

  if (!(Number.isNaN(num) || num < 1)) {
    quantity = Math.floor(num);
    let autorizado = await servico.autoriza(id, quantity);
    if (!autorizado) {
      saida.quantidadeIndisponivel();
      limparCarrinho();
      return;
    }
  }

  this.carrinho.mudarQuantidade(id, quantity);
  await calcularSubtotal();
}

async function adicionarAoCarrinho(product) {
  
  let qtd = await carrinho.quantidade(product.id);
  
  if (qtd > 0) {
    let autorizado = await servico.autoriza(product.id, qtd + 1);
    if (autorizado) {
      carrinho.mudarQuantidade(product.id, qtd + 1);
    } else {
      return saida.quantidadeIndisponivel();
    }
  } else {
    let autorizado = await servico.autoriza(product.id, 1);
    if (!autorizado) return saida.produtoIndisponivel();
    
    let view = carrinho.adicionarItem(product);
    bindItem(view);
    
    btnCheckout.disabled = false;
    btnClear.disabled = false;
  }

  saida.limpar();
  await calcularSubtotal();
}

async function calcularSubtotal() {
  let itens = carrinho.carrinho.itens;

  totais = await servico.calculaSubtotal(itens);

  if (totais !== null) total.definirValores(totais[0], totais[1], totais[2]);
  else {
    saida.erroInternoDoServidor();
    total.limpar();
  }
}

async function carregarProdutos() {
  let lista_produtos = await servico.getProdutos();
  produtos.carregarProdutos(lista_produtos);
}

function limparCarrinho() {
  btnCheckout.disabled = true;
  btnClear.disabled = false;
  carrinho.limpar();
  total.limpar();
}

async function checkout() {
  let itens = carrinho.carrinho.itens;
  let confirmou = await servico.confirmaVenda(itens);

  console.log(confirmou);

  if (confirmou) {
    saida.vendaSucesso();
  } else {
    saida.erroInternoDoServidor();
  }
  limparCarrinho();
}

// Binding de eventos
function bindProdutos(produtoViews) {
  produtoViews.forEach((view) => {
    view.btnSelect.addEventListener("click", () => {
      adicionarAoCarrinho(view.product);
    });
  });
}

function bindItem(itemView) {
  itemView.qtd.addEventListener("focusout", () => {
    this.mudarQuantidade(itemView);
  });
}

function bindCheckout(btn) {
  btn.addEventListener("click", checkout);
}

function bindClear(btn) {
  btn.addEventListener("click", limparCarrinho);
}

// Inicialização
async function init() {
  servico = new ServicoDeVendas("http://localhost:8080");

  carrinho = new CarrinhoView(new Carrinho(), carrinhoRoot);
  produtos = new ProdutoListView(servico, produtosRoot);
  saida = new SaidaView(saidaRoot);
  total = new TotalView(totalRoot);

  await carregarProdutos();

  bindProdutos(produtos.views);
  bindCheckout(btnCheckout);
  bindClear(btnClear);
}

init();
