/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import classes.Avaliacao;
import classes.Matricula;

import repositorios.AvaliacaoRepositorio;

import java.util.ArrayList;



/**
 *servico responssavel pelas regras de negocio da avaliacao
 * @author Windows
 */
public class AvaliacaoServico {
    
    //repositorio da avaliacao 
    private AvaliacaoRepositorio avaliacaoRepo;
    
    //============
    //COnstrutor
    //============
    public AvaliacaoServico(AvaliacaoRepositorio avaliacaoRepo){
        this.avaliacaoRepo = avaliacaoRepo;
    }
    
    //Fazer a validacao
    
    //cria a avaliacao do aluno
    public void avaliarAluno(int idAvaliacao, Matricula matricula, double nota, String comentario){
        
        //antes de avaliar verifica se ja existe
        for(Avaliacao avaliacao : avaliacaoRepo.listar()){
            if(avaliacao.getMatricula().getIdMatricula() == matricula.getIdMatricula()){
                System.out.println("Aluno ja possui " + "Avaliacao. ");
                
                return;
            }
        }
        
        //Caso a avalaicao nao exista, agora cria a avaliacao
        Avaliacao avaliacao = new Avaliacao(idAvaliacao, matricula, nota, comentario);
        
        //salvar a avaliacao
        avaliacaoRepo.adicionar(avaliacao);
        System.out.println("Avaliacao realisada " + "Com Sucesso! ");
        
        // Emissao de sertificado de forma automatica
        if(avaliacao.isCertificadoEmitido()){
            avaliacao.emitirCertificado();
        }
    }
    
    //==============
    //Listar os certificados
    
    //o sistema retorna a lista das avaliacoes 
    
    public ArrayList <Avaliacao> listarAvaliacaos(){
        return avaliacaoRepo.listar();
    }
    
    //Busca a avalaiacao pelo id
    public Avaliacao buscaPorId(int idAvaliacao){
        
        return avaliacaoRepo.buscaPorID(idAvaliacao);
    }
    
    //====================
    //Remocao da avaliacao 
    //====================
    
    //Remove a avaliacao do sistema
    public boolean removerAvaliacao(int idAvaliacao){
        Avaliacao avaliacao = avaliacaoRepo.buscaPorID(idAvaliacao);
        
        //Caso a avalaicao nao seja encontrata 
        if(avaliacao == null){
            System.out.println("Avalaiacao nao encontrada. ");
            
            return false;
        }
        
        avaliacaoRepo.remover(idAvaliacao);
            System.out.println("Avalaicao removida " + "Com Sucesso! ");
            
            return true;
    }
}
