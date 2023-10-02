
import main.java.br.com.diego.dao.IProdutoDao;
import main.java.br.com.diego.dao.ProdutoDao;
import main.java.br.com.diego.domain.Produto;
import org.junit.After;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {

    private IProdutoDao produtoDao;

    public ProdutoTest(){
        produtoDao=new ProdutoDao();
    }

    @After
    public void end() {
        List<Produto> list = produtoDao.buscarTodos();
        list.forEach(mat -> produtoDao.excluir(mat));
    }



    @Test
    public void cadastrar(){
        Produto prod = new Produto();
        prod.setDescricao("Descricao 1");
        prod.setFabricante("Fabricante 1");
        prod.setValor(200d);
        produtoDao.cadastrar(prod);

        Produto prod1 = new Produto();
        prod1.setDescricao("Descricao 2");
        prod1.setFabricante("Fabricante 2");
        prod1.setValor(300d);
        produtoDao.cadastrar(prod1);

        Produto prod2 = new Produto();
        prod2.setDescricao("Descricao 3");
        prod2.setFabricante("Fabricante 3");
        prod2.setValor(500d);
        produtoDao.cadastrar(prod2);

        Produto prod3 = new Produto();
        prod3.setDescricao("Descricao 5");
        prod3.setFabricante("Fabricante 5");
        prod3.setValor(400d);
        produtoDao.cadastrar(prod3);

    }
}
