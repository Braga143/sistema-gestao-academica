package classes; 

import java.time.LocalDate;

/**
 * Classe Aluno
 * Herda informações da classe Pessoa.
 * 
 * Aplicando conceito de HERANÇA da POO.
 * 
 * @author Windows
 */
public class Aluno extends Pessoa {
    // 1. Atributos encapsulados (privados)
    private String senha;
    private String status;
    
    // 2. Construtor para inicializar o objeto com todos os dados
    public Aluno(int id, String nome, String email, String telefone,
            LocalDate dataNascimento, String senha, String status) {
        
        // Chama o construtor da superclasse (Pessoa)
        super(id, nome, email, telefone, dataNascimento);
        
        this.senha = senha;
        this.status = status;
    }

    // 3. Métodos Getters e Setters (para acessar e modificar os dados com segurança)

     // Retorna senha
    public String getSenha() {
        return senha;
    }

    // Altera senha
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Retorna status
    public String getStatus() {
        return status;
    }

    // Altera status
    public void setStatus(String status){
        this.status = status;
    }
    
    // ==========================
    // MÉTODO UTILITÁRIO
    // ==========================
    
    /**
     * Exibe informações do aluno.
     * Reaproveita método da superclasse.
     */
    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Status: " + status);
    }
}
