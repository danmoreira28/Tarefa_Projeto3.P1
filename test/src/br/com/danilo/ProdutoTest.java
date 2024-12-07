package br.com.danilo;

/**
 * @author danmoreira28
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import br.com.danilo.dao.ProdutoDAO;
import br.com.danilo.dao.IProduto;
import br.com.danilo.domain.Produto;

public class ProdutoTest {

    @Test
    public void cadastrarTest() throws Exception {
        IProduto dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo(11D);
        produto.setDesc("Feijão");
        produto.setQuantidade(5D);
        produto.setValor(11.00D);

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getDesc(), produtoBD.getDesc());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());
        assertEquals(produto.getValor(), produtoBD.getValor());
//        Integer qtdDel = dao.excluir(produtoBD);
//        assertNotNull(qtdDel);
    }
}
