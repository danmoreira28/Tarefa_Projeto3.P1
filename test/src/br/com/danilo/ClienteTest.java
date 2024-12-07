package br.com.danilo;

/**
 * @author danmoreira28
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.danilo.dao.ClienteDAO;
import br.com.danilo.dao.IClienteDAO;
import br.com.danilo.domain.Cliente;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("02");
        cliente.setNome("Nathalia Moreira");
        cliente.setCpf(123456789L);
        cliente.setTel(987654321L);
        cliente.setEnd("Rua Java Postgres");
        cliente.setNumero(5432L);
        cliente.setCidade("Back-End");
        cliente.setEstado("Programação");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getCpf(), clienteBD.getCpf());
        assertEquals(cliente.getTel(), clienteBD.getTel());
        assertEquals(cliente.getEnd(), clienteBD.getEnd());
        assertEquals(cliente.getNumero(), clienteBD.getNumero());
        assertEquals(cliente.getCidade(), clienteBD.getCidade());
        assertEquals(cliente.getEstado(), clienteBD.getEstado());
//        Integer qtdDel = dao.excluir(clienteBD);
//        assertNotNull(qtdDel);
    }
}