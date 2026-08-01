package cotiinformatica.repositories;

import cotiinformatica.entities.Produto;

import java.sql.DriverManager;

public class ProdutoRepository {

    /*
        Método para inserir um produto no banco de dados
     */
    public void inserir(Produto produto){

        //Variáveis para conexão com o banco de dados
        var host = "jdbc:postgresql://localhost:5432/appdb";
        var user = "appuser";
        var pass = "apppassword";

        try (var connection = DriverManager.getConnection(host, user, pass)) {

            //Escrever uma sentença em SQL para inserir um produto no banco de dados
            var query = """
                        INSERT INTO produtos (id, nome, preco, quantidade, datahoracadastro, categoria)
                        VALUES (?, ?, ?, ?, ?, ?)                        
                    """;

            //Executando o comando SQL no banco de dados
            var statement = connection.prepareStatement(query);
            statement.setObject(1, produto.id);
            statement.setObject(2, produto.nome);
            statement.setObject(3, produto.preco);
            statement.setObject(4, produto.quantidade);
            statement.setObject(5, produto.dataHoraCadastro);
            statement.setObject(6, produto.categoria.toString());
            statement.execute();

            System.out.println("\nPRODUTO CADASTRADO COM SUCESSO!");

        } catch (Exception e) {
            System.out.println("\nFALHA AO INSERIR O PRODUTO.");
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
