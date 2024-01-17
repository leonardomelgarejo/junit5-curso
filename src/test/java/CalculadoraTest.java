import org.example.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void deveRetornarNumeroInteiroNaDivisao(){
        Calculadora calc = new Calculadora();
        float resultado = calc.dividir(6, 2);
        Assertions.assertEquals(3, resultado);
    }

    @Test
    public void deveRetornarNumeroNegativoNaDivisao(){
        Calculadora calc = new Calculadora();
        float resultado = calc.dividir(6, -2);
        Assertions.assertEquals(-3, resultado);
    }

    @Test
    public void deveRetornarNumeroDecimalNaDivisao(){
        Calculadora calc = new Calculadora();
        float resultado = calc.dividir(10, 3);
        Assertions.assertEquals(3.3333332538604736, resultado);
        Assertions.assertEquals(3.33, resultado, 0.01);
    }

    @Test
    public void deveRetornarZeroComNumeradorZeroNaDivisao(){
        Calculadora calc = new Calculadora();
        float resultado = calc.dividir(0, 2);
        Assertions.assertEquals(0, resultado);
    }

    @Test
    public void deveLancarExcecaoQuandoDividirPorZero_Junit4(){
        try{
            float resultado = 10 / 0;
            Assertions.fail("Deveria ter sido lançcada uma exceção na divisão");
        } catch (ArithmeticException e){
            Assertions.assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void deveLancarExcecaoQuandoDividirPorZero_Junit5(){
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            float resultado = 10 / 0;
        });
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }
}
