package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criar uma lista de financiamentos
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

        // Instanciar a InterfaceUsuario para capturar os dados
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Adicionar quatro financiamentos
        for (int i = 1; i <= 4; i++) {
            System.out.println("=== Financiamento " + i + " ===");
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            // Criar e adicionar o financiamento na lista
            Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
            listaFinanciamentos.add(financiamento);
        }

        // Exibir todos os financiamentos e calcular os totais
        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        System.out.println("\n=== Resumo dos Financiamentos ===");
        for (int i = 0; i < listaFinanciamentos.size(); i++) {
            Financiamento financiamento = listaFinanciamentos.get(i);
            System.out.println("\n=== Financiamento " + (i + 1) + " ===");
            financiamento.exibirInformacoes();

            // Acumular os valores
            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();
        }

        // Exibir os totais
        System.out.printf("\nTotal de todos os imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalValorFinanciamentos);
    }
}