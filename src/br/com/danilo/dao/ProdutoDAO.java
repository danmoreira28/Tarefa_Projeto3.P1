package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.danilo.dao.jdbc.ConnectionFactory;
import br.com.danilo.domain.Produto;


public class ProdutoDAO implements IProduto {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (ID, CODIGO, DESCRICAO, QUANTIDADE, VALOR) VALUES (nextval('SQ_PRODUTO'),?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setDouble(1, produto.getCodigo());
            stm.setString(2, produto.getDesc());
            stm.setDouble(3, produto.getQuantidade());
            stm.setDouble(4, produto.getValor());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(Double codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from tb_produto where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setDouble(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getDouble("id"));
                produto.setCodigo(rs.getDouble("codigo"));
                produto.setDesc(rs.getString("descricao"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setValor(rs.getDouble("valor"));
            }
            return produto;
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setDouble(1, produto.getCodigo());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
