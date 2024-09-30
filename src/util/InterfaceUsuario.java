package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    // Construtor
    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    // Método para pedir o valor do imóvel com validação e tratamento de erros
    public double pedirValorImovel() {
        double valorImovel = -1;
        boolean valorValido = false;
        do {
            try {
                System.out.print("Digite o valor do imóvel (deve ser um número positivo): ");
                valorImovel = scanner.nextDouble();

                if (valorImovel <= 0) {
                    throw new IllegalArgumentException("Valor inválido! O valor do imóvel deve ser positivo.");
                }

                valorValido = true; // Entrada válida
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número válido.");
                scanner.next(); // Limpa a entrada incorreta
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valorValido);
        return valorImovel;
    }

    // Método para pedir o prazo do financiamento com validação e tratamento de erros
    public int pedirPrazoFinanciamento() {
        int prazoFinanciamento = -1;
        boolean valorValido = false;
        do {
            try {
                System.out.print("Digite o prazo do financiamento (em anos, deve ser um número positivo): ");
                prazoFinanciamento = scanner.nextInt();

                if (prazoFinanciamento <= 0) {
                    throw new IllegalArgumentException("Prazo inválido! O prazo do financiamento deve ser positivo.");
                }

                valorValido = true; // Entrada válida
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número inteiro válido.");
                scanner.next(); // Limpa a entrada incorreta
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valorValido);
        return prazoFinanciamento;
    }

    // Método para pedir a taxa de juros anual com validação e tratamento de erros
    public double pedirTaxaJurosAnual() {
        double taxaJurosAnual = -1;
        boolean valorValido = false;
        do {
            try {
                System.out.print("Digite a taxa de juros anual (deve ser um número positivo): ");
                taxaJurosAnual = scanner.nextDouble();

                if (taxaJurosAnual <= 0) {
                    throw new IllegalArgumentException("Taxa de juros inválida! A taxa deve ser positiva.");
                }

                valorValido = true; // Entrada válida
            } catch (InputMismatchException e) {
                System.out.println("Erro: Você deve digitar um número válido.");
                scanner.next(); // Limpa a entrada incorreta
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valorValido);
        return taxaJurosAnual;
    }

    public int pedirOpcao() {
        int opcao = 0;
        while (true) {
            try {
                opcao = scanner.nextInt();
                if (opcao < 1 || opcao > 5) {
                    System.out.print("Opção inválida! Escolha um número entre 1 e 5: ");
                } else {
                    break; // Saia do loop se a opção for válida
                }
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida! Por favor, digite um número: ");
                scanner.next(); // Limpa o buffer
            }
        }
        return opcao;
    }

    // Método para fechar o scanner
    public void fechar() {
        scanner.close();
    }
}