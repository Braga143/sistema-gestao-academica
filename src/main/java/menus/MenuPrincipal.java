/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import classes.Aluno;
import classes.Professor;
import servicos.AlunoServico;
import servicos.ProfessorServico;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class MenuPrincipal {
    private final AlunoServico alunoServico;
    private final ProfessorServico professorServico;
    private final Scanner scanner;
    private final DateTimeFormatter formatadorData;
    
    public MenuPrincipal(AlunoServico alunoServico, ProfessorServico professorServico) {
        this.alunoServico = alunoServico;
        this.professorServico = professorServico;
        
        // Aqui dentro você cria as instâncias internas normalmente:
        this.scanner = new Scanner(System.in);
        this.formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    public void exibirMenu(){
    int opcao = 0;
    
    while (opcao !=3){
        System.out.println("\n=================================");
        System.out.println("    SISTEMA ACADÊMICO - MENU     ");
        System.out.println("=================================");
        System.out.println("1. Gerenciar Alunos");
        System.out.println("2. Gerenciar Professores");
        System.out.println("3. Sair do Sistema");
        System.out.print("Escolha uma opção: ");
    }
    }
}
