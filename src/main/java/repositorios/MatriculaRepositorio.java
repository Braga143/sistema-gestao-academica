package repositorios;

import classes.Matricula;
import java.util.ArrayList;

/**
 * Repositorio de matriculas.
 * responssavel por armazenar as matriculas
 * do sistema na memoria.
 * 
 * @author Windows
 */
public class MatriculaRepositorio {
   
    //Lista que vai simular o Bd
    private ArrayList<Matricula> matriculas;
    
    //===============
    //Construtor
    //===============
    public MatriculaRepositorio() {
        matriculas = new ArrayList<>();
    }
    
    //====================
    // Adicionar matricula
    //=====================
    
    
    //Salva uma nova matricula.
    
    public void adcionar(Matricula matricula) {
        matriculas.add(matricula); 
    }
    
    //==================
    //Listar matriculas
    //==================
    
    //retorna todas as matriculas
    public ArrayList<Matricula> listar(){
        return matriculas;
    }
    
    //==============
    //Busca o ID
    //==============
    
    //busca a matricula pelo id 
    public Matricula buscaPorId(int idMatricula){
        
        for (Matricula matricula : matriculas){
            
            if (matricula.getIdMatricula() == idMatricula){
                
                return matricula;
            }
        }
        
        return null;
    }
    
    //==================
    //Remove a matricula
    //==================
    
    //remove a matricula pelo id
    public boolean remover(int idMatricula){
        Matricula matricula =
                buscaPorId(idMatricula);
        
        if (matricula != null){
            matriculas.remove(matricula);
            
            return true;
        }
        
        return false;
    }
}
