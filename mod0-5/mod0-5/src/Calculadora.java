/**
 * Classe Calculador que permitir com que se efetue as 4 operações básicas
 */
public class Calculadora {

    /**
     * Efetua a soma: a + b
     */
    public int adicionar(int a,int b){
        return a+b;
    }
    /**
     * Efetua a subtração: a - b
     */
    public int subtrair(int a,int b){
        return a-b;
    }
    /**
     * Efetua a multiplicação: a * b
     */
    public int multiplicar(int a,int b){
        return a*b;
    }

    /**
     * Efetua a seguinte divisão: a/b
     *
     * Caso b seja 0, lança ArithmeticException com a seguinte mensagem: "Divisao por 0 não permitida"
     */
    public float dividir(int a,int b){
        float divisao=0;
        try{
           divisao = a/b;
       }catch (ArithmeticException e){
           throw new ArithmeticException("Divisao por 0 não permitida");
       }
       return divisao;
    }

}