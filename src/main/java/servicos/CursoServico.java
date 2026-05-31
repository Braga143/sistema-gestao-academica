/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import classes.Curso;
import classes.Professor;

import repositorios.CursoRepositorio;
import repositorios.ProfessorRepositorio;

import java.util.List;

/**
 *Regras de negocio do curso 
 * @author Windows
 */
public class CursoServico {
    
    //Repositorio dos cursos
    private CursoRepositorio.CursoRepo cursoRepo;
    
    //Repositorio de professores
    private ProfessorRepositorio professorRepo;
    
    //===========
    //Construtor
    //===========
    public CursoServico(CursoRepositorio.CursoRepo cursoRepo, ProfessorRepositorio professorRepo){
        this.cursoRepo = cursoRepo;
        this.professorRepo = professorRepo;
    }
    
    //==================
    //cadastrar o curso
    //==================
    
    public void cadastrarCurso(int idCurso, String tituloCurso, String descricao, String cargaHoraria, String turno, String diasSemana, int quantidadeMaximaAlunos, int idProfessor){
        
        //Fazer a busca do professor no repositorio
        Professor professor = professorRepo.buscaPorId(idProfessor);
        
        //caso nao encontre o professor no array
        if(professor ==null){
            System.out.println("Professor nao encontrato. ");
            
            return;
        }
        
        // criar um curso
        Curso curso = new Curso(idCurso, tituloCurso, descricao, cargaHoraria, turno, diasSemana, quantidadeMaximaAlunos, professor,0);
        
        //Salvar o curso
        cursoRepo.salvar(curso);
        System.out.println("Curso adastrado " + "com sucesso!");
    }
    
    //===================
    //Lista os cursos
    //================
    
    public List<Curso> listarCursos(){
        return cursoRepo.listarTodos();
    }
    
    //========================
    //Fazer a busca dos cursos pelo id
    //========================
    public Curso buscarPorId(int idCurso){
        return cursoRepo.buscaPorId(idCurso);
    }
    
    //========================
    //Remover o curso pelo id
    //========================
    public boolean removerCurso(int idCurso){
        return cursoRepo.remover(idCurso);
    }
    
    //==============================
    //Atualiza os cursos existentes.
    //==============================
    public void atualizarCurso(Curso curso){
        cursoRepo.atualizar(curso);
    };
}
