import main.java.br.com.diego.dao.*;
import main.java.br.com.diego.domain.Acessorio;
import main.java.br.com.diego.domain.Carro;
import main.java.br.com.diego.domain.Marca;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class Teste {


    private IAcessorioDao acessorioDao;
    private ICarroDao carroDao;
    private IMarcaDao marcaDao;

    public Teste() {
        acessorioDao = new AcessorioDao();
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();

    }

    @After
    public void end() {
        List<Acessorio> listAc = acessorioDao.buscarTodos();
        listAc.forEach(acessorio -> acessorioDao.excluir(acessorio));

        List<Carro> listCar = carroDao.buscarTodos();
        listCar.forEach(carro -> carroDao.excluir(carro));

        List<Marca> listMarc = marcaDao.buscarTodos();
        listMarc.forEach(marca -> marcaDao.excluir(marca));
    }


    @Test
    public void cadastrar() {
        Carro carro= new Carro();
        Carro carro1= new Carro();
        Acessorio acessorio = new Acessorio();
        Acessorio acessorio1 = new Acessorio();
        Marca marca = new Marca();

        marca.setCodigo("a1");
        marca.setNome("Chevrolet");

        carro.setCodigo("a11");
        carro.setMarca(marca);
        carro.setNome("Opala");

        carro1.setCodigo("a21");
        carro1.setMarca(marca);
        carro1.setNome("Corvette");

        acessorio.setNome("Escapamento 6x2");
        acessorio.setCodigo("a323");
        acessorio.setCarro(carro);

        acessorio1.setNome("Escapamento 8x4x2");
        acessorio1.setCodigo("a3");
        acessorio1.setCarro(carro1);

        carro1.add(acessorio1);
        carro.add(acessorio);
        marca.add(carro);
        marca.add(carro1);

        marcaDao.cadastrar(marca);
        carroDao.cadastrar(carro);
        carroDao.cadastrar(carro1);
        acessorioDao.cadastrar(acessorio);
        acessorioDao.cadastrar(acessorio1);


    }
}
