/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorios;
import classes.Avaliacao;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class AvaliacaoRepositorio {
    
    //lista de simulacao de bd 
    private ArrayList<Avaliacao> avaliacoes;
    
    //============
    //Construtor
    //============
    
    public AvaliacaoRepositorio() {
        avaliacoes = new ArrayList<>();
    }
    
    //===================
    //Adiciona Avaliacao 
    //===================
    
    //Salva uma nova avaliacao
    public void adicionar(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }
    
    //====================
    //lista as avaliacaoes
    //====================
    
    //Retorna todas as avaliacoes
    
    public ArrayList<Avaliacao> listar() {
        return avaliacoes;
    }
    
    //===============
    //Busca pelo id 
    //===============
    
    //Busca a avaliacao pelo id
    public Avaliacao buscaPorID(int idAvaliacao){
        for (Avaliacao avaliacao : avaliacoes){
            if (avaliacao.getIdAvaliacao() == idAvaliacao){
                
                return avaliacao;
            }
        }
        
        return null; 
    }
    
    //===================
    //Remove a avaliacao 
    //===================
    
    //Remove a avaliacao utilizando o id 
    
    public boolean remover(int idAvaliacao){
        Avaliacao avaliacao = buscarPorId(idAvaliacao);
        
        if (avaliacao != null){
            avaliacoes.remove(avaliacao);
            
            return true;
        }
        
        return false;
    }
    
}
