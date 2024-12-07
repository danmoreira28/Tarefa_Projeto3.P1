package br.com.danilo.dao;

/**
 * @author danmoreira28
 */

import br.com.danilo.domain.Produto;

public interface IProduto {

    public Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(Double codigo) throws Exception;

    public Integer excluir(Produto produtoBD) throws Exception;
}

