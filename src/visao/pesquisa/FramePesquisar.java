/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 05/08/2015                                                         *
 * Classe: visao.pesquisa.FramePesquisar                                      *
 * Coment: Classe responsavel por representar o Frame de Pesquisa do Sistema. *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.pesquisa;

import visao.FrameModal;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public abstract class FramePesquisar extends FrameModal {
    protected JTextField        oTextFieldSearch;
    
    protected JTable            oTable;
    protected DefaultTableModel oTableModel;
    protected JScrollPane       oScrollPane;
    
    protected JButton           oButtonUpdate;
    protected JButton           oButtonOk;
    protected JButton           oButtonCancel;

    public FramePesquisar(FrameModal oFrame) {
        super(oFrame, "Mercado - Pesquisa");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Consulta");
        this.setSize(450, 350);
        this.setLocation(320, 200);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    
    protected void addSearchField() {
        this.oTextFieldSearch = new JTextField(15);
        this.oButtonUpdate    = this.createButton("Atualizar", "search.jpg");
        this.add(this.oTextFieldSearch);
        this.add(this.oButtonUpdate);
    }
    
    protected void addTable() {
        this.oTableModel = new DefaultTableModel() {   
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex){   
                return false;   
            }};
        this.oTable      = new JTable(this.oTableModel);
        this.oScrollPane = new JScrollPane(this.oTable);
        
        this.oScrollPane.setPreferredSize(new Dimension(400, 150));
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
        this.oButtonOk     = this.createButton("   Ok   ", "yes.jpg");
        this.oButtonCancel = this.createButton("Cancelar", "no.jpg");
        
        this.add(this.oButtonOk);
        this.add(this.oButtonCancel);
    }

    @Override
    public abstract void actionPerformed(ActionEvent oEvento);
}