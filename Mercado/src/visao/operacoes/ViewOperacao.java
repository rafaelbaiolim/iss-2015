package visao.operacoes;

import funct.FunctFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import visao.InterfaceView;
import visao.View;
import visao.ViewModal;

/**
 * Classe responsavel por definir a Interface de Operacoes do Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   28/12/2015
 */
public abstract class ViewOperacao extends ViewModal implements InterfaceView {
    private JTable            jTable;
    private DefaultTableModel jTableModel;
    private TableColumnModel  jColumnModel;
    protected JScrollPane       jScrollPane;
    
    private int[]             sizeColumns;

    /**
     * Metodo construtor, que recebe como parametro a View Parent.
     * @param oViewParent View Parent.
     */
    public ViewOperacao(View oViewParent) {
        super(oViewParent);
        this.setSettings();
    }
    
    /**
     * Metodo responsavel por inicializar os padroes das Views de Consulta.
     */
    private void setSettings() {
        this.setSize(370, 450);
        this.setLocation(400, 130);
    }
    
    /**
     * Metodo responsavel por adicionar um cabecalho a View de Consulta.
     * @since   28/12/2015
     * @param   sUrlImage URL do Arquivo.
     */
    protected void addHeader(String sUrlImage) {
        this.addLinhas(1);
        this.jLabelHeader = new JLabel(new FunctFrame().createImage("operacoes/" + sUrlImage));
        this.add(this.jLabelHeader);
        this.addLinhas(1);
    }
    
    /**
     * Metodo responsavel por adicionar a Tabela no View de Consulta.
     */
    protected void addTable() {
        this.jTableModel  = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int iRowIndex, int iColIndex){   
                return false;   
            }};
        this.jTable       = new JTable(this.jTableModel);
        this.jColumnModel = this.jTable.getColumnModel(); 
        this.jTable.addKeyListener(this.controller);
        this.jScrollPane  = new JScrollPane(this.jTable);
        
        this.jScrollPane.setPreferredSize(new Dimension(400, 150));
        this.add(this.jScrollPane, new FlowLayout(FlowLayout.CENTER));
        
        this.addLinhas(1);
    }
    
    /**
     * Metodo responsavel por definir as Colunas que serao exibidas na Tabela.
     * @param sColumns Colunas definidas para a View.
     */
    protected void setColumns(String[] sColumns) {
        for (int i = 0; i < sColumns.length; ++i) {
            this.jTableModel.addColumn(sColumns[i]);
        }
    }
    
    /**
     * Metodo responsavel por adicionar Linhas na Tabela.
     * @param sRows Linhas que serao exibidas na Tabela.
     */
    public void addRows(String[][] sRows) {
        this.clearTable();
        for (int i = 0; i < sRows.length; ++i) {
            this.jTableModel.addRow(sRows[i]);
            this.jTable.setEditingRow(0);
        }
        this.resizeColumn();
    }
    
    /**
     * Metodo responsavel por definir o tamanho das colunas.
     * @param iSizeColumns Tamanho das Colunas.
     */
    public void setColumnSize(int[] iSizeColumns) {
        this.sizeColumns = iSizeColumns;
    }
    
    /**
     * Metodo responsavel por definir o tamanho das colunas.
     */
    private void resizeColumn() {
        for (int i = 0; i < this.sizeColumns.length; ++i) {
            this.jTable.getColumnModel().getColumn(i).setPreferredWidth(this.sizeColumns[i]);  
        }
    }
    
    /**
     * Metodo responsavel por limpar as linhas da Tabela.
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
     */
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("Gravar" , "save.jpg");
        this.jButtonAction2 = this.createButton("Limpar" , "clear.jpg");
        this.jButtonAction3 = this.createButton("Voltar" , "back.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }

    /**
     * Metodo responsavel por retornar a Tabela.
     * @return JTable Tabela da View Consulta.
     */
    public JTable getTable() {
        return this.jTable;
    }

    /**
     * Metodo responsavel por retornar o Modelo da Tabela.
     * @return DefaultTableModel Modelo da Tabela da View Consulta.
     */
    public DefaultTableModel getTableModel() {
        return this.jTableModel;
    }

    /**
     * Metodo responsavel por retornar o Scroll Pane da Tabela.
     * @return JScrollPane Scroll Pane da Tabela da View Consulta.
     */
    public JScrollPane getScrollPane() {
        return this.jScrollPane;
    }
    
    /**
     * Metodo responsavel por retornar o Botao de Editar.
     * @return JButton Botao Gravar.
     */
    public JButton getButtonSave() {
        return this.jButtonAction1;
    }
    
    /**
     * Metodo responsavel por retornar o Botao de Remocao.
     * @return JButton Botao Editar.
     */
    public JButton getButtonEdit() {
        return this.jButtonAction2;
    }
    
    /**
     * Metodo responsavel por retornar o Botao de Voltar.
     * @return JButton Botao Voltar.
     */
    public JButton getButtonBack() {
        return this.jButtonAction3;
    }
}