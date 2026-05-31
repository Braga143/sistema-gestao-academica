package servicos;

import classes.Professor;
import repositorios.ProfessorRepositorio;
import java.time.LocalDate;
import java.util.List;

public class ProfessorServico {
    private ProfessorRepositorio professorRepo;

    // Construtor recebendo o repositório como dependência
    public ProfessorServico(ProfessorRepositorio professorRepo) {
        this.professorRepo = professorRepo;
    }

    // Create 
    public void cadastrar(int id, String nome, String telefone, String email, LocalDate dataNascimento, String especialidade) {
        Professor novoProfessor = new Professor(id, nome, telefone, email, dataNascimento, especialidade);
        
        professorRepo.adcionar(novoProfessor); 
        System.out.println("Professor " + nome + " cadastrado com sucesso!");
    }

    // Read
    public List<Professor> listarTodos() {
        return professorRepo.listar();
    }

    // Read
    public Professor buscarPorId(int id) {
        return professorRepo.buscaPorId(id);
    }

    // Update 
    public void atualizarDados(int id, String novoNome, String novoTelefone, String novoEmail, String novaEspecialidade) {
        // Procura o professor
        Professor prof = professorRepo.buscaPorId(id);
        
        if (prof != null) {
            // Modifica os dados do objeto existente usando os setters com encapsulamento
            prof.setNome(novoNome);
            prof.setTelefone(novoTelefone);
            prof.setEmail(novoEmail);
            prof.setEspecialidade(novaEspecialidade);
            System.out.println("Dados do professor ID " + id + " atualizados com sucesso!");
        } else {
            System.out.println("Professor não encontrado para atualização.");
        }
    }

    // Delete
    public void excluirProfessor(int id) {
        // Executa a remoção e captura se ela foi bem-sucedida ou não
        boolean removido = professorRepo.remover(id);
        
        if (removido) {
            System.out.println("Professor removido com sucesso!");
        } else {
            System.out.println("Erro: Professor não encontrado para exclusão.");
        }
    }
}
