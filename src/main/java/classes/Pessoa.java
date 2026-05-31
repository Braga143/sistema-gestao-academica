package classes;
import java.time.LocalDate;

/**
 *
 * @author Windows
 */
public class Pessoa {
     // ==========================
    // ATRIBUTOS (ENCAPSULAMENTO) SUPERCLASSE
    // ==========================

    // Identificador único da pessoa
    int id;

    // Nome completo
    private String nome;

    // E-mail para contato/login
    private String email;

    // Telefone da pessoa
    private String telefone;

    // Data de nascimento
    private LocalDate dataNascimento;

    // ==========================
    // CONSTRUTOR
    // ==========================

    /**
     * Construtor da classe Pessoa
     * Responsável por inicializar os atributos.
     * @param id
     * @param nome
     * @param email
     * @param telefone
     * @param dataNascimento
     */
    public Pessoa(int id, String nome, String email, 
                   String telefone, LocalDate dataNascimento) {

        this.id = id;
        this.nome = nome;
        setEmail(email);
        this.telefone = telefone;
        this.dataNascimento = dataNascimento; 
    }

    // ==========================
    // GETTERS E SETTERS
    // ==========================

    // Retorna o ID
    public int getId() {
        return id;
    }

    // Altera o ID
    public void setId(int id) {
        this.id = id;
    }

    // Retorna o nome
    public String getNome() {
        return nome;
    }

    // Altera o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o e-mail
    public String getEmail() {
        return email;
    }

    /**
     * Validação simples de e-mail.
     * @param email
     */
    public void setEmail(String email) {

        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("E-mail inválido!");
        }
    }

    // Retorna telefone
    public String getTelefone() {
        return telefone;
    }

    // Altera telefone
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Retorna data nascimento
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Altera data nascimento
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // ==========================
    // MÉTODO UTILITÁRIO
    // ==========================

    /**
     * Exibe informações da pessoa.
     * Pode ser reutilizado por Aluno e Professor.
     */
    public void exibirInformacoes() {

        System.out.println("=== DADOS DA PESSOA ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data de Nascimento: " + dataNascimento);
    }
}
