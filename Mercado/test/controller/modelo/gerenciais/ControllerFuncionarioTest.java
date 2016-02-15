package controller.modelo.gerenciais;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de Teste da Classe de Modelo Funcionario.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 */
public class ControllerFuncionarioTest {
    
    public ControllerFuncionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCheckNome() {
        // Nomes Invalidos:
        assertFalse(new ControllerFuncionario().checkNome(""));
        assertFalse(new ControllerFuncionario().checkNome("A "));
        assertFalse(new ControllerFuncionario().checkNome(" b "));
        assertFalse(new ControllerFuncionario().checkNome("  Ab"));
        assertFalse(new ControllerFuncionario().checkNome("CF  "));
        
        // Nomes Validos:
        assertTrue(new ControllerFuncionario().checkNome("A1C"));
        assertTrue(new ControllerFuncionario().checkNome(" D0F "));
        assertTrue(new ControllerFuncionario().checkNome("G1I "));
        assertTrue(new ControllerFuncionario().checkNome(" J32"));
        assertTrue(new ControllerFuncionario().checkNome("PEDRO SANTOS"));
    }

    @Test
    public void testCheckCpf() {
        // CPFs Invalidos:
        assertFalse(new ControllerFuncionario().checkCpf("000000000000..-"));
        assertFalse(new ControllerFuncionario().checkCpf("000000000000"));
        assertFalse(new ControllerFuncionario().checkCpf("000000000O0"));
        assertFalse(new ControllerFuncionario().checkCpf("AB$432432132"));
        assertFalse(new ControllerFuncionario().checkCpf("1111111111111"));
        
        // CPFs Validos:
        assertTrue(new ControllerFuncionario().checkCpf("012.143.430-56"));
        assertTrue(new ControllerFuncionario().checkCpf("02132343232"));
    }

    /**
     * Teste pode variar conforme o BD da aplicacao.
     */
    @Test
    public void testCpfIsAvailable() {
        // CPFs ja Cadastrados:
        assertFalse(new ControllerFuncionario().cpfIsAvailable("111.111.111-10"));
        assertFalse(new ControllerFuncionario().cpfIsAvailable("111.111.111-11"));
        
        // CPFs nao Cadastrados:
        assertTrue(new ControllerFuncionario().cpfIsAvailable("111.111.111-12"));
        assertTrue(new ControllerFuncionario().cpfIsAvailable("00000000000"));
        assertTrue(new ControllerFuncionario().cpfIsAvailable("00000000003"));
        assertTrue(new ControllerFuncionario().cpfIsAvailable("00A00000003"));
        assertTrue(new ControllerFuncionario().cpfIsAvailable(""));
    }

    @Test
    public void testCheckCargo() {
        // Cargo Invalido:
        assertFalse(new ControllerFuncionario().checkCargo(""));
        
        // Cargos Validos:
        assertTrue(new ControllerFuncionario().checkCargo("A "));
        assertTrue(new ControllerFuncionario().checkCargo(" 1"));
        assertTrue(new ControllerFuncionario().checkCargo("21"));
        assertTrue(new ControllerFuncionario().checkCargo("av"));
        assertTrue(new ControllerFuncionario().checkCargo("BALCONISTA"));
    }

    @Test
    public void testCheckCargaHoraria() {
        // Carga Horaria Invalida:
        assertFalse(new ControllerFuncionario().checkCargaHoraria(""));
        assertFalse(new ControllerFuncionario().checkCargaHoraria("1A"));
        assertFalse(new ControllerFuncionario().checkCargaHoraria("1 "));
        assertFalse(new ControllerFuncionario().checkCargaHoraria(" 10 "));
        assertFalse(new ControllerFuncionario().checkCargaHoraria("-1"));
        
        // Carga Horaria Valida:
        assertTrue(new ControllerFuncionario().checkCargaHoraria("10"));
        assertTrue(new ControllerFuncionario().checkCargaHoraria("7"));
        assertTrue(new ControllerFuncionario().checkCargaHoraria("0"));
    }

    @Test
    public void testCheckSalario() {
        // Salarios Invalidos:
        assertFalse(new ControllerFuncionario().checkSalario(""));
        assertFalse(new ControllerFuncionario().checkSalario("1"));
        assertFalse(new ControllerFuncionario().checkSalario("13.3A"));
        assertFalse(new ControllerFuncionario().checkSalario(".30"));
        assertFalse(new ControllerFuncionario().checkSalario("-3.30"));
        
        // Salarios Validos:
        assertTrue(new ControllerFuncionario().checkSalario("300.30"));
        assertTrue(new ControllerFuncionario().checkSalario("1000.3"));
        assertTrue(new ControllerFuncionario().checkSalario("400.0"));
    }
}