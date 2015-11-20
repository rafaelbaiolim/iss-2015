package visao.pesquisa;

import funct.FunctFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import visao.InterfaceView;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Pesquisa do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   03/11/2015
 */
public abstract class ViewPesquisa extends ViewModal implements InterfaceView {
    protected JTextField      jTextFieldPesquisa;
    protected JButton         jButtonPesquisa;
    
    private JTable            jTable;
    private DefaultTableModel jTableModel;
    private JScrollPane       jScrollPane;

    private final ViewModal   viewParent;
    
    /**
     * Metodo construtor, que recebe como parametro a View Parent.
     * @since   03/11/2015
     * @param   oViewParent View Parent.
     */
    public ViewPesquisa(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = oViewParent;
        this.setSettings();
    }
    
    /**
     * Metodo responsavel por inicializar os padroes das Views de Consulta.
     * @since 03/11/2015
     */
    private void setSettings() {
        this.setSize(370, 450);
        this.setLocation(400, 130);
    }
    
    /**
     * Metodo responsavel por inicializar os campos de pesquisa da View.
     * @since 22/10/2015
     */
    protected void addCampos() {
        this.jTextFieldPesquisa = new JTextField(18);
        this.jButtonPesquisa    = this.createButton("", "refresh.jpg");
        this.jButtonPesquisa.setPreferredSize(new Dimension(30, 20));
        
        this.add(this.jTextFieldPesquisa);
        this.add(this.jButtonPesquisa);
    }
    
    /**
     * Metodo responsavel por adicionar um cabecalho a View de Consulta.
     * @since 03/11/2015
     * @param sUrlImage URL do Arquivo.
     */
    protected void addHeader(String sUrlImage) {
        this.addLinhas(1);
        this.jLabelHeader = new JLabel(new FunctFrame().createImage("pesquisa/" + sUrlImage));
        this.add(this.jLabelHeader);
        this.addLinhas(1);
    }
    
    /**
     * Metodo responsavel por adicionar a Tabela no View de Consulta.
     * @since 03/11/2015 
     */
    protected void addTable() {
        this.jTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int iRowIndex, int iColIndex){   
                return false;   
            }};
        this.jTable      = new JTable(this.jTableModel);
        this.jScrollPane = new JScrollPane(this.jTable);
        
        this.jScrollPane.setPreferredSize(new Dimension(300, 150));
        this.add(this.jScrollPane, new FlowLayout(FlowLayout.CENTER));
        
        this.addLinhas(1);
    }
    
    /**
     * Metodo responsavel por definir as Colunas que serao exibidas na Tabela.
     * @since 03/11/2015 
     * @param sColumns Colunas definidas para a View.
     * @param iSizeColumns Tamanho das Colunas definidas para a View.
     */
    protected void setColumns(String[] sColumns, int[] iSizeColumns) {
        for (int i = 0; i < sColumns.length; ++i) {
            this.jTableModel.addColumn(sColumns[i]);
            this.jTable.getColumnModel().getColumn(i).setPreferredWidth(iSizeColumns[i]);
        }
    }
    
    /**
     * Metodo responsavel por adicionar Linhas na Tabela.
     * @since 03/11/2015
     * @param sRows Linhas que serao exibidas na Tabela.
     */
    public void addRows(String[][] sRows) {
        this.clearTable();
        for (int i = 0; i < sRows.length; ++i) {
            this.jTableModel.addRow(sRows[i]);
            this.jTable.setEditingRow(JTable.AUTO_RESIZE_NEXT_COLUMN);
            this.jTable.setEditingRow(0);
        }
    }
    
    /**
     * Metodo responsavel por limpar as linhas da Tabela.
     * @since 03/11/2015
     */
    public void clearTable() {
        while (this.jTableModel.getRowCount() > 0) {
            this.jTableModel.removeRow(0);
        }
        this.jTable.removeAll();
    }
    
    @Override
    public abstract void initComponents();

    @Override
    public abstract void addComponents();

    public abstract void clear();
    
    /**
     * Metodo responsavel por adicionar os botoes na View.
     * @since 03/11/2015
     */
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("Selecionar" , "select.jpg");
        this.jButtonAction2 = this.createButton("  Voltar  " , "back.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
    }

    /**
     * Metodo responsavel por retornar o Campo de Texto da Pesquisa.
     * @since  03/11/2015
     * @return JTextField Campo da Pesquisa.
     */
    public JTextField getTextFieldPesquisa() {
        return this.jTextFieldPesquisa;
    }

    /**
     * Metodo responsavel por retornar o Botao Pesquisa.
     * @since  03/11/2015
     * @return JButton Botao da Pesquisa.
     */
    public JButton getButtonPesquisa() {
        return this.jButtonPesquisa;
    }

    /**
     * Metodo responsavel por retornar a Tabela.
     * @since  03/11/2015
     * @return JTable Tabela da View Consulta.
     */
    public JTable getTable() {
        return this.jTable;
    }

    /**
     * Metodo responsavel por retornar o Modelo da Tabela.
     * @since  03/11/2015
     * @return DefaultTableModel Modelo da Tabela da View Consulta.
     */
    public DefaultTableModel getTableModel() {
        return this.jTableModel;
    }

    /**
     * Metodo responsavel por retornar o Scroll Pane da Tabela.
     * @since  03/11/2015
     * @return JScrollPane Scroll Pane da Tabela da View Consulta.
     */
    public JScrollPane getScrollPane() {
        return this.jScrollPane;
    }
    
    /**
     * Metodo responsavel por retornar o Botao de Selecionar.
     * @since  03/11/2015
     * @return JButton Botao Selecionar.
     */
    public JButton getButtonSelect() {
        return this.jButtonAction1;
    }
    
    /**
     * Metodo responsavel por retornar o Botao de Voltar.
     * @since  03/11/2015
     * @return JButton Botao Voltar.
     */
    public JButton getButtonBack() {
        return this.jButtonAction2;
    }

    /**
     * Metodo responsavel por retornar a View Parent.
     * @since  03/11/2015
     * @return ViewModal View Parent.
     */
    public ViewModal getViewParent() {
        return this.viewParent;
    }
}