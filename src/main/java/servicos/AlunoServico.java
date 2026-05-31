/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import classes.Aluno;
import repositorios.AlunoRepositorio;
import java.util.List;
import java.time.LocalDate;

public class AlunoServico {
    private AlunoRepositorio AlunoRepo;
    
    public AlunoServico (AlunoRepositorio AlunoRepo){
        this.AlunoRepo = AlunoRepo;
    }

    //Criar
    public void Cadastrar (int id, String nome, String email, String telefone,
            LocalDate dataNascimento, String senha, String status) {
            Aluno novoAluno = new Aluno (id, nome, email, telefone, dataNascimento, senha, status);

            AlunoRepo.adicionar(novoAluno);
            System.out.println("Aluno " + nome + "cadastrado com sucesso");
    }
    
    //Ler
    public List<Aluno> listartodos(){
    return AlunoRepo.listar ();
    }
    
    //Buscar
    public Aluno buscaPorID(int id){
        return AlunoRepo.buscaPorId(id);
    }
   
    //Atualizar
    public void AtualizarDados(int id, String novoNome, String novoEmail, String novoTelefone,
             String novaSenha, String novoStatus){
    Aluno aluno = AlunoRepo.buscaPorId(id);
    
    if (aluno != null){
        aluno.setNome(novoNome);
        aluno.setEmail(novoEmail);
        aluno.setTelefone(novoTelefone);
        aluno.setSenha(novaSenha);
        aluno.setStatus(novoStatus);
        System.out.println("Dados do aluno ID " + id + "atualizados com sucesso!");
        } else {
    
        System.out.println("Aluno não encontrado para atualização");
        }
    }
    
    //Excluir
    public void excluirAluno(int id){
    boolean removido = AlunoRepo.remover(id);
    
    if (removido) {
    System.out.println("Aluno removido com sucesso!");
        } else {
    System.out.println("Erro: Aluno não encontrado para exclusão!");
        }
    }

    /**
    * Busca aluno pelo ID.
    */
    public Aluno buscarPorId(int idAluno) {

    return AlunoRepo.buscaPorId(idAluno);
    }
}

