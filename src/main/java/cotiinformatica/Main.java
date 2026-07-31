package cotiinformatica;

import cotiinformatica.services.ProdutoService;

public class Main {

    static void main() {

        //Criando um objeto da classe de serviço:
        var produtoService = new ProdutoService();

        //Execuntando o método para cadastro do produto
        produtoService.cadastrarProduto();
    }
}
