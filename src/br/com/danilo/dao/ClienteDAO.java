package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.danilo.dao.jdbc.ConnectionFactory;
import br.com.danilo.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (ID, CODIGO, NOME, CPF, TEL, ENDERECO, NUM, CIDADE, ESTADO) VALUES (nextval('SQ_CLIENTE'),?,?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            stm.setLong(3, cliente.getCpf());
            stm.setLong(4, cliente.getTel());
            stm.setString(5, cliente.getEnd());
            stm.setLong(6, cliente.getNumero());
            stm.setString(7, cliente.getCidade());
            stm.setString(8, cliente.getEstado());
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
    public Cliente consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from tb_cliente where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getLong("cpf"));
                cliente.setTel(rs.getLong("tel"));
                cliente.setEnd(rs.getString("endereco"));
                cliente.setNumero(rs.getLong("num"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
            }
            return cliente;
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
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_CLIENTE WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
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