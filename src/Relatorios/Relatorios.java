package Relatorios;
import Cadastros.Estoque;

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
}