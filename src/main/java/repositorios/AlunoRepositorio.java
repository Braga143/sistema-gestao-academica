package repositorios;

import classes.Aluno;
import java.util.ArrayList;

public class AlunoRepositorio {
    
    // Lista que vai simular o Banco de Dados
    private ArrayList<Aluno> alunos;
    
    // Construtor
    public AlunoRepositorio() {
        alunos = new ArrayList<>();
    }
    
    // Criar
    
    // Salvar
    public void adicionar(Aluno aluno) {
        alunos.add(aluno); 
    }
    
    // Listar
    
    // Retorna todos os alunos
    public ArrayList<Aluno> listar(){
        return alunos;
    }
    
    // Busca o ID
    
    // busca o aluno pelo id 
    public Aluno buscaPorId(int id){
        
        for (Aluno aluno : alunos){
            
            if (aluno.getId() == id){
                
                return aluno;
            }
        }
        
        return null;
    }
    
    // Remover

    // remove o aluno pelo id
    public boolean remover(int id){
        Aluno aluno = buscaPorId(id);
        
        if (aluno != null){
            alunos.remove(aluno);
            
            return true;
        }
        
        return false;
    }
}