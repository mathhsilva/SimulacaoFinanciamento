package modelo;

import java.io.Serializable;

public class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L; // Versão da serialização
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Calcular pagamento mensal com juros compostos
    public double calcularPagamentoMensal() {
        double taxaJurosMensal = taxaJurosAnual / 12 / 100; // Converte a taxa anual para mensal (em decimal)
        int totalMeses = prazoFinanciamento * 12; // Converte o prazo em anos para meses
        return (valorImovel * taxaJurosMensal) / (1 - Math.pow(1 + taxaJurosMensal, -totalMeses));
    }

    // Calcular total do pagamento
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12; // Total a pagar = parcela mensal * número de meses
    }

    // Exibir informações
    public void exibirInformacoes() {
        System.out.printf("Valor do Imóvel: R$ %.2f%n", valorImovel);
        System.out.printf("Prazo do Financiamento: %d anos%n", prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", taxaJurosAnual);
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total a Pagar: R$ %.2f%n", calcularTotalPagamento());
    }
}