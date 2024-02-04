import java.math.BigInteger;

public class FatorialBigInteger {
    public static void main(String[] args) {
        BigInteger FatorialBigInteger = calcularFatorial(7);
        System.out.println("O fatorial é: " + FatorialBigInteger);
    }
    private static BigInteger calcularFatorial(int n) {
        BigInteger resultado = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }
}
