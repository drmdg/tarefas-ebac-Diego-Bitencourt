package TiposDeContratosClasses;

import abstractFactoryClass.Carro;
import abstractFactoryClass.Fabrica;
import carros.Gol;
import carros.Hillux;

public class CarroGovernamental extends Fabrica {
    @Override
    public Carro retrieveCarro(String valeCarro) {
        if (valeCarro.equalsIgnoreCase("carro popular")){
            return new Gol(70,"gasolina","branco");
        }else if(valeCarro.equalsIgnoreCase("carro premium")){
            return new Hillux(224,"diesel","preto");
        }else{
            System.out.println("Carro não disponível");
            return null;
        }
    }
}
