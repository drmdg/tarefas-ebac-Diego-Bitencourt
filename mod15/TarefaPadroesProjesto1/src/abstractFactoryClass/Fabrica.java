package abstractFactoryClass;

public abstract class Fabrica {


    public Carro criar(String valeCarro){
        Carro carro = retrieveCarro(valeCarro);
        carro = prepararCarro(carro);
        return carro;
    }

    private Carro prepararCarro(Carro carro){
        carro.montar();
        carro.pintar();
        carro.testeDeQualidade();
        return carro;
    }

    public abstract Carro retrieveCarro(String valeCarro);

}
