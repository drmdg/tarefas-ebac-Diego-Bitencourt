public class Fibonacci {

    public int calcularFibonacci(int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }
}
