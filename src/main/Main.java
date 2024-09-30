package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static final String ARQUIVO_FINANCIAMENTOS = "financiamentos.dat"; // Nome do arquivo para salvar financiamentos
    private static final String ARQUIVO_TEXTO = "financiamentos.txt"; // Nome do arquivo texto para salvar financiamentos

    public static void main(String[] args) {
        // Criar uma lista de financiamentos
        ArrayList<Financiamento> listaFinanciamentos = carregarFinanciamentos(ARQUIVO_FINANCIAMENTOS);
        if (listaFinanciamentos == null) {
            listaFinanciamentos = new ArrayList<>(); // Cria uma nova lista se não houver dados no arquivo
        }

        // Instanciar a InterfaceUsuario para capturar os dados
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Criar novos financiamentos");
            System.out.println("2. Carregar financiamentos de um arquivo texto");
            System.out.println("3. Exibir financiamentos");
            System.out.println("0. Sair");
            opcao = interfaceUsuario.pedirOpcao();

            switch (opcao) {
                case 1:
                    // Adicionar financiamentos
                    for (int i = 1; i <= 4; i++) {
                        System.out.println("=== Financiamento " + i + " ===");
                        double valorImovel = interfaceUsuario.pedirValorImovel();
                        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
                        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

                        // Criar e adicionar o financiamento na lista
                        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
                        listaFinanciamentos.add(financiamento);
                    }

                    // Salvar a lista de financiamentos em arquivo texto
                    salvarFinanciamentosEmTexto(listaFinanciamentos, ARQUIVO_TEXTO);

                    // Salvar a lista de financiamentos no arquivo serializado
                    salvarFinanciamentos(listaFinanciamentos, ARQUIVO_FINANCIAMENTOS);
                    break;

                case 2:
                    // Carregar financiamentos de um arquivo texto
                    carregarFinanciamentosDeTexto(ARQUIVO_TEXTO, listaFinanciamentos);
                    break;

                case 3:
                    // Exibir todos os financiamentos
                    exibirFinanciamentos(listaFinanciamentos);
                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        // Fechar o scanner
        interfaceUsuario.fechar();
    }

    // Método para salvar financiamentos em um arquivo texto
    private static void salvarFinanciamentosEmTexto(ArrayList<Financiamento> listaFinanciamentos, String arquivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Financiamento financiamento : listaFinanciamentos) {
                // Salva os dados formatados com descrições
                pw.printf("Valor do Imóvel: R$ %.2f, Total do Financiamento: R$ %.2f, Taxa de Juros Anual: %.2f%%, Prazo: %d anos%n",
                        financiamento.getValorImovel(),
                        financiamento.calcularTotalPagamento(),
                        financiamento.getTaxaJurosAnual(),
                        financiamento.getPrazoFinanciamento());
            }
            System.out.println("Financiamentos salvos em texto com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar financiamentos em texto: " + e.getMessage());
        }
    }

    // Método para carregar financiamentos de um arquivo texto
    private static void carregarFinanciamentosDeTexto(String arquivo, ArrayList<Financiamento> listaFinanciamentos) {
        listaFinanciamentos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(", ");
                double valorImovel = Double.parseDouble(partes[0].split(": ")[1].replace("R$ ", "").replace(".", "").replace(",", "."));
                double totalFinanciamento = Double.parseDouble(partes[1].split(": ")[1].replace("R$ ", "").replace(".", "").replace(",", "."));
                double taxaJuros = Double.parseDouble(partes[2].split(": ")[1].replace("%", "").replace(",", "."));
                int prazo = Integer.parseInt(partes[3].split(": ")[1].replace(" anos", ""));

                // Criar um novo financiamento e adicionar à lista
                Financiamento financiamento = new Financiamento(valorImovel, prazo, taxaJuros);
                listaFinanciamentos.add(financiamento);
            }
            System.out.println("Financiamentos carregados de texto com sucesso.");
            // Exibir financiamentos carregados
            exibirFinanciamentos(listaFinanciamentos);
        } catch (IOException e) {
            System.out.println("Erro ao carregar financiamentos de texto: " + e.getMessage());
        }
    }

    // Método para exibir todos os financiamentos
    private static void exibirFinanciamentos(ArrayList<Financiamento> listaFinanciamentos) {
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

    // Método para salvar financiamentos em um arquivo
    private static void salvarFinanciamentos(ArrayList<Financiamento> listaFinanciamentos, String arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(listaFinanciamentos);
            System.out.println("Financiamentos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar financiamentos: " + e.getMessage());
        }
    }

    // Método para carregar financiamentos de um arquivo
    private static ArrayList<Financiamento> carregarFinanciamentos(String arquivo) {
        ArrayList<Financiamento> listaFinanciamentos = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            listaFinanciamentos = (ArrayList<Financiamento>) ois.readObject();
            System.out.println("Financiamentos carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar financiamentos: " + e.getMessage());
        }
        return listaFinanciamentos;
    }
}