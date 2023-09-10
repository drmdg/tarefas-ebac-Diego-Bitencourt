package TiposDeContratosClasses;

import abstractFactoryClass.Carro;
import abstractFactoryClass.Fabrica;
import carros.Celta;
import carros.Mercedes;

public class CarroNaoGovernamental extends Fabrica {
    @Override
    public Carro retrieveCarro(String valeCarro) {
        if (valeCarro.equalsIgnoreCase("carro popular")){
            return new Celta(70,"gasolina","vermelho");
        }else if(valeCarro.equalsIgnoreCase("carro premium")){
            return new Mercedes(224,"gasolina","Cinza escuro");
        }else{
            System.out.println("Carro não disponível");
            return null;
        }
    }
}
