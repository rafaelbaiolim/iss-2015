/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 02/08/2015                                                         *
 * Classe: visao.consultas.FrameConsulta                                      *
 * Coment: Classe responsavel por representar o Frame de Consulta do Sistema. *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.consultas;

import visao.Frame;
import visao.FrameModal;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public abstract class FrameConsulta extends FrameModal {
    protected JLabel            oLabelLogo;
    
    protected JTextField        oTextFieldSearch;
    protected JButton           oButtonSearch;
    
    protected JTable            oTable;
    protected DefaultTableModel oTableModel;
    protected JScrollPane       oScrollPane;
    
    protected JButton           oButtonEdit;
    protected JButton           oButtonRemove;
    protected JButton           oButtonBack;
    
    public FrameConsulta(Frame oFrameParent) {
        super(oFrameParent);
        this.initComponents();
    }
   
    private void initComponents() {
        this.setTitle("Mercado - Consulta");
        this.setLocation(360, 90);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    
    protected void addHeader(String sFile) {
        this.addLine(1);
        this.oLabelLogo = new JLabel(this.createImage("consultas/" + sFile));
        this.add(this.oLabelLogo);
        this.addLine(1);
    }
    
    protected void addTable() {
        this.oTableModel = new DefaultTableModel() {   
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex){   
                return false;   
            }};
        this.oTable      = new JTable(this.oTableModel);
        this.oScrollPane = new JScrollPane(this.oTable);
        
        this.oScrollPane.setPreferredSize(new Dimension(300, 150));
        this.add(this.oScrollPane, new FlowLayout(FlowLayout.CENTER));
        
        this.addLine(1);
    }

    protected void addColumns(String[] oColunas) {
        for (int i = 0; i < oColunas.length; ++i) {
            this.oTableModel.addColumn(oColunas[i]);
        }
    }
    
    protected void addRows(String[][] oLinhas) {
        this.clearTable();
        for (int i = 0; i < oLinhas.length; ++i) {
            this.oTableModel.addRow(oLinhas[i]);
            this.oTable.setEditingRow(JTable.AUTO_RESIZE_NEXT_COLUMN);
            this.oTable.setEditingRow(0);
        }
    }

    protected void clearTable() {
        while (this.oTableModel.getRowCount() > 0) {
            this.oTableModel.removeRow(0);
        }
        this.oTable.removeAll();
    }
    
    protected void addButtons() {
        this.oButtonEdit   = this.createButton("Editar" , "edit.jpg");
        this.oButtonRemove = this.createButton("Remover", "exit.jpg");
        this.oButtonBack   = this.createButton("Voltar" , "back.jpg");
        
        this.add(this.oButtonEdit);
        this.add(this.oButtonRemove);
        this.add(this.oButtonBack);
    }
    
    @Override
    public abstract void actionPerformed(ActionEvent oEvento);
}