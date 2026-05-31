package menus;

// Importações das classes do próprio projeto
import servicos.ProfessorServico;
import classes.Professor;
// Importações de utilitários nativos do Java para leitura do teclado e manipulação de datas
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuProfessor {
    // Atributos privados para guardar as instâncias de serviço, leitor e formatador de data
    private ProfessorServico professorServico;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    // Construtor da classe que recebe o serviço como dependência obrigatória
    public MenuProfessor(ProfessorServico professorServico) {
        this.professorServico = professorServico;
        this.scanner = new Scanner(System.in); // Inicializa o leitor para capturar dados do console
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato para datas
    }

    // Método principal do menu responsável por gerenciar a navegação do usuário
    public void exibirMenu() {
        int opcao;
        // Laço de repetição do-while que garante a exibição do menu até que o usuário digite 0
        do {
            System.out.println("\n--- GESTÃO DE PROFESSORES ---");
            System.out.println("1. Cadastrar Professor (Create)");
            System.out.println("2. Listar Professores (Read)");
            System.out.println("3. Atualizar Professor (Update)");
            System.out.println("4. Excluir Professor (Delete)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt(); // Lê a opção numérica digitada
            scanner.nextLine(); // Limpa o buffer do teclado para evitar erros nas próximas leituras de texto

            // Estrutura condicional switch-case para direcionar o fluxo de acordo com a escolha
            switch (opcao) {
                case 1:
                    cadastrarProfessor(); // Chama a função para criar um novo registro
                    break;
                case 2:
                    System.out.println("\n=== LISTA DE PROFESSORES ===");
                    // Verifica se a lista retornada pelo serviço está vazia
                    if (professorServico.listarTodos().isEmpty()) {
                        System.out.println("Nenhum professor cadastrado.");
                    } else {
                        // Percorre e imprime cada objeto utilizando o método toString()
                        professorServico.listarTodos().forEach(System.out::println);
                    }
                    break;
                case 3:
                    atualizarProfessor(); // Chama a função para modificar um registro existente
                    break;
                case 4:
                    excluirProfessor(); // Chama a função para remover um registro
                    break;
                case 0:
                    System.out.println("Voltando..."); // Mensagem informativa de saída do menu
                    break;
                default:
                    System.out.println("Opção inválida!"); // Mensagem caso o usuário digite um número fora das opções
            }
        } while (opcao != 0); // Critério de parada do loop
    }

    // CREATE
    private void cadastrarProfessor() {
        try {
            System.out.print("ID do Professor: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Data de Nascimento (dd/mm/yyyy): ");
            // Converte o texto digitado pelo usuário em um objeto LocalDate usando o formatador definido
            LocalDate data = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();

            // Repassa as informações para a camada de serviço efetuar a gravação
            professorServico.cadastrar(id, nome, telefone, email, data, especialidade);
        } catch (Exception e) {
            // Captura qualquer entrada incorreta 
            System.out.println("Erro nos dados digitados. Operação cancelada.");
        }
    }

    // UPDATE
    private void atualizarProfessor() {
        System.out.print("Digite o ID do Professor para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        // Busca o objeto do professor pelo ID na base de dados (memória) antes de pedir alterações
        Professor prof = professorServico.buscarPorId(id);
        if (prof != null) {
            // Exibe as informações atuais entre parênteses para orientar o usuário
            System.out.print("Novo Nome (" + prof.getNome() + "): ");
            String nome = scanner.nextLine();
            System.out.print("Novo Telefone (" + prof.getTelefone() + "): ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email (" + prof.getEmail() + "): ");
            String email = scanner.nextLine();
            System.out.print("Nova Especialidade (" + prof.getEspecialidade() + "): ");
            String esp = scanner.nextLine();

            // Envia os dados novos para a camada de serviço realizar a atualização
            professorServico.atualizarDados(id, nome, telefone, email, esp);
        } else {
            System.out.println("Professor não encontrado."); // Informa caso o ID digitado não exista
        }
    }

    // DELETE
    private void excluirProfessor() {
        System.out.print("Digite o ID do Professor que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        // Solicita ao serviço a remoção do objeto correspondente ao ID informado
        professorServico.excluirProfessor(id);
    }
}

