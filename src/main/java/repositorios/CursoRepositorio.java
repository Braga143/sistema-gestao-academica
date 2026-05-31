package repositorios;

import classes.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório de Cursos.
 * Responsável por armazenar e gerenciar os cursos do sistema na memória.
 */
public class CursoRepositorio {

    // Interface 
    public interface CursoRepo {
        void salvar(Curso curso);            // Create
        Curso buscaPorId(int id);            // Read (Individual
        List<Curso> listarTodos();           // Read (Geral)
        void atualizar(Curso curso);         // Update
        boolean remover(int id);             // Delete
    }

    // Implementação
    public static class CursoRepoImpl implements CursoRepo {
        
        // Lista que simula o Banco de Dados em memória
        private final List<Curso> bancoDeDadosCursos = new ArrayList<>();

        // Criar 
        @Override
        public void salvar(Curso curso) {
            if (curso != null) {
                bancoDeDadosCursos.add(curso);
                System.out.println("Sucesso: Curso \"" + curso.getTituloCurso() + "\" cadastrado com sucesso!");
            } else {
                System.out.println("ERRO: Não é possível adicionar um curso inválido (nulo)!");
            }
        }

        // Ler por ID 
        @Override
        public Curso buscaPorId(int id) {
            for (Curso curso : bancoDeDadosCursos) {
                if (curso.getIdCurso() == id) { 
                    return curso;
                }
            }
            System.out.println("ERRO: Curso com ID " + id + " não foi encontrado!");
            return null;
        }

        // Listar Todos
        @Override
        public List<Curso> listarTodos() {
            return new ArrayList<>(bancoDeDadosCursos);
        }

        // Atualizar
        @Override
        public void atualizar(Curso cursoAtualizado) {
            if (cursoAtualizado == null) return;

            Curso cursoExistente = buscaPorId(cursoAtualizado.getIdCurso());
            
            if (cursoExistente != null) {
                cursoExistente.setTituloCurso(cursoAtualizado.getTituloCurso());
                cursoExistente.setDescricao(cursoAtualizado.getDescricao());
                cursoExistente.setCargaHoraria(cursoAtualizado.getCargaHoraria());
                cursoExistente.setTurno(cursoAtualizado.getTurno());
                cursoExistente.setDiasSemana(cursoAtualizado.getDiasSemana());
                cursoExistente.setQuantidadeMaximaAlunos(cursoAtualizado.getQuantidadeMaximaAlunos());
                cursoExistente.setProfessor(cursoAtualizado.getProfessor());
                cursoExistente.setStatus(cursoAtualizado.getStatus());
                cursoExistente.setQuantidadeMatriculados(cursoAtualizado.getQuantidadeMatriculados());
                
                System.out.println("Sucesso: Dados do curso ID " + cursoAtualizado.getIdCurso() + " atualizados!");
            } else {
                System.out.println("ERRO: Não foi possível atualizar. Curso ID " + cursoAtualizado.getIdCurso() + " não existe.");
            }
        }

        // Deletar
        @Override
        public boolean remover(int id) {
            Curso curso = buscaPorId(id);
            
            if (curso != null) {
                bancoDeDadosCursos.remove(curso);
                System.out.println("Sucesso: Curso ID " + id + " removido do sistema.");
                return true;
            }
            
            System.out.println("ERRO: Não foi possível deletar. Curso ID " + id + " não existe.");
            return false;
        }
    }
}
