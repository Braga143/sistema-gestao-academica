package menus;

import servicos.AlunoServico;
import servicos.ProfessorServico;
import servicos.CursoServico;
import servicos.MatriculaServico;
import servicos.AvaliacaoServico;

import java.util.Scanner;

public class MenuPrincipal {

    // Serviços
    private AlunoServico alunoServico;
    private ProfessorServico professorServico;
    private CursoServico cursoServico;
    private MatriculaServico matriculaServico;
    private AvaliacaoServico avaliacaoServico;

    // Scanner
    private Scanner scanner;

    // ==========================
    // CONSTRUTOR
    // ==========================

    public MenuPrincipal(
            AlunoServico alunoServico,
            ProfessorServico professorServico,
            CursoServico cursoServico,
            MatriculaServico matriculaServico,
            AvaliacaoServico avaliacaoServico) {

        this.alunoServico = alunoServico;
        this.professorServico = professorServico;
        this.cursoServico = cursoServico;
        this.matriculaServico = matriculaServico;
        this.avaliacaoServico = avaliacaoServico;

        this.scanner = new Scanner(System.in);
    }

    // ==========================
    // MENU PRINCIPAL
    // ==========================

    public void exibirMenu() {

        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println("      SISTEMA ACADEMICO");
            System.out.println("=================================");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Professores");
            System.out.println("3. Gerenciar Cursos");
            System.out.println("4. Gerenciar Matriculas");
            System.out.println("5. Gerenciar Avaliacoes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    MenuAluno menuAluno = new MenuAluno(alunoServico);
                    menuAluno.exibirMenu();
                    
                    break;

                case 2:

                    MenuProfessor menuProfessor = new MenuProfessor(professorServico);

                    menuProfessor.exibirMenu();

                    break;

                case 3:
                    
                    MenuCurso menuCurso = new MenuCurso(cursoServico);
                    
                    menuCurso.exibirMenu();

                    break;

                case 4:

                    MenuMatricula menuMatricula = new MenuMatricula(matriculaServico, alunoServico, cursoServico);

                    menuMatricula.exibirMenu();

                    break;

                case 5:

                    MenuAvaliacao menuAvaliacao = new MenuAvaliacao(avaliacaoServico, matriculaServico);

                    menuAvaliacao.exibirMenu();

                    break;

                case 0:

                    System.out.println("Sistema encerrado com sucesso!");

                    break;

                default:

                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);
    }
}
