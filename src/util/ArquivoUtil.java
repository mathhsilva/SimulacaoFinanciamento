package util;

import modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class ArquivoUtil {

    // Salvar dados em um arquivo de texto
    public static void salvarDadosTexto(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.getValorImovel() + "," +
                        financiamento.getPrazoFinanciamento() + "," +
                        financiamento.getTaxaJurosAnual());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ler dados de um arquivo de texto
    public static ArrayList<Financiamento> lerDadosTexto(String nomeArquivo) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                double valorImovel = Double.parseDouble(partes[0]);
                int prazoFinanciamento = Integer.parseInt(partes[1]);
                double taxaJurosAnual = Double.parseDouble(partes[2]);
                Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
                financiamentos.add(financiamento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }

    // Salvar dados serializados
    public static void salvarDadosSerializados(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ler dados serializados
    public static ArrayList<Financiamento> lerDadosSerializados(String nomeArquivo) {
        ArrayList<Financiamento> financiamentos = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            financiamentos = (ArrayList<Financiamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }
}