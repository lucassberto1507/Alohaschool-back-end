package br.com.gbrsistemas.estoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.gbrsistemas.estoque.config.ConnectionFactory;
import br.com.gbrsistemas.estoque.entidade.Compra;

public class CompraDAO {

	//Listar todas as Compras
	public List<Compra> findAll() throws Exception {
		List<Compra> lista = new ArrayList<>();
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM TB_COMPRA";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Compra compra = new Compra();
			compra.setIdCompra(rs.getInt("ID_COMPRA"));
			compra.setDataCompra(rs.getDate("DATA_COMPRA"));
			compra.setValor(rs.getDouble("VALOR"));
			compra.setFormaPgto(rs.getString("FORMA_PGTO"));
			
			lista.add(compra);
		}
		return lista;
		
	}

	//Buscar compra por ID
	public Compra findById(int idCompra) throws Exception {
		Compra compra = null;
	
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM TB_COMPRA WHERE ID_COMPRA = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, idCompra);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			compra = new Compra();
			compra.setIdCompra(rs.getInt("ID_COMPRA"));
			compra.setDataCompra(rs.getDate("DATA_COMPRA"));
			compra.setValor(rs.getDouble("VALOR"));
			compra.setFormaPgto(rs.getString("FORMA_PGTO"));
		}
		return compra;
	}

	//Cria uma nova Compra
	public int addCompra(Compra compra) throws Exception {
		int idGerado = 0;
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "INSERT INT TB_COMPRA SET DATA_COMPRA = ?, VALOR = ?, FORMA_PGTO = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setDouble(1, compra.getValor());
		pstmt.setDate(2, compra.getDataCompra());
		pstmt.setString(3, compra.getFormaPgto());
		
		pstmt.executeUpdate();
		
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			idGerado = rs.getInt(1);
		}
		return idGerado;
	}

	//Edita uma Compra
	public void editarCompra(Compra compra, int idCompra) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "UPDATE TB_COMPRA SET DATA_COMPRA = ?, VALOR = ?, FORMA_PGTO = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, compra.getDataCompra());
		pstmt.setDouble(2, compra.getValor());
		pstmt.setString(3, compra.getFormaPgto());
		
		pstmt.execute();
		
	}
	public void buscarCompraPorData(Compra compra, int idCompra) throws Exception {
		Connection con = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM TB_COMPRA WHERE DATA BETWEEN ('data_inicial') and ('data_final')";
					// TODO: 03/09/2019 Buscar compra por data;
	}

}
