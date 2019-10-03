package br.com.gbrsistemas.estoque;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.gbrsistemas.estoque.dao.FornecedorDAO;
import br.com.gbrsistemas.estoque.entidade.Fornecedor;

public class CategoriaTest {

    public CategoriaTest(){

    }

    @Test
    public void inserir(){

        Categoria cat = new Categoria("GRÃOS");
        CategoriaDAO dao = new CategoriaDAO();

        if(dao.save(cat)) {
            System.out.println("SALVO COM SUCESSO!");
        }else
            fail("Erro ao salvar");
    }
}
