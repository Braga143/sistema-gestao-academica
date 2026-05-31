// Define que esta classe pertence ao pacote 'classes' na estrutura do projeto
package classes; 
import java.time.LocalDate;

/**
 * A palavra-chave 'extends' aplica o conceito de HERANÇA em POO.
 * Significa que a classe Professor é uma subclasse (filha) que herda todos 
 * os atributos e métodos públicos/protegidos da classe mãe Pessoa.
 */
public class Professor extends Pessoa { 

        // ATRIBUTOS
    // O modificador 'private' aplica o encapsulamento, garantindo que estes atributos só possam ser acessados diretamente de dentro desta classe.
    private String especialidade; 

    /**
     * Construtor completo com argumentos usado para criar o objeto já preenchendo todos os dados de uma vez só.
     */
    public Professor(int id, String nome, String email, String telefone, LocalDate dataNascimento, String especialidade) {
        
        // Inicializa a infraestrutura da classe base (Pessoa)
        super(id, nome, email, telefone, dataNascimento); 
        this.especialidade = especialidade;
    }

    // MÉTODOS GETTERS E SETTERS (Acesso e Modificação)
        
    // Getter: Retorna o texto guardado na especialidade
    public String getEspecialidade() {
        return especialidade;
    }

    // Setter: Altera o texto da especialidade
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // POLIMORFISMO DE SOBREPOSIÇÃO

    /**
     * A anotação @Override avisa ao compilador que estamos redefinindo (sobrescrevendo).
     * o método toString() que originalmente pertence à classe Object do Java.
     * * @return Uma representação textual customizada com os dados do objeto Professor.
     */
    @Override
    public String toString() {
        // Os métodos getNome() e getEmail() buscam as informações que estão guardadas lá na classe Pessoa
        return "Professor{" +
                "id=" + getId () +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
