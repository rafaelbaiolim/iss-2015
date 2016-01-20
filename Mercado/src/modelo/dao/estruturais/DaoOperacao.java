package modelo.dao.estruturais;

import java.util.List;
import modelo.dao.Dao;
import modelo.estruturais.Operacao;
import modelo.estruturais.Usuario;

public class DaoOperacao extends Dao<Operacao> {

    public DaoOperacao() {
        super(Operacao.class);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Operacoes feitas por um Usuario.
     * @param  oUsuario Usuario.
     * @return Lista de Operacoes encotradas.
     */
    public List<Operacao> findOperacoesByUsuario(Usuario oUsuario) {
        String sSql = "SELECT e FROM Operacao e WHERE e.usuario.id = " + oUsuario.getId().toString();
        return (List<Operacao>) acesso.createQuery(sSql).getResultList();
    }
    
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais das Operacoes.
     * @param  oOperacoes Listas de Operacoes a serem listadas.
     * @return Matriz com os dados das Operacoes.
     */
    public String[][] getOperacoes(List<Operacao> oOperacoes) {
        String[][] sOperacoes = new String[oOperacoes.size()][3];
        for (int i = 0; i < oOperacoes.size(); ++i) {
            sOperacoes[i] = oOperacoes.get(i).getInfo();
        }
        return sOperacoes;
    }
}