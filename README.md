
# 🏠 Simulação de Financiamento Imobiliário

## 📖 Descrição do Projeto

Este projeto foi desenvolvido para a disciplina de **Programação Orientada a Objetos** na **PUCPR**. Ele simula o cálculo de financiamentos imobiliários, permitindo ao usuário inserir informações sobre o valor do imóvel, taxa de juros anual e o prazo do financiamento. O sistema calcula o valor das parcelas mensais e o total a ser pago ao final do financiamento, considerando juros compostos.

O projeto foi desenvolvido em **Java**, utilizando conceitos de POO como classes, métodos, encapsulamento e listas (`ArrayList`). Além disso, o sistema realiza validações nas entradas do usuário, garantindo que os valores inseridos são positivos.

## ⚙️ Funcionalidades

- Inserir informações de até **4 financiamentos** diferentes.
- Calcular o valor das **parcelas mensais** com base nos dados fornecidos.
- Exibir o **total de todos os imóveis** e o **valor total de todos os financiamentos**.
- Garantir que os valores inseridos sejam válidos (não negativos).

## 📂 Estrutura do Projeto

O projeto está dividido em três pacotes principais:

- **main**: Contém a classe `Main`, responsável pela execução principal do programa.
- **modelo**: Contém a classe `Financiamento`, que realiza os cálculos das parcelas e do total a pagar.
- **util**: Contém a classe `InterfaceUsuario`, responsável pela interação com o usuário e validação de dados.

### Pacotes e Classes

- **Main**
  - Classe principal que executa o programa e exibe o resumo dos financiamentos.
  
- **modelo/Financiamento**
  - Representa um financiamento imobiliário com três atributos: valor do imóvel, prazo e taxa de juros anual.
  - Métodos:
    - `calcularPagamentoMensal()`: Calcula o valor das parcelas mensais.
    - `calcularTotalPagamento()`: Calcula o valor total do financiamento.
    - `exibirInformacoes()`: Exibe os dados do financiamento.

- **util/InterfaceUsuario**
  - Lida com a entrada de dados do usuário.
  - Valida que os valores inseridos sejam positivos.

## 🚀 Como Executar o Projeto

### Requisitos

- **Java JDK 8 ou superior**.
- **IDE**: O projeto foi desenvolvido no **IntelliJ IDEA**, mas pode ser executado em qualquer IDE compatível com Java.

### Passos para Execução

1. Clone o repositório do GitHub: [Simulação de Financiamento](https://github.com/mathhsilva/SimulacaoFinanciamento).
2. Abra o projeto em sua IDE.
3. Execute a classe `Main.java` no pacote `main`.
4. Siga as instruções no console para inserir os dados dos financiamentos.

### Estrutura do Projeto no IntelliJ

```
SimulacaoFinanciamento
└── src
    ├── main
    │   └── Main.java
    ├── modelo
    │   └── Financiamento.java
    └── util
        └── InterfaceUsuario.java
```

## 💻 Exemplo de Execução

```plaintext
=== Financiamento 1 ===
Digite o valor do imóvel (deve ser positivo):
200000
Digite o prazo do financiamento (em anos, deve ser positivo):
30
Digite a taxa de juros anual (deve ser positiva):
10

=== Financiamento 2 ===
Digite o valor do imóvel (deve ser positivo):
300000
Digite o prazo do financiamento (em anos, deve ser positivo):
20
Digite a taxa de juros anual (deve ser positiva):
5

=== Resumo dos Financiamentos ===

=== Financiamento 1 ===
Valor do Imóvel: R$ 200000,00
Prazo do Financiamento: 30 anos
Taxa de Juros Anual: 10,00%
Pagamento Mensal: R$ 1755,14
Total a Pagar: R$ 631850,40

=== Financiamento 2 ===
Valor do Imóvel: R$ 300000,00
Prazo do Financiamento: 20 anos
Taxa de Juros Anual: 5,00%
Pagamento Mensal: R$ 1981,93
Total a Pagar: R$ 475662,40

Total de todos os imóveis: R$ 500000,00
Total de todos os financiamentos: R$ 1107512,80
```

## ✅ Validações

- O valor do imóvel, o prazo do financiamento e a taxa de juros anual devem ser positivos.
- Se um valor inválido for inserido, o sistema solicitará uma nova entrada.

## 📜 Licença

Este projeto é destinado a fins acadêmicos e educacionais. Sinta-se à vontade para usar e modificar para seus estudos.

## 👤 Autor

- **Nome**: Matheus Silva
- **Universidade**: Pontifícia Universidade Católica do Paraná - PUCPR
- **GitHub**: [Simulação de Financiamento](https://github.com/mathhsilva/SimulacaoFinanciamento)
