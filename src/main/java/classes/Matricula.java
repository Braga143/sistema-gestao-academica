/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.time.LocalDate;
/**
 * Classe Matricula
 * Responsável por relacionar um aluno a um curso.
 * 
 * Aplicando associação entre objetos da POO.
 *
 * @author Windows
 */
public class Matricula {
    
    // ==========================
    // ATRIBUTOS (ENCAPSULAMENTO)
    // ==========================

    // Identifica a matrícula
    private int idMatricula;

    // Objeto aluno
    private Aluno aluno;

    // Objeto curso
    private Curso curso;

    // Status da matrícula
    // Ex: ATIVA, CANCELADA, CONCLUIDA
    private String status;

    // Data da matrícula
    private LocalDate dataMatricula;

    // ==========================
    // CONSTRUTOR
    // ==========================

    /**
     * Construtor da matrícula.
     * Ao criar uma matrícula o status
     * inicia automaticamente como ATIVA.
     * @param idMatricula
     * @param aluno
     * @param curso
     * @param dataMatricula
     */
    public Matricula(int idMatricula,
                     Aluno aluno,
                     Curso curso,
                     LocalDate dataMatricula) {

        this.idMatricula = idMatricula;
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = dataMatricula;

        // Status inicial automático
        this.status = "ATIVA";
    }

    // ==========================
    // GETTERS E SETTERS
    // ==========================

    // Retorna ID da matrícula
    public int getIdMatricula() {
        return idMatricula;
    }

    // Altera ID da matrícula
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    // Retorna aluno
    public Aluno getAluno() {
        return aluno;
    }

    // Altera aluno
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    // Retorna curso
    public Curso getCurso() {
        return curso;
    }

    // Altera curso
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Retorna status
    public String getStatus() {
        return status;
    }

    // Altera status
    public void setStatus(String status) {
        this.status = status;
    }

    // Retorna data matrícula
    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    // Altera data matrícula
    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    // ==========================
    // MÉTODO UTILITÁRIO
    // ==========================

    /**
     * Exibe informações da matrícula.
     */
    public void exibirInformacoes() {

        System.out.println("=== DADOS DA MATRÍCULA ===");

        System.out.println("ID Matrícula: " + idMatricula);

        // Pegando dados do objeto Aluno
        System.out.println("Aluno: "
                + aluno.getNome());

        // Curso será exibido quando
        // Curso.java estiver pronta
        System.out.println("Curso: "
                + curso);

        System.out.println("Status: "
                + status);

        System.out.println("Data Matrícula: "
                + dataMatricula);
    }
}
