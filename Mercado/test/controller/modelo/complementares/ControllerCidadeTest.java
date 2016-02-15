package controller.modelo.complementares;

import modelo.dao.complementares.DaoUF;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de Teste da Classe de Modelo Cidade.
 * @author  Leandro
 * @version 1.0
 * @since   10/01/2016
 */
public class ControllerCidadeTest {
    
    public ControllerCidadeTest() {
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
        assertFalse(new ControllerCidade().checkNome(""));
        assertFalse(new ControllerCidade().checkNome("A"));
        assertFalse(new ControllerCidade().checkNome("1"));
        assertFalse(new ControllerCidade().checkNome("$"));
        assertFalse(new ControllerCidade().checkNome("A "));
        assertFalse(new ControllerCidade().checkNome("1 "));
        assertFalse(new ControllerCidade().checkNome("12"));
        assertFalse(new ControllerCidade().checkNome("AB"));
        
        // Nomes Validos:
        assertTrue(new ControllerCidade().checkNome("AAA"));
        assertTrue(new ControllerCidade().checkNome("B 1 3"));
        assertTrue(new ControllerCidade().checkNome("SAO JOSE"));
    }

    /**
     * Esse teste pode variar conforme o Banco de Dados da Aplicacao.
     */
    @Test
    public void testCidadeIsAvailable() {
        DaoUF daoUF = new DaoUF();
        
        // Cidades Cadastradas:
        assertFalse(new ControllerCidade().cidadeIsAvailable("Maringa", daoUF.findUFBySigla("PR")));
        assertFalse(new ControllerCidade().cidadeIsAvailable("Londrina", daoUF.findUFBySigla("PR")));
        assertFalse(new ControllerCidade().cidadeIsAvailable("Maringa", null));
        
        // Cidades Nao Cadastradas:
        assertTrue(new ControllerCidade().cidadeIsAvailable("Maringa", daoUF.findUFBySigla("SP")));
        assertTrue(new ControllerCidade().cidadeIsAvailable("Londrina", daoUF.findUFBySigla("PA")));
        assertTrue(new ControllerCidade().cidadeIsAvailable("Sao Paulo", daoUF.findUFBySigla("SP")));
        assertTrue(new ControllerCidade().cidadeIsAvailable("", null));
    }
}