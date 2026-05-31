package repositorios;

import classes.Professor;
import java.util.ArrayList;

/**
 * Repositorio de professores.
 * responsável por armazenar os professores do sistema na memória.
 */
public class ProfessorRepositorio {
    
    // Lista que vai simular o Banco de Dados
    private ArrayList<Professor> professores;
    
    // Construtor
    public ProfessorRepositorio() {
        professores = new ArrayList<>();
    }
    
    // Adicionar professor
    
    // Salva um novo professor.
    public void adcionar(Professor professor) {
        professores.add(professor); 
    }
    
    // Listar professores
    
    // retorna todos os professores
    public ArrayList<Professor> listar(){
        return professores;
    }
    
    // Busca o ID
    
    // busca o professor pelo id 
    public Professor buscaPorId(int id){
        
        for (Professor professor : professores){
            
            if (professor.getId() == id){
                
                return professor;
            }
        }
        
        return null;
    }
    
    // Remove o professor

    // remove o professor pelo id
    public boolean remover(int id){
        Professor professor = buscaPorId(id);
        
        if (professor != null){
            professores.remove(professor);
            
            return true;
        }
        
        return false;
    }
}
