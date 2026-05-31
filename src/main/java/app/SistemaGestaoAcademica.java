package app;

import repositorios.ProfessorRepositorio;
import servicos.ProfessorServico;
import menus.MenuProfessor;

public class SistemaGestaoAcademica {

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("     INICIALIZANDO TESTE DO CRUD PROFESSOR    ");
        System.out.println("=============================================");

        // Instancia o repositório (Banco de dados em memória)
        ProfessorRepositorio professorRepo = new ProfessorRepositorio();

        // Instancia o serviço, injetando o repositório como dependência
        ProfessorServico professorServico = new ProfessorServico(professorRepo);

        // Instancia o menu, injetando o serviço como dependência
        MenuProfessor menuProfessor = new MenuProfessor(professorServico);

        try {
            java.time.LocalDate dataPredefinida = java.time.LocalDate.of(1954, 6, 7);
            professorServico.cadastrar(1, "Dr. Alan Turing", "6199999999", "turing@email.com", dataPredefinida, "Computacao");
            System.out.println("Carga inicial de testes realizada com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Pulando carga inicial (verifique os parâmetros do construtor se der erro).");
        }

        // Executa o menu do professor (O loop do-while vai rodar aqui)
        menuProfessor.exibirMenu();

        // Mensagem executada apenas quando o usuário digitar '0' no menu
        System.out.println("\n=============================================");
        System.out.println("       TESTE FINALIZADO COM SUCESSO!        ");
        System.out.println("=============================================");
    }
}
