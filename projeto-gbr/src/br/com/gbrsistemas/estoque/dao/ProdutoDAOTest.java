package br.com.gbrsistemas.estoque.dao;

import br.com.gbrsistemas.estoque.entidade.Categoria;
import br.com.gbrsistemas.estoque.entidade.Fornecedor;
import br.com.gbrsistemas.estoque.entidade.Medida;
import br.com.gbrsistemas.estoque.entidade.Produto;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoDAOTest {

    public ProdutoDAOTest(){

    }

    @Test
    void save() throws Exception {

        Fornecedor f = new Fornecedor();
        f.setIdFornecedor(1);
        Categoria c = new Categoria();
        c.setIdCategoria(3);
        Medida m = new Medida();
        m.setIdMedida(1);

        Date data = new Date(System.currentTimeMillis());
        System.out.println("ADICIONANDO UM PRODUTO");


        Produto p = new Produto();
        p.setFornecedor(f);
        p.setNome("GOIABA");
        p.setCategoria(c);
        p.setMedida(m);
        p.setMarca("GOIABAUM");
        p.setPreco(1.98);
        p.setQuantidade(100);
        p.setFabricacao(data);
        p.setValidade(data);

        ProdutoDAO dao = new ProdutoDAO();

        dao.save(p);
    }

    @Test
    void update() {
    }

    @Test
    void findAll() throws Exception {
        ProdutoDAO dao = new ProdutoDAO();
        for(Produto p: dao.findAll()) {
            System.out.println("Medida Produto: " + p.getMedida()
                    + "Medida Medida" + p.getMedida().getTipo()
                    + "Categoria Produto: " + p.getCategoria() +
                    "Fornecedor Produto: " + p.getFornecedor());
        }
    }

    @Test
    void findById() {
    }

    @Test
    void findByNome() {
    }

    @Test
    void desativarProduto() {
    }

    @Test
    void subtrairProduto() {
    }

    @Test
    void somarProduto() {
    }
}