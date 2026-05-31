/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import classes.Curso;

import servicos.CursoServico;

import java.util.Scanner;

public class MenuCurso {

    // Dependência
    private CursoServico cursoServico;

    // Scanner
    private Scanner scanner;

    // ==========================
    // CONSTRUTOR
    // ==========================

    public MenuCurso(CursoServico cursoServico) {

        this.cursoServico = cursoServico;

        this.scanner = new Scanner(System.in);
    }

    // ==========================
    // MENU PRINCIPAL
    // ==========================

    public void exibirMenu() {

        int opcao;

        do {

            System.out.println("\n--- GESTÃO DE CURSOS ---");

            System.out.println("1. Cadastrar Curso");

            System.out.println("2. Listar Cursos");

            System.out.println("3. Buscar Curso por ID");

            System.out.println("4. Atualizar Curso");

            System.out.println("5. Excluir Curso");

            System.out.println("0. Voltar ao Menu Principal");

            System.out.print("Escolha uma opção: ");

            opcao =
                    scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarCurso();
                    break;

                case 2:
                    listarCursos();
                    break;

                case 3:
                    buscarCurso();
                    break;

                case 4:
                    atualizarCurso();
                    break;

                case 5:
                    removerCurso();
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
    // CADASTRAR CURSO
    // ==========================

    private void cadastrarCurso() {

        try {

            System.out.print("ID do Curso: ");

            int idCurso = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Título do Curso: ");

            String tituloCurso = scanner.nextLine();

            System.out.print("Descrição: ");

            String descricao = scanner.nextLine();

            System.out.print("Carga Horária: ");

            String cargaHoraria = scanner.nextLine();

            System.out.print("Turno: ");

            String turno =scanner.nextLine();

            System.out.print("Dias da Semana: ");

            String diasSemana = scanner.nextLine();

            System.out.print("Quantidade Máxima de Alunos: ");

            int quantidadeMaximaAlunos =
                    scanner.nextInt();

            scanner.nextLine();

            System.out.print("ID do Professor: ");

            int idProfessor = scanner.nextInt();

            scanner.nextLine();

            cursoServico.cadastrarCurso(idCurso, tituloCurso, descricao, cargaHoraria, turno, diasSemana, quantidadeMaximaAlunos, idProfessor);

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar curso.");
        }
    }

    // ==========================
    // LISTAR CURSOS
    // ==========================

    private void listarCursos() {

        System.out.println("\n=== LISTA DE CURSOS ===");

        if (cursoServico.listarCursos().isEmpty()) {

            System.out.println("Nenhum curso cadastrado.");

        } else {

            for (Curso curso : cursoServico.listarCursos()) {

                System.out.println("\nID: " + curso.getIdCurso());

                System.out.println("Título: "+ curso.getTituloCurso());

                System.out.println("Professor: " + curso.getProfessor().getNome());

                System.out.println("Vagas: " + curso.getQuantidadeMatriculados() + "/" + curso.getQuantidadeMaximaAlunos());

                System.out.println("---------------------");
            }
        }
    }

    // ==========================
    // BUSCAR CURSO
    // ==========================

    private void buscarCurso() {

        System.out.print("Digite o ID do curso: ");

        int id =
                scanner.nextInt();

        scanner.nextLine();

        Curso curso = cursoServico.buscarPorId(id);

        if (curso != null) {

            System.out.println("\nCurso encontrado:");

            System.out.println("Título: " + curso.getTituloCurso());

            System.out.println("Professor: " + curso.getProfessor().getNome()
            );

        } else {

            System.out.println("Curso não encontrado.");
        }
    }

    // ==========================
    // ATUALIZAR CURSO
    // ==========================

    private void atualizarCurso() {

        System.out.println("Função em desenvolvimento.");
    }

    // ==========================
    // REMOVER CURSO
    // ==========================

    private void removerCurso() {

        System.out.print("Digite o ID do curso: ");

        int id =
                scanner.nextInt();

        scanner.nextLine();

        boolean removido = cursoServico.removerCurso(id);

        if (removido) {

            System.out.println("Curso removido com sucesso!");

        } else {

            System.out.println("Curso não encontrado.");
        }
    }
}
