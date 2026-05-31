package app;

import menus.MenuPrincipal;

import repositorios.AlunoRepositorio;
import repositorios.ProfessorRepositorio;
import repositorios.CursoRepositorio;
import repositorios.MatriculaRepositorio;
import repositorios.AvaliacaoRepositorio;

import servicos.AlunoServico;
import servicos.ProfessorServico;
import servicos.CursoServico;
import servicos.MatriculaServico;
import servicos.AvaliacaoServico;

public class SistemaGestaoAcademica {

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("     SISTEMA DE GESTÃO ACADÊMICA");
        System.out.println("=============================================");

        // ==========================
        // REPOSITÓRIOS
        // ==========================

        AlunoRepositorio alunoRepo = new AlunoRepositorio();

        ProfessorRepositorio professorRepo = new ProfessorRepositorio();

        CursoRepositorio.CursoRepo cursoRepo = new CursoRepositorio.CursoRepoImpl();

        MatriculaRepositorio matriculaRepo = new MatriculaRepositorio();

        AvaliacaoRepositorio avaliacaoRepo = new AvaliacaoRepositorio();

        // ==========================
        // SERVIÇOS
        // ==========================

        AlunoServico alunoServico = new AlunoServico(alunoRepo);

        ProfessorServico professorServico = new ProfessorServico(professorRepo);

        CursoServico cursoServico = new CursoServico(cursoRepo, professorRepo);

        MatriculaServico matriculaServico = new MatriculaServico(matriculaRepo);

        AvaliacaoServico avaliacaoServico = new AvaliacaoServico(avaliacaoRepo);

        // ==========================
        // DADOS DE TESTE
        // ==========================

        try {

            java.time.LocalDate dataProfessor =
                    java.time.LocalDate.of(
                            1954,
                            6,
                            7
                    );

            professorServico.cadastrar(
                    1,
                    "Dr. Alan Turing",
                    "6199999999",
                    "turing@email.com",
                    dataProfessor,
                    "Computacao"
            );

            System.out.println("Carga inicial realizada com sucesso!\n");

        } catch (Exception e) {

            System.out.println("Erro na carga inicial.");
        }

        // ==========================
        // MENU PRINCIPAL
        // ==========================

        MenuPrincipal menuPrincipal = new MenuPrincipal(alunoServico, professorServico, cursoServico, matriculaServico, avaliacaoServico);

        menuPrincipal.exibirMenu();

        // ==========================
        // ENCERRAMENTO
        // ==========================

        System.out.println("\n=============================================");

        System.out.println(" SISTEMA ENCERRADO COM SUCESSO!");

        System.out.println("=============================================");
    }
}
