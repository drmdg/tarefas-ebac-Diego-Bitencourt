import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void testFibonacciPrimeiroElemento(){
        final Fibonacci fibonacci = new Fibonacci();

        assertEquals(1,fibonacci.calcularFibonacci(1));
    }

    @Test
    public void testFibonacciSegundoElemento(){
        final Fibonacci fibonacci = new Fibonacci();

        assertEquals(1,fibonacci.calcularFibonacci(2));
    }

    @Test
    public void testFibonacciDecimoElemento(){
        final Fibonacci fibonacci = new Fibonacci();

        assertEquals(55,fibonacci.calcularFibonacci(10));
    }
}