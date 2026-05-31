/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import classes.Aluno;
import classes.Curso;
import classes.Matricula;

import repositorios.MatriculaRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *Servicos responssaveis pelas regras de negocio da matricula
 * 
 * @author Windows
 */
public class MatriculaServico {
    
    //repositorio de matricula
    private MatriculaRepositorio matriculaRepo;
    
    
    //=============
    //COnstrutor
    //=============
    
    public MatriculaServico(MatriculaRepositorio matriculaRepo){
        this.matriculaRepo = matriculaRepo;
    }
    
    //==================
    //Fazer a matricula
    //==================
    
    //Faz a matricula do aluno
    public void matricularAluno(int idMatricula, Aluno aluno, Curso curso){
        
        //Laco para verificar se possue vaga antes de realizar matricula
        if(!curso.possuiVaga()){
            System.out.println("Curso sem vagas disponivel. ");
            
            return;
        }
        
        //Laco para validar a matricula e verificar se ja existe
        for(Matricula matricula : matriculaRepo.listar()){
            if(matricula.getAluno().getId()==aluno.getId()
                    && matricula.getCurso().getIdCurso()==curso.getIdCurso()){
                System.out.println("Aluno ja cadastrado " + "Neste curso. ");
                
                return;
            }
        }
        
        //Depois da validacao cria a matricula
        Matricula matricula = new Matricula(idMatricula, aluno, curso, LocalDate.now());
        
        //Agora salva no repositorio
        matriculaRepo.adcionar(matricula);
        
        //Depois da matricula criada incrementa na vaga como ocupada
        curso.adicionarAluno();
        System.out.println("Matricula realizada" + "Com sucesso! ");
    }
    
    //======================
    //Listando as matriculas
    //======================
    
    //busca as matriculas atravez do id
    public Matricula buscarPord(int idMatricula){
        
        return matriculaRepo.buscaPorId(idMatricula);
    }
   
    //====================================
    //para cancelar uma matricula
    //====================================
    
    /*O laco percorre o id da matricula no repositorio array para validar
    caso nao encontre tambem exibira menssagem de erro*/ 
    public boolean cancelarmatricula(int idMatricula){
        Matricula matricula = matriculaRepo.buscaPorId(idMatricula);
        
        if(matricula == null){
            System.out.println("Matricula nao encontrada. ");
            
            return false;
        }
        
        //atualiza o estatus
        matricula.setStatus("Cancelada");
        
        //Libera vaga do curso para novas matriculas
        matricula.getCurso().removerAluno();
        
        //remove a matricula
        matriculaRepo.remover(idMatricula);
        System.out.println("Matricula removida com sucesso! ");
        
        return true;
    }
}
