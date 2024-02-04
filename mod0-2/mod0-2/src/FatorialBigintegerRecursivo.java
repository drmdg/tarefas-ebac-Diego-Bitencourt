import java.math.BigInteger;

public class FatorialBigintegerRecursivo {
    public static void main(String[] args) {
        int numero = 14165;

        BigInteger resultado = calcularFatorial(BigInteger.valueOf(numero));

        System.out.println("Fatorial de " + numero + " é: " + resultado);
    }

    private static BigInteger calcularFatorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(calcularFatorial(n.subtract(BigInteger.ONE)));
        }
    }
}

