package cotiinformatica.services;

import cotiinformatica.entities.Produto;
import cotiinformatica.enums.Categoria;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class ProdutoService {

    /*
        Método para fazer com o usuário entre com os dados
        de um produto para realizar o seu cadastro.
     */
    public void cadastrarProduto() {

        //Criando um objeto da classe Scanner
        var scanner = new Scanner(System.in);

        //Criando um objeto da classe produto
        var produto = new Produto();

        produto.id = UUID.randomUUID(); //gerando o id
        produto.dataHoraCadastro = LocalDateTime.now(); //gerando a data e hora

        System.out.println("\nCADASTRO DE PRODUTO:\n");

        System.out.print("INFORME O NOME DO PRODUTO...: ");
        produto.nome = scanner.nextLine();

        System.out.print("INFORME O PREÇO.............: ");
        produto.preco = Double.parseDouble(scanner.nextLine());

        System.out.print("INFORME A QUANTIDADE........: ");
        produto.quantidade = Integer.parseInt(scanner.nextLine());

        for (var item : Categoria.values()) {
            System.out.println("\t" + item);
        }

        System.out.print("INFORME A CATEGORIA.........: ");
        produto.categoria = Categoria.valueOf(scanner.nextLine().toUpperCase());

        //TODO Gravação em banco de dados

    }
}
