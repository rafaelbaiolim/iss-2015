package funct;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * <p>Classe responsavel pelas operacoes envolvendo Frames e Imagens.</p>
 * <p>Todos os metodos possuem uma especificacao acima da implementacao.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   13/10/2015
 */
public class FunctFrame {
    private ActionListener controller;
    
    /**
     * <p>Metodo responsavel por retornar uma ImageIcon pela sua descricao.</p>
     * <p>Utiliza como padrao o diretorio <b>/images/</b>.</p>
     * @since  13/10/2015
     * @param  sUrlImage URL da Imagem a ser instanciada. 
     * @return ImageIcon
     */
    public ImageIcon createImage(String sUrlImage) {
         return new ImageIcon(getClass().getResource("/images/" + sUrlImage));
    }
}