package br.com.gbrsistemas.estoque;

import java.util.List;

import org.junit.Test;

import br.com.gbrsistemas.estoque.dao.PedidoDAO;
import br.com.gbrsistemas.estoque.entidade.Pedido;

public class PedidoTest {
	
	@Test
	public void listarPedidos() throws Exception {

		System.out.println("LISTA DE PEDIDO");

		PedidoDAO dao = new PedidoDAO();
		List<Pedido> lista = dao.listarPedidos();

		for (Pedido item : lista)
			System.out.println(item);

	}
	
	@Test
	public void addPedido() throws Exception {
		
		System.out.println("ADICIONANDO PEDIDO");
		
		Pedido pedido = new Pedido();
		pedido.setPrato("MISTO QUENTE");
		pedido.setDescricao("Pão, presunto, queijo");
		pedido.setStatus("INDISPONIVEL");
		pedido.setValor(4);
		
		PedidoDAO dao = new PedidoDAO();
		dao.addPedido(pedido);
		
	}
}
