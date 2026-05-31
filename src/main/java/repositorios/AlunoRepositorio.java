package repositorios;

import classes.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositorio {

    // 1. Interface (Contrato)
    public interface AlunoRepo {
        void salvar(Aluno aluno);           // Create
        Aluno buscarPorId(int id);          // Read (Individual)
        List<Aluno> listarTodos();          // Read (Geral)
        void atualizar(Aluno aluno);        // Update
        void deletar(int id);               // Delete
    }

    // 2. Implementação (Faltava o 'implements AlunoRepo')
    public static class AlunoRepoImpl implements AlunoRepo {
        
        private final List<Aluno> bancoDeDadosAlunos = new ArrayList<>();   

        // Criar
        @Override
        public void salvar(Aluno aluno) {
            if (aluno != null) {
                // Adiciona o aluno à lista (isso estava faltando!)
                bancoDeDadosAlunos.add(aluno); 
                System.out.println("Sucesso: Aluno " + aluno.getNome() + " cadastrado com sucesso!");
            } else {
                System.out.println("ERRO: Por favor, insira um aluno válido!");
            }
        }

        // Ler por ID
        
        @Override
        public Aluno buscarPorId(int id) {
            for (Aluno aluno : bancoDeDadosAlunos) {
                if (aluno.getId() == id) { 
                    return aluno;
                }
            }
            System.out.println("ERRO: ID " + id + " não encontrado!");
            return null;
        }

        // Listar Todos

        @Override
        public List<Aluno> listarTodos() {
            return new ArrayList<>(bancoDeDadosAlunos);   
        }

        // Atualizar

        @Override
        public void atualizar(Aluno alunoAtualizado) {
            if (alunoAtualizado == null) return;

            Aluno alunoExistente = buscarPorId(alunoAtualizado.getId());
            
            if (alunoExistente != null) {
                alunoExistente.setNome(alunoAtualizado.getNome());
                alunoExistente.setEmail(alunoAtualizado.getEmail());
                alunoExistente.setTelefone(alunoAtualizado.getTelefone());
                alunoExistente.setDataNascimento(alunoAtualizado.getDataNascimento());
                alunoExistente.setSenha(alunoAtualizado.getSenha());
                alunoExistente.setStatus(alunoAtualizado.getStatus());
                
                System.out.println("Sucesso: Dados do aluno ID " + alunoAtualizado.getId() + " atualizados!");
            } else {
                System.out.println("Erro: Não foi possível atualizar. Aluno ID " + alunoAtualizado.getId() + " não existe.");
            }
        }

        // Deletar

        @Override
        public void deletar(int id) {
            // Correção: de buscarPorID para buscarPorId
            Aluno aluno = buscarPorId(id); 
            if (aluno != null) {
                // Correção de digitação: bancoDeDadosAlunos
                bancoDeDadosAlunos.remove(aluno); 
                System.out.println("Sucesso: Aluno ID " + id + " removido do sistema.");
            } else {
                System.out.println("ERRO: Não foi possível deletar. Aluno ID " + id + " não encontrado.");
            }
        }
    }
}