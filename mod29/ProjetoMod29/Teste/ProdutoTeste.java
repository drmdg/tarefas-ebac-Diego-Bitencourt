import main.br.com.diego.dao.IProdutoDAO;
import main.br.com.diego.dao.ProdutoDAO;

import main.br.com.diego.domain.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTeste {

    @Test
    public void cadastrarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Computador");
        produto.setDescricao("descricao qualquer");
        produto.setValor(BigDecimal.valueOf(545));

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDb = dao.consultar(produto.getCodigo());
        assertNotNull(produtoDb);
        assertNotNull(produtoDb.getId());
        assertEquals(produto.getCodigo(), produtoDb.getCodigo());
        assertEquals(produto.getNome(), produtoDb.getNome());

        Integer qtdDel = dao.excluir(produtoDb);
        assertNotNull(qtdDel);
    }


    @Test
    public void atualizarEBuscarTodosTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Computador");
        produto.setDescricao("descricao qualquer");
        produto.setValor(BigDecimal.valueOf(51225));

        dao.cadastrar(produto);

        produto.setCodigo("02");
        produto.setNome("Celular");
        produto.setDescricao("descricao qualquer2");
        produto.setValor(BigDecimal.valueOf(3335));

        dao.cadastrar(produto);


        produto.setCodigo("03");
        produto.setNome("Mesa");
        produto.setDescricao("descricao qualquer3");
        produto.setValor(BigDecimal.valueOf(5425));

        dao.cadastrar(produto);

        produto.setCodigo("04");
        produto.setNome("Cadeira");
        produto.setDescricao("descricao qualquer4");
        produto.setValor(BigDecimal.valueOf(5125));

        dao.cadastrar(produto);


        Produto produtoDB = dao.consultar(produto.getCodigo());
        produtoDB.setNome("Ipad");
        produtoDB.setCodigo("79");
        produtoDB.setValor(BigDecimal.valueOf(5646));
        produtoDB.setDescricao("Uma outra descricao qualquer");
        dao.alterar(produtoDB);

        produto = dao.consultar(produtoDB.getCodigo());

        assertNotNull(produtoDB);
        assertNotNull(produtoDB.getId());
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getId(), produtoDB.getId());
        assertEquals(produto.getDescricao(), produtoDB.getDescricao());
        assertEquals(produto.getValor(), produtoDB.getValor());


        List<Produto> listaDeProdutos = dao.buscarTodos();
        assertEquals(4,listaDeProdutos.size());

        for (Produto prod : listaDeProdutos){
            Integer qtdDel = dao.excluir(prod);
            assertNotNull(qtdDel);
        }

    }
}
