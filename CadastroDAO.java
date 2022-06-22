package cadastro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import cadastro.factory.ConnectionFactory;
import cadastro.model.CadastroGrupo;
import cadastro.model.CadastroProduto;

public class CadastroDAO {
	
	private Connection conn;
	
	public static void incluir(CadastroProduto cadastro) {
		String sql = "INSERT INTO produto(codigo, descricao, codigo_barras, ativo, marca, preco_venda, estoque, data_cadastro, unidade_medida) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, cadastro.getDescricao());
			pstm.setString(2, cadastro.getCodigo_barras());
			//pstm.setInt(3, cadastro.getGrupo());
			//pstm.setInt(4, cadastro.getFornecedor());
			pstm.setBoolean(3, cadastro.isAtivo());
			pstm.setString(4, cadastro.getMarca());
			pstm.setDouble(5, cadastro.getPreco_venda());
			pstm.setInt(6, cadastro.getEstoque());
			pstm.setDate(7, new Date(cadastro.getData_cadastro().getTime()));
			pstm.setString(8, cadastro.getUnidade_medida());
			
			System.out.println("Cadastro incluído com sucesso!");
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public CadastroProduto consulta(int codigo) throws Exception {
		String sql = "SELECT * FROM produto WHERE codigo = ?";
		conn = ConnectionFactory.createConnectionToMySQL();
		//PreparedStatement pstm = null;
		
		try {
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			ResultSet rset = pstm.executeQuery();
			CadastroProduto cadastro = new CadastroProduto();
			rset.first();
			//cadastro.setCodigo(codigo);
			
			cadastro.setCodigo(rset.getInt("codigo"));
			cadastro.setDescricao(rset.getString("descricao"));
			cadastro.setCodigo_barras(rset.getString("codigo_barras"));
			cadastro.setGrupo(rset.getInt("grupo"));
			cadastro.setFornecedor(rset.getInt("fornecedor"));
			cadastro.setAtivo(rset.getBoolean("ativo"));
			cadastro.setMarca(rset.getString("marca"));
			cadastro.setUnidade_medida(rset.getString("unidade_medida"));
			cadastro.setPreco_venda(rset.getDouble("preco_venda"));
			cadastro.setData_cadastro(rset.getDate("data_cadastro"));
			cadastro.setEstoque(rset.getInt("estoque"));

			return cadastro;
		
		}catch (Exception e) {
			return null;
		}		
	}
	
	public CadastroProduto consultaGrupo(int codigo) throws Exception {
		String sql = "SELECT * FROM grupo WHERE codigo = ?";
		conn = ConnectionFactory.createConnectionToMySQL();
		//PreparedStatement pstm = null;
		
		try {
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			ResultSet rset = pstm.executeQuery();
			CadastroProduto cadastro = new CadastroProduto();
			rset.first();
			//cadastro.setCodigo(codigo);
			
			cadastro.setCodigo(rset.getInt("codigo"));
			cadastro.setDescricao(rset.getString("descricao"));
			cadastro.setCodigo_barras(rset.getString("codigo_barras"));
			cadastro.setGrupo(rset.getInt("grupo"));
			cadastro.setFornecedor(rset.getInt("fornecedor"));
			cadastro.setAtivo(rset.getBoolean("ativo"));
			cadastro.setMarca(rset.getString("marca"));
			cadastro.setUnidade_medida(rset.getString("unidade_medida"));
			cadastro.setPreco_venda(rset.getDouble("preco_venda"));
			cadastro.setData_cadastro(rset.getDate("data_cadastro"));
			cadastro.setEstoque(rset.getInt("estoque"));

			return cadastro;
		
		}catch (Exception e) {
			return null;
		}		
	}

	public void alterar(CadastroProduto cadastro) {
		
		String sql = "UPDATE produto SET descricao = ?, codigo_barras = ?, grupo = ?, fornecedor = ?, ativo = ?, marca = ?, preco_venda = ?, estoque = ? "+
		"WHERE codigo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, cadastro.getDescricao());
			pstm.setString(2, cadastro.getCodigo_barras());
			pstm.setInt(3, cadastro.getGrupo());
			pstm.setInt(4, cadastro.getFornecedor());
			pstm.setBoolean(5, cadastro.isAtivo());
			pstm.setString(6, cadastro.getMarca());
			pstm.setDouble(7, cadastro.getPreco_venda());
			pstm.setInt(8, cadastro.getEstoque());
			
			pstm.setInt(9, cadastro.getCodigo());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void excluir(int codigo) {
		
		String sql = "DELETE FROM produto WHERE codigo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<CadastroGrupo> consultarGrupo(){
		String sql = "SELECT * FROM grupo_produto";
		
		List<CadastroGrupo> cadastros = new ArrayList<CadastroGrupo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. (SELECT)
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				CadastroGrupo cadastro = new CadastroGrupo();
				
				cadastro.setCodigo(rset.getInt("codigo"));
				cadastro.setDescricao(rset.getString("descricao"));
				cadastro.setAtivo(rset.getBoolean("ativo"));				
				cadastros.add(cadastro);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cadastros;
		
	}
}
