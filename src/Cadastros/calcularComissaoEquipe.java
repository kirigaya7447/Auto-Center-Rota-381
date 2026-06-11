package Cadastros;

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