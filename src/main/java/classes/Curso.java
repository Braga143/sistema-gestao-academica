/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import classes.Professor;
/**
 *
 * @author Windows
 */
public class Curso {
    
    private int idCurso;
    private String tituloCurso;
    private String descricao;
    private String cargaHoraria;
    private String turno;
    private String diasSemana;
    private int quantidadeMaximaAlunos;
    private Professor professor;
    private String status;
    private int quantidadeMatriculados;
    
    public Curso(int idCurso, String tituloCurso, String descricao, String cargaHoraria, String turno, String diasSemana, int quantidadeMaximaAlunos, Professor professor, int quantidadeMatriculados) {
    this.idCurso = idCurso;
    this.tituloCurso = tituloCurso;
    this.descricao = descricao;
    this.cargaHoraria = cargaHoraria;
    this.turno = turno;
    this.diasSemana = diasSemana;
    this.quantidadeMaximaAlunos = quantidadeMaximaAlunos;
    this.professor = professor;
    this.quantidadeMatriculados = quantidadeMatriculados;
    }

    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the tituloCurso
     */
    public String getTituloCurso() {
        return tituloCurso;
    }

    /**
     * @param tituloCurso the tituloCurso to set
     */
    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the cargaHoraria
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the diasSemana
     */
    public String getDiasSemana() {
        return diasSemana;
    }

    /**
     * @param diasSemana the diasSemana to set
     */
    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    /**
     * @return the quantidadeMaximaAlunos
     */
    public int getQuantidadeMaximaAlunos() {
        return quantidadeMaximaAlunos;
    }

    /**
     * @param quantidadeMaximaAlunos the quantidadeMaximaAlunos to set
     */
    public void setQuantidadeMaximaAlunos(int quantidadeMaximaAlunos) {
        this.quantidadeMaximaAlunos = quantidadeMaximaAlunos;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the quantidadeMatriculados
     */
    public int getQuantidadeMatriculados() {
        return quantidadeMatriculados;
    }

    /**
     * @param quantidadeMatriculados the quantidadeMatriculados to set
     */
    public void setQuantidadeMatriculados(int quantidadeMatriculados) {
        this.quantidadeMatriculados = quantidadeMatriculados;
    }
    
    public boolean possuiVaga() {
        return quantidadeMatriculados < quantidadeMaximaAlunos;
    }
    
    public void adicionarAluno() {
        if (possuiVaga())
            quantidadeMatriculados ++;
    }
}