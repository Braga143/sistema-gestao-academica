/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import classes.Avaliacao;
import classes.Matricula;

import servicos.AvaliacaoServico;
import servicos.MatriculaServico;

import java.util.Scanner;

public class MenuAvaliacao {

    // Dependências
    private AvaliacaoServico avaliacaoServico;
    private MatriculaServico matriculaServico;

    // Scanner
    private Scanner scanner;

    // ==========================
    // CONSTRUTOR
    // ==========================

    public MenuAvaliacao(
            AvaliacaoServico avaliacaoServico,
            MatriculaServico matriculaServico) {

        this.avaliacaoServico =
                avaliacaoServico;

        this.matriculaServico =
                matriculaServico;

        this.scanner =
                new Scanner(System.in);
    }

    // ==========================
    // MENU PRINCIPAL
    // ==========================

    public void exibirMenu() {

        int opcao;

        do {

            System.out.println("\n--- GESTAO DE AVALIACOES ---");

            System.out.println("1. Realizar Avaliacao");

            System.out.println("2. Listar Avaliacoes");

            System.out.println("3. Buscar Avaliacao por ID");

            System.out.println("4. Remover Avaliacao");

            System.out.println("0. Voltar ao Menu Principal");

            System.out.print("Escolha uma opcao: ");

            opcao =
                    scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1:
                    realizarAvaliacao();
                    break;

                case 2:
                    listarAvaliacoes();
                    break;

                case 3:
                    buscarAvaliacao();
                    break;

                case 4:
                    removerAvaliacao();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);
    }

    // ==========================
    // REALIZAR AVALIAÇÃO
    // ==========================

    private void realizarAvaliacao() {

        try {System.out.print("ID da Avaliacao: ");

            int idAvaliacao =scanner.nextInt();
            scanner.nextLine();

            System.out.print("ID da Matrícula: ");

            int idMatricula =
                    scanner.nextInt();

            scanner.nextLine();

            // Busca matrícula
            Matricula matricula = matriculaServico.buscarPorId(idMatricula);

            if (matricula == null) {

                System.out.println("Matrícula nao encontrada.");

                return;
            }

            System.out.print("Nota do aluno: ");

            double nota = scanner.nextDouble();

            scanner.nextLine();

            System.out.print("Comentario: ");

            String comentario = scanner.nextLine();

            // Cria avaliação
            avaliacaoServico.avaliarAluno(idAvaliacao, matricula, nota, comentario);

        } catch (Exception e) {

            System.out.println("Erro ao realizar avaliacao.");
        }
    }

    // ==========================
    // LISTAR AVALIAÇÕES
    // ==========================

    private void listarAvaliacoes() {

        System.out.println("\n=== LISTA DE AVALIACOES ===");

        if (avaliacaoServico.listarAvaliacaos().isEmpty()) {

            System.out.println("Nenhuma avaliacao cadastrada.");

        } else {

            for (Avaliacao avaliacao : avaliacaoServico.listarAvaliacaos()) {

                avaliacao.exibirInformacoes();

                System.out.println("----------------------");
            }
        }
    }

    // ==========================
    // BUSCAR AVALIAÇÃO
    // ==========================

    private void buscarAvaliacao() {

        System.out.print("Digite o ID da avaliacao: ");

        int id = scanner.nextInt(); scanner.nextLine();

        Avaliacao avaliacao = avaliacaoServico.buscaPorId(id);

        if (avaliacao != null) {

            avaliacao.exibirInformacoes();

        } else {

            System.out.println("Avaliacao nao encontrada.");
        }
    }

    // ==========================
    // REMOVER AVALIAÇÃO
    // ==========================

    private void removerAvaliacao() {

        System.out.print("Digite o ID da avaliacao: ");

        int id = scanner.nextInt();

        scanner.nextLine();

        avaliacaoServico.removerAvaliacao(id);
    }
}
