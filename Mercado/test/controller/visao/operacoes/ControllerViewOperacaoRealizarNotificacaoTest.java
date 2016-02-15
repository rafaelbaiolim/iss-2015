package controller.visao.operacoes;

import java.util.ArrayList;
import modelo.cadastrais.Cliente;
import modelo.dao.cadastrais.DaoCliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import visao.operacoes.ViewOperacaoRealizarNotificacao;

/**
 *
 * @author Leandro
 */
public class ControllerViewOperacaoRealizarNotificacaoTest {
    
    public ControllerViewOperacaoRealizarNotificacaoTest() {
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
    public void testCheckParameters() {
        assertFalse(this.classeFalha1());
        assertFalse(this.classeFalha2());
        assertFalse(this.classeFalha3());
        assertTrue(this.classeSucesso());
    }
    
    
    public boolean classeFalha1() {
        ViewOperacaoRealizarNotificacao           oView       = new ViewOperacaoRealizarNotificacao(null);
                                                  oView.setClientes(new ArrayList<Cliente>());
                                                  oView.setMessage("");
        ControllerViewOperacaoRealizarNotificacao oController = new ControllerViewOperacaoRealizarNotificacao(oView);
        return oController.checkParameters();
    }
    
    public boolean classeFalha2() {
        DaoCliente                                oDaoCliente = new DaoCliente();
        ViewOperacaoRealizarNotificacao           oView       = new ViewOperacaoRealizarNotificacao(null);
                                                  oView.setClientes(oDaoCliente.list());
                                                  oView.setMessage("");
        ControllerViewOperacaoRealizarNotificacao oController = new ControllerViewOperacaoRealizarNotificacao(oView);
        return oController.checkParameters();
    }
    
    
    public boolean classeFalha3() {
        ViewOperacaoRealizarNotificacao           oView       = new ViewOperacaoRealizarNotificacao(null);
                                                  oView.setClientes(new ArrayList<Cliente>());
                                                  oView.getTextAreaMensagem().setText("Mensagem");
        ControllerViewOperacaoRealizarNotificacao oController = new ControllerViewOperacaoRealizarNotificacao(oView);
        return oController.checkParameters();
    }
    
    public boolean classeSucesso() {
        DaoCliente                                oDaoCliente = new DaoCliente();
        ViewOperacaoRealizarNotificacao           oView       = new ViewOperacaoRealizarNotificacao(null);
                                                  oView.setClientes(oDaoCliente.list());
                                                  oView.getTextAreaMensagem().setText("Mensagem");
        ControllerViewOperacaoRealizarNotificacao oController = new ControllerViewOperacaoRealizarNotificacao(oView);
        return oController.checkParameters();
    }
}