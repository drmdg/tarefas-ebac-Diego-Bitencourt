import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.br.com.diego.dao.ClienteDAO;
import main.br.com.diego.dao.IClienteDAO;
import main.br.com.diego.domain.Cliente;

import java.util.List;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteTeste {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Rodrigo Pires");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizarEBuscarTodosTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Rodrigo Pires");

        dao.cadastrar(cliente);

        cliente.setCodigo("02");
        cliente.setNome("Diego Souza");

        dao.cadastrar(cliente);

        cliente.setCodigo("03");
        cliente.setNome("Cristiano Ronaldo");

        dao.cadastrar(cliente);

        cliente.setCodigo("04");
        cliente.setNome("Angelo Batista");

        dao.cadastrar(cliente);



        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        clienteBD.setNome("Mauricio Ricardo");
        clienteBD.setCodigo("55");
        dao.alterar(clienteBD);
        cliente = dao.consultar(clienteBD.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getId(), clienteBD.getId());

        List<Cliente> listaDeClientes = dao.buscarTodos();
        assertEquals(4,listaDeClientes.size());

        for (Cliente cli : listaDeClientes){
            Integer qtdDel = dao.excluir(cli);
            assertNotNull(qtdDel);
        }

    }
}
