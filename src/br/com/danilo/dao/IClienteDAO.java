package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import br.com.danilo.domain.Cliente;

public interface IClienteDAO {


    public Integer cadastrar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;
}