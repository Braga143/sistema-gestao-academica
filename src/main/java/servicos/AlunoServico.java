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

            AlunoRepo.salvar(novoAluno);
            System.out.println("Aluno " + nome + "cadastrado com sucesso");
    }
}

