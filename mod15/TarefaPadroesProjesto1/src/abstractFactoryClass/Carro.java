package abstractFactoryClass;

public abstract class Carro {

    private int cavalos;
    private String combustivel;
    private String cor;

    public Carro(int cavalos, String combustivel, String cor) {
        this.cavalos = cavalos;
        this.combustivel = combustivel;
        this.cor = cor;
    }

    public void ligarMotor(){
        System.out.println("O motor foi ligado e está pronto para uso. Seu carro é: "+super.getClass().getSimpleName());
    }
    public void montar(){
        System.out.println("O carro está sendo montado.");
    }
    public void pintar(){
        System.out.println("O carro está sendo pintado.");
    }
    public void testeDeQualidade(){
        System.out.println("O carro está sendo testado.");
    }

}
