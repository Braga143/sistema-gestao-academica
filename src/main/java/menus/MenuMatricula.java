/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import classes.Aluno;
import classes.Curso;
import classes.Matricula;

import servicos.AlunoServico;
import servicos.CursoServico;
import servicos.MatriculaServico;

import java.util.Scanner;

public class MenuMatricula {

    // Dependências
    private MatriculaServico matriculaServico;
    private AlunoServico alunoServico;
    private CursoServico cursoServico;

    // Scanner
    private Scanner scanner;

    // ==========================
    // CONSTRUTOR
    // ==========================

    public MenuMatricula(
            MatriculaServico matriculaServico,
            AlunoServico alunoServico,
            CursoServico cursoServico) {

        this.matriculaServico = matriculaServico;
        this.alunoServico = alunoServico;
        this.cursoServico = cursoServico;

        this.scanner = new Scanner(System.in);
    }

    // ==========================
    // MENU PRINCIPAL
    // ==========================

    public void exibirMenu() {

        int opcao;

        do {

            System.out.println("\n--- GESTÃO DE MATRÍCULAS ---");
            System.out.println("1. Realizar Matrícula");
            System.out.println("2. Listar Matrículas");
            System.out.println("3. Buscar Matrícula por ID");
            System.out.println("4. Cancelar Matrícula");
            System.out.println("0. Voltar ao Menu Principal");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    realizarMatricula();
                    break;

                case 2:
                    listarMatriculas();
                    break;

                case 3:
                    buscarMatricula();
                    break;

                case 4:
                    cancelarMatricula();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // ==========================
    // REALIZAR MATRÍCULA
    // ==========================

    private void realizarMatricula() {

        try {

            System.out.print("ID da Matrícula: ");
            int idMatricula =
                    scanner.nextInt();
            scanner.nextLine();

            System.out.print("ID do Aluno: ");
            int idAluno =
                    scanner.nextInt();
            scanner.nextLine();

            // Busca aluno
            Aluno aluno =
                    alunoServico
                    .buscarPorId(
                            idAluno
                    );

            if (aluno == null) {

                System.out.println(
                        "Aluno não encontrado."
                );

                return;
            }

            System.out.print(
                    "ID do Curso: "
            );

            int idCurso =
                    scanner.nextInt();
            scanner.nextLine();

            // Busca curso
            Curso curso =
                    cursoServico
                    .buscarPorId(
                            idCurso
                    );

            if (curso == null) {

                System.out.println(
                        "Curso não encontrado."
                );

                return;
            }

            // Realiza matrícula
            matriculaServico
                    .matricularAluno(
                            idMatricula,
                            aluno,
                            curso
                    );

        } catch (Exception e) {

            System.out.println(
                    "Erro ao realizar matrícula."
            );
        }
    }

    // ==========================
    // LISTAR MATRÍCULAS
    // ==========================

    private void listarMatriculas() {

        System.out.println(
                "\n=== LISTA DE MATRÍCULAS ==="
        );

        if (matriculaServico.listarMatriculas().isEmpty()) {
            System.out.println(
                    "Nenhuma matrícula cadastrada."
            );

        } else {

            for (Matricula matricula
                    : matriculaServico
                    .listarMatriculas()) {

                matricula
                        .exibirInformacoes();

                System.out.println(
                        "----------------------"
                );
            }
        }
    }

    // ==========================
    // BUSCAR MATRÍCULA
    // ==========================

    private void buscarMatricula() {

        System.out.print(
                "Digite ID da matrícula: "
        );

        int id =
                scanner.nextInt();

        scanner.nextLine();

        Matricula matricula =
                matriculaServico
                .buscarPorId(id);

        if (matricula != null) {

            matricula
                    .exibirInformacoes();

        } else {

            System.out.println(
                    "Matrícula não encontrada."
            );
        }
    }

    // ==========================
    // CANCELAR MATRÍCULA
    // ==========================

    private void cancelarMatricula() {

        System.out.print(
                "Digite o ID da matrícula: "
        );

        int id =
                scanner.nextInt();

        scanner.nextLine();

        matriculaServico
                .cancelarMatricula(id);
    }
}
