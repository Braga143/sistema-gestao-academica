/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 * Classe Avaliacao
 * Responsável por armazenar informações
 * sobre desempenho do aluno no curso.
 *
 * @author Windows
 */
public class Avaliacao {
     // ==========================
    // ATRIBUTOS (ENCAPSULAMENTO)
    // ==========================

    // Identificador da avaliação
    private int idAvaliacao;

    // Ligação com matrícula
    private Matricula matricula;

    // Nota do aluno
    private double nota;

    // Comentário do professor
    private String comentario;

    // Situação do aluno
    // APROVADO ou REPROVADO
    private String situacao;

    // Controle do certificado
    private boolean certificadoEmitido;

    // ==========================
    // CONSTRUTOR
    // ==========================

    /**
     * Construtor da avaliação.
     * Situação e certificado são
     * definidos automaticamente.
     * @param idAvaliacao
     * @param matricula
     * @param nota
     * @param comentario
     */
    public Avaliacao(int idAvaliacao,
                     Matricula matricula,
                     double nota,
                     String comentario) {

        this.idAvaliacao = idAvaliacao;
        this.matricula = matricula;
        this.nota = nota;
        this.comentario = comentario;

        // Regra automática da avaliação
        definirSituacao();
    }

    // ==========================
    // REGRA DE NEGÓCIO
    // ==========================

    /**
     * Define automaticamente situação
     * e certificado do aluno.
     */
    private void definirSituacao() {

        if (nota >= 7) {

            this.situacao = "APROVADO";
            this.certificadoEmitido = true;

        } else {

            this.situacao = "REPROVADO";
            this.certificadoEmitido = false;
        }
    }

    /**
     * Emite certificado do aluno.
     */
    public void emitirCertificado() {

        if (certificadoEmitido) {

            System.out.println("\n===== CERTIFICADO =====");

            System.out.println("Aluno: "
                    + matricula.getAluno().getNome());

            System.out.println("Curso: "
                    + matricula.getCurso());

            System.out.println("Situação: "
                    + situacao);

            System.out.println("Certificado emitido com sucesso!");

        } else {

            System.out.println(
                    "Aluno reprovado. "
                    + "Certificado indisponível."
            );
        }
    }

    // ==========================
    // GETTERS E SETTERS
    // ==========================

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {

        this.nota = nota;

        // Atualiza situação automaticamente
        definirSituacao();
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getSituacao() {
        return situacao;
    }

    public boolean isCertificadoEmitido() {
        return certificadoEmitido;
    }

    // ==========================
    // MÉTODO UTILITÁRIO
    // ==========================

    /**
     * Exibe informações da avaliação.
     */
    public void exibirInformacoes() {

        System.out.println("\n=== DADOS DA AVALIAÇÃO ===");

        System.out.println("ID Avaliação: "
                + idAvaliacao);

        System.out.println("Aluno: "
                + matricula.getAluno().getNome());

        System.out.println("Nota: "
                + nota);

        System.out.println("Comentário: "
                + comentario);

        System.out.println("Situação: "
                + situacao);
    }
}
