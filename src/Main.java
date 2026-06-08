import java.util.Scanner;
import Cadastros.Veiculos;

import Cadastros.Estoque;
import Cadastros.Mecanicos;
import Cadastros.OrdemServico;
import Cadastros.Veiculos;

public class Main {
    public static void main(String[] args) throws Exception {
        int opcao = 0;
        Scanner leia = new Scanner(System.in);

<<<<<<< HEAD
        Mecanicos[] mecanicos = new Mecanicos[100];
        Veiculos[] veiculos = new Veiculos[100];
        Estoque[] estoque = new Estoque[100];
        OrdemServico[] os = new OrdemServico[100];

        int qtdMecanicos = 0;
        int qtdVeiculos = 0;
        int qtdEstoque = 0;
        int qtdOS = 0;
=======
        Veiculos[] veiculos = new Veiculos[100];
        
        int totalVeiculos = 0;
>>>>>>> ba7d3ecffc4a5572bfc25ac3abe78d4998ac3822

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

            switch (opcao) {
                case 1:
                    mecanicos[qtdMecanicos] = new Mecanicos();

                    System.out.print("ID: ");
                    mecanicos[qtdMecanicos].id = leia.nextInt();

                    leia.nextLine();

                    System.out.print("Nome: ");
                    mecanicos[qtdMecanicos].nome = leia.nextLine();

                    System.out.print("Especialidade: ");
                    mecanicos[qtdMecanicos].especialidade = leia.nextLine();

                    qtdMecanicos++;

                    System.out.println("Mecânico cadastrado!");

                    break;
                case 2:
                    System.out.println("----> Cadastro de Veículo <----");

                    System.out.println("Digite a placa do veículo:");
                    String placa = leia.next();
                    leia.nextLine();

                    boolean veiculoExiste = false;

                    for (int i = 0; i < totalVeiculos; i++) {

                        if (veiculos[i].placa.equalsIgnoreCase(placa)) {
                            veiculoExiste = true;
                            break;
                        }

                    }

                    if (veiculoExiste) {

                        System.out.println("ERRO: Veículo já cadastrado!");
                        break;

                    }

                    System.out.println("Digite o nome do proprietário:");
                    String nomeDono = leia.nextLine();

                    System.out.println("Digite o modelo do veículo:");
                    String modelo = leia.nextLine();

                    totalVeiculos = cadastrarVeiculo(placa,nomeDono,modelo,totalVeiculos,veiculos);

                    break;
                case 3:

                    estoque[qtdEstoque] = new Estoque();

                    System.out.print("Código: ");
                    estoque[qtdEstoque].codigo = leia.nextInt();

                    leia.nextLine();

                    System.out.print("Descrição: ");
                    estoque[qtdEstoque].descricao = leia.nextLine();

                    System.out.print("Quantidade: ");
                    estoque[qtdEstoque].quantidade = leia.nextInt();

                    System.out.print("Preço: ");
                    estoque[qtdEstoque].preco = leia.nextDouble();

                    qtdEstoque++;

                    System.out.println("Peça cadastrada!");

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

    // FUNÇÕES DOS CADASTROS

    public static int cadastrarVeiculo(
            String placa,
            String nomeDono,
            String modelo,
            int totalVeiculos,
            Veiculos[] veiculos) {

        veiculos[totalVeiculos] = new Veiculos();

        veiculos[totalVeiculos].placa = placa;
        veiculos[totalVeiculos].nomeDono = nomeDono;
        veiculos[totalVeiculos].modelo = modelo;

        System.out.println("Cadastro efetuado com sucesso!");

        totalVeiculos++;

        return totalVeiculos;
    }
}
