import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int opcao = 0;
        Scanner leia = new Scanner(System.in);

        System.out.println("\\\\\\\\\\Seja bem vindo ao sistema de gestão da/////");
        System.out.println("\\\\\\\\\\AUTO CENTER ROTA 381/////");
        do {
            System.out.println("Selecione a opção do menu desejada:");
            System.out.println("1 - Cadastrar mecânico");
            System.out.println("2 - Cadastrar cliente");
            System.out.println("3 - Cadastrar nova peça");
            System.out.println("4 - Cadastrar Ordem de Serviço");
            System.out.println("5 - Listar Estoque");
            System.out.println("6 - Comissão da Equipe");
            System.out.println("7 - Inventário Crítico");
            System.out.println("8 - Faturamento de Peças");
            System.out.println("0 - Sair");
            System.out.print("Opção desejada: ");
            
            opcao = leia.nextInt();

            switch(opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar nosso sistema!");
                    System.out.println("Salvando dados...");
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida, por favor escolha uma das opções abaixo:");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);

    }
}
