import TiposDeContratosClasses.CarroGovernamental;
import TiposDeContratosClasses.CarroNaoGovernamental;
import abstractFactoryClass.Carro;
import abstractFactoryClass.Fabrica;
import cliente.Cliente;

public class Main {
    public static void main(String[] args) {


        Cliente clienteGovernamental1 = new Cliente("carro popular",true);
        Fabrica fabrica = pegarCarroDaFabrica(clienteGovernamental1);
        Carro carro = fabrica.criar(clienteGovernamental1.getValeCarro());
        carro.ligarMotor();
        System.out.println("-".repeat(70));

        Cliente clienteGovernamental2 = new Cliente("carro premium",true);
        fabrica = pegarCarroDaFabrica(clienteGovernamental2);
        carro = fabrica.criar(clienteGovernamental2.getValeCarro());
        carro.ligarMotor();
        System.out.println("-".repeat(70));

        Cliente clienteNaoGovernamental1 = new Cliente("carro popular",false);
        fabrica = pegarCarroDaFabrica(clienteNaoGovernamental1);
        carro = fabrica.criar(clienteNaoGovernamental1.getValeCarro());
        carro.ligarMotor();
        System.out.println("-".repeat(70));

        Cliente clienteNaoGovernamental2 = new Cliente("carro premium",false);
        fabrica = pegarCarroDaFabrica(clienteNaoGovernamental2);
        carro = fabrica.criar(clienteNaoGovernamental2.getValeCarro());
        carro.ligarMotor();
        System.out.println("-".repeat(70));
    }

    private static Fabrica pegarCarroDaFabrica(Cliente cliente){
        if (cliente.isGovernamental()){
            return new CarroGovernamental();
        }else{
            return new CarroNaoGovernamental();
        }
    }


}