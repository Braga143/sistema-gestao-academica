package menus;

import classes.Aluno;
import servicos.AlunoServico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuAluno {
       private AlunoServico alunoServico;
       private Scanner scanner;
       private DateTimeFormatter formatter;
       
       
       public MenuAluno(AlunoServico alunoServico) {
           this.alunoServico = alunoServico;
           this.scanner = new Scanner(System.in);
           this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           
       }
    public void exibirMenu (){
    int opcao = 0;
     do {
         System.out.println("\n--- GESTÃO DE ALUNOS ---");
            System.out.println("1. Cadastrar Aluno (Create)");
            System.out.println("2. Listar Alunos (Read)");
            System.out.println("3. Atualizar Aluno (Update)");
            System.out.println("4. Excluir Aluno (Delete)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
             switch (opcao) {
                case 1:
                    CadastrarAluno(); // Chama a função para criar um novo registro
                    break;
                case 2:
                    System.out.println("\n=== LISTA DE ALUNOS ===");
                    // Verifica se a lista retornada pelo serviço está vazia
                    if (alunoServico.listartodos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        // Percorre e imprime cada objeto utilizando o método toString()
                        alunoServico.listartodos().forEach(System.out::println);
                    }
                    break;
                case 3:
                    AtualizarAluno(); // Chama a função para modificar um registro existente
                    break;
                case 4:
                    excluirAluno(); // Chama a função para remover um registro
                    break;
                case 0:
                    System.out.println("Voltando..."); // Mensagem informativa de saída do menu
                    break;
                default:
                    System.out.println("Opção inválida!"); // Mensagem caso o usuário digite um número fora das opções
            }
        } while (opcao != 0); // Critério de parada do loop
    }
    
    private void CadastrarAluno(){
        try {
            System.out.print("ID do Aluno: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("senha: ");
            String senha = scanner.nextLine();
            System.out.print("Data de Nascimento (dd/MM/yyyy): ");

            LocalDate data = LocalDate.parse(scanner.nextLine(), formatter);
            
            System.out.print("Matricula: ");
            String matricula = scanner.nextLine();
            
            alunoServico.Cadastrar(id, nome, email, telefone, data, senha, "ATIVO");
            
            }
        catch (Exception e){
        System.out.print("Erro nos dados digitados. Operação cancelada.");
        }
    }
    
    //update
    private void AtualizarAluno(){
    System.out.print("Digite o ID do aluno para atualizar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    
    Aluno aluno = alunoServico.buscaPorID(id);
    
    if (aluno != null){
         System.out.print("Novo Nome (" + aluno.getNome() + "): ");
            String nome = scanner.nextLine();
            System.out.print("Novo Telefone (" + aluno.getTelefone() + "): ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email (" + aluno.getEmail() + "): ");
            String email = scanner.nextLine();
            System.out.print("Nova senha: ");
            String senha = scanner.nextLine();
          alunoServico.AtualizarDados(id, nome, email, telefone, senha, aluno.getStatus());
    } else {
            System.out.println("Aluno não encontrado.");
        }
    } 
 
    //Delete
private void excluirAluno() {
        System.out.print("Digite o ID do Aluno que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        // Solicita ao serviço a remoção do objeto correspondente ao ID informado
        alunoServico.excluirAluno(id);
    }
}
