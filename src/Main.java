import java.util.Scanner;
import Cadastros.Veiculos;

import Cadastros.Estoque;
import Cadastros.Mecanicos;
import Cadastros.OrdemServico;
import Cadastros.Veiculos;
import Relatorios.Relatorios;

public class Main {
    public static void main(String[] args) throws Exception {
        int opcao = 0;
        Scanner leia = new Scanner(System.in);

        Mecanicos[] mecanicos = new Mecanicos[100];
        Veiculos[] veiculos = new Veiculos[100];
        Estoque[] estoque = new Estoque[100];
        OrdemServico[] os = new OrdemServico[100];

        int qtdMecanicos = 0;
        int qtdVeiculos = 0;
        int qtdEstoque = 0;
        int qtdOS = 0;

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
                    System.out.print("ID: ");
                    int idMecanico = leia.nextInt();

                    leia.nextLine();

                    System.out.print("Nome: ");
                    String nomeMecanico = leia.nextLine();

                    System.out.print("Especialidade: ");
                    String especialidadeMecanico = leia.nextLine();

                    qtdMecanicos = cadastrarMecanico(idMecanico, nomeMecanico, especialidadeMecanico, qtdMecanicos,
                            mecanicos);
                    break;
                case 2:
                    System.out.println("----> Cadastro de Veículo <----");

                    System.out.println("Digite a placa do veículo:");
                    String placa = leia.next();
                    leia.nextLine();

                    boolean veiculoExiste = false;

                    for (int i = 0; i < qtdVeiculos; i++) {

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

                    qtdVeiculos = cadastrarVeiculo(placa, nomeDono, modelo, qtdVeiculos, veiculos);

                    break;
                case 3:
                    System.out.println("----> Cadastro de Peças no Estoque <----");

                    System.out.print("Código: ");
                    int codigoEstoque = leia.nextInt();

                    leia.nextLine();

                    System.out.print("Descrição: ");
                    String descricaoEstoque = leia.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidadeEstoque = leia.nextInt();

                    System.out.print("Preço: ");
                    double precoEstoque = leia.nextDouble();

                    cadastrarEstoque(codigoEstoque, descricaoEstoque, quantidadeEstoque, precoEstoque, qtdEstoque,
                            estoque);

                    break;
                case 4:
                    System.out.println("----> Abertura de Ordem de Serviço <----");

                    System.out.println("Digite o código da O.S:");
                    int idOS = leia.nextInt();

                    System.out.println("Digite a placa do carro:");
                    String placaCarroOS = leia.nextLine();

                    System.out.println("Digite o código do mecânico responsável pela O.S:");
                    int idMecanicoOS = leia.nextInt();

                    System.out.println("Digite o código da peça utilizada na manutenção:");
                    int idEstoqueOS = leia.nextInt();

                    System.out.println("Digite a quantidade de peças utilizadas na manutenção:");
                    int quantidadePecaOS = leia.nextInt();

                    System.out.println("Digite o o valor da mão de obra da O.S:");
                    double valorServico = leia.nextDouble();

                    qtdOS = cadastrarOS(idOS, placaCarroOS, idMecanicoOS, idEstoqueOS, quantidadePecaOS, valorMaoObra,
                            qtdOS, os);
                    break;
                case 5:
                    System.out.println("---- ESTOQUE ----");
                    if (qtdEstoque == 0) {
                        System.out.println("Nenhuma peça cadastrada.");
                        return;
                    } else {

                        for (int i = 0; i < qtdEstoque; i++) {
                            System.out.println("Peça " + (i + 1));

                            System.out.println("Código: ");
                            estoque[i].codigo = leia.nextInt();

                            System.out.println("Descrição: ");
                            estoque[i].descricao = leia.nextLine();

                            System.out.println("Quantidade: " + estoque[i].quantidade);
                            estoque[i].quantidade = leia.nextInt();

                            System.out.println("Preço: R$ " + estoque[i].preco);
                            estoque[i].preco = leia.nextDouble();

                            System.out.println("-----------------------");

                            return;
                        }
                    }
                    break;
                case 6:
                     calcularComissaoEquipe(
            mecanicos,
            qtdMecanicos,
            os,
            qtdOS);

    break;
                case 7:
                        Relatorios.inventarioCritico(estoque, qtdEstoque);
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
            int qtdVeiculos,
            Veiculos[] veiculos) {

        veiculos[qtdVeiculos] = new Veiculos();

        veiculos[qtdVeiculos].placa = placa;
        veiculos[qtdVeiculos].nomeDono = nomeDono;
        veiculos[qtdVeiculos].modelo = modelo;

        qtdVeiculos++;
        System.out.println("Cadastro de veículo efetuado com sucesso!");

        return qtdVeiculos;
    }

    public static int cadastrarMecanico(
            int id,
            String nome,
            String especialidade,
            int qtdMecanicos,
            Mecanicos[] mecanicos) {

        mecanicos[qtdMecanicos] = new Mecanicos();

        mecanicos[qtdMecanicos].id = id;
        mecanicos[qtdMecanicos].nome = nome;
        mecanicos[qtdMecanicos].especialidade = especialidade;

        qtdMecanicos++;
        System.out.println("Cadastro do mecânico efetuado com sucesso!");

        return qtdMecanicos;
    }

    public static int cadastrarEstoque(int codigo,
            String descricao,
            int quantidade,
            double preco,
            int qtdPecas,
            Estoque[] estoque) {
        estoque[qtdPecas] = new Estoque();

        estoque[qtdPecas].codigo = codigo;
        estoque[qtdPecas].descricao = descricao;
        estoque[qtdPecas].quantidade = quantidade;
        estoque[qtdPecas].preco = preco;

        qtdPecas++;
        System.out.println("Cadastro da peça efetuado com sucesso!");

        return qtdPecas;
    }

    public static int cadastrarOS(int idOS, String placaCarro, int idMecanico, int idPeca, int quantidadePeca,
            double valorServico, int qtdOS, OrdemServico[] os) {

        os = new OrdemServico[qtdOS];
        os[qtdOS].id = idOS;
        os[qtdOS].placaCarro = placaCarro;
        os[qtdOS].idMecanico = idMecanico;
        os[qtdOS].idPeca = idPeca;
        os[qtdOS].quantidadePeca = quantidadePeca;
        os[qtdOS].valorServico = valorServico;

        qtdOS++;
        System.out.println("Cadastro da OS realizado com sucesso!");
        return qtdOS;
    }

    public static void calcularComissaoEquipe(
        Mecanicos[] mecanicos,
        int qtdMecanicos,
        OrdemServico[] os,
        int qtdOS) {

    final double TAXA_COMISSAO = 0.10;

    System.out.println("\n===== COMISSÃO DA EQUIPE =====");

    for (int i = 0; i < qtdMecanicos; i++) {

        double totalVendas = 0;

        for (int j = 0; j < qtdOS; j++) {

            if (os[j].idMecanico == mecanicos[i].id) {
                totalVendas += os[j].valorServico;
            }

        }

        double comissao = totalVendas * TAXA_COMISSAO;

        System.out.println("Mecânico: " + mecanicos[i].nome);
        System.out.println("Especialidade: " + mecanicos[i].especialidade);
        System.out.println("Total em serviços: R$ " + totalVendas);
        System.out.println("Comissão: R$ " + comissao);
        System.out.println("--------------------------------");
    }
}
}
