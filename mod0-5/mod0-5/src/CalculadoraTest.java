import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculadoraTest {

    @Test
    public void testAdicionar_HappyPath(){
        final Calculadora calculadora = new Calculadora();
        assertEquals(3,calculadora.adicionar(1,2));
    }
    @Test

    public void testSubtrair_HappyPath(){
        final Calculadora calculadora = new Calculadora();
        assertEquals(-1,calculadora.subtrair(1,2));
    }

    @Test
    public void testMultiplicar_HappyPath(){
        final Calculadora calculadora = new Calculadora();
        assertEquals(2,calculadora.multiplicar(1,2));
    }

    @Test
    public void testDividir_HappyPath(){
        final Calculadora calculadora = new Calculadora();
        assertEquals(2f,calculadora.dividir(4,2),0.00001);
    }

    @Test
    public void testDividir_DivisioByZero(){
        final Calculadora calculadora = new Calculadora();
        ArithmeticException excecao = assertThrows(ArithmeticException.class,() ->{calculadora.dividir(4,0);});
        assertEquals("Divisao por 0 não permitida",excecao.getMessage());
    }


}