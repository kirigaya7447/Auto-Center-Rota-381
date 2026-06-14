package Relatorios;
import Cadastros.Estoque;
import Cadastros.OrdemServico;

public class Relatorios {

    public static void inventarioCritico(Estoque[] estoque, int qtdEstoque) {

        System.out.println("===== INVENTÁRIO CRÍTICO =====");

        boolean encontrou = false;

        for (int i = 0; i < qtdEstoque; i++) {

            if (estoque[i].quantidade == 0) {

                System.out.println("---------------------");
                System.out.println("Código: " + estoque[i].codigo);
                System.out.println("Descrição: " + estoque[i].descricao);
                System.out.println("Quantidade: " + estoque[i].quantidade);

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma peça com estoque zerado.");
        }
    }
    public static void faturamentoPecas(
        OrdemServico[] os,
        int qtdOS,
        Estoque[] estoque,
        int qtdEstoque) {

    double faturamentoTotal = 0;

    for (int i = 0; i < qtdOS; i++) {

        for (int j = 0; j < qtdEstoque; j++) {

            if (os[i].idPeca == estoque[j].codigo) {

                faturamentoTotal +=
                        os[i].quantidadePeca * estoque[j].preco;

                break;
            }
        }
    }

    System.out.println("===== FATURAMENTO DE PEÇAS =====");
    System.out.printf("Total faturado com peças: R$ %.2f%n",
            faturamentoTotal);
}
}