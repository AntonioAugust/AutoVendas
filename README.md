# 🚗 Sistema de Gerenciamento de Vendas de Veículos

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)

Uma aplicação desenvolvida em Java para auxiliar no controle de clientes, estoque e vendas em uma concessionária.

---

## 👥 Integrantes do Projeto

- **Antonio Augusto**
- **Artur Antunes**
- **Julielen Dorneles**

---

## ⚙️ Funcionalidades do Sistema

### 👤 Gestão de Clientes
- Cadastro de clientes (com validação interativa de dados)
- Consulta de clientes por ID
- Consulta de clientes por data de nascimento
- Controle de saldo por carteira

### 🚘 Controle de Estoque
- Cadastro de veículos
- Remoção de veículos do estoque
- Identificação de veículos por ID

### 💰 Controle de Vendas
- Realização de vendas com diferentes formas de pagamento
- Validação rigorosa de saldo do cliente antes da compra
- Registro detalhado das vendas realizadas (geração de recibos)
- Consulta de vendas por ID
- Consulta de vendas por data

---

## 🧠 Modelagem Orientada a Objetos

O projeto foi desenvolvido com base nos pilares e recursos avançados da Programação Orientada a Objetos (POO), utilizando:

- Encapsulamento
- Herança
- Abstração
- Polimorfismo
- Interface
- Classes Internas e Java Anônimo

### Onde cada conceito foi aplicado

- **Encapsulamento**: utilizado por meio de atributos `private` e métodos `getters` e `setters`, protegendo os dados sensíveis das classes (como saldo da carteira e preços) e garantindo que a modificação ocorra apenas por vias seguras.
- **Herança**: aplicada nas classes `Cliente` (que herda de `Pessoa`), `Carro` e `Moto` (que herdam de `Veiculo`), além de `Pix` e `CartaoCredito` (que herdam da classe mãe `FormaPagamento`), promovendo o forte reaproveitamento de código.
- **Abstração**: definimos as classes `Veiculo` e `FormaPagamento` como `abstract`. Na prática, elas funcionam apenas como "moldes" base para o sistema. Com isso, o nosso código bloqueia qualquer tentativa de instanciar essas classes diretamente, nos obrigando a sempre construir entidades concretas e reais baseadas nesses moldes.
- **Polimorfismo**: ocorre de forma dinâmica em duas frentes principais. Primeiro, na estruturação do estoque, quando objetos das subclasses `Carro` e `Moto` são manipulados através de referências da superclasse `Veiculo`, permitindo que métodos sobrescritos tenham comportamentos diferentes em tempo de execução. Segundo, na regra de negócios, onde o processamento da venda recebe uma referência genérica de `FormaPagamento`, mas o Java executa automaticamente o cálculo da taxa específica da subclasse injetada. Também ocorre de forma estática (sobrecarga) ao termos múltiplas versões do método de adicionar clientes.
- **Interface**: a interface `Calculavel` foi utilizada para definir um contrato de comportamentos comuns. Garantimos que mais de uma classe (`Venda` e `ItemEstoque`) implemente essa interface, padronizando e obrigando a implementação da regra de cálculo de valores finais no sistema.
- **Classes Internas e Anônimas**: a classe privada `Recibo` foi criada estruturalmente dentro de `Venda` para isolar e assumir a responsabilidade pela formatação visual do comprovante. Já o Java Anônimo foi aplicado no simulador para a criação dinâmica de uma forma de pagamento com desconto exclusivo em tempo de execução.

---

## 🏗️ Estrutura do Projeto

A organização principal do sistema foi dividida da seguinte forma:

- `Pessoa`: classe base com os dados comuns de uma pessoa
- `Cliente`: herda de `Pessoa` e possui carteira própria
- `Carteira`: responsável pelo controle do saldo do cliente
- `Veiculo`: classe abstrata com os dados e comportamentos comuns dos veículos
- `Carro`: classe filha de `Veiculo`
- `Moto`: classe filha de `Veiculo`
- `ItemEstoque`: vincula um veículo a um preço específico no estoque
- `FormaPagamento`: classe abstrata que define o contrato base para as taxas de pagamento
- `Pix`: classe filha de `FormaPagamento`
- `CartaoCredito`: classe filha de `FormaPagamento`
- `ControleClientes`: responsável pelo gerenciamento dos clientes
- `ControleEstoque`: responsável pelo gerenciamento do estoque de veículos
- `ControleVendas`: responsável pelo fluxo de vendas
- `Venda`: responsável pelo registro e processamento das vendas realizadas
- `Recibo`: classe interna (privada dentro de `Venda`) responsável por formatar o comprovante visual
- `Calculavel`: interface implementada por `ItemEstoque` e `Venda` para padronizar o cálculo de valores finais
- `SimuladorVendas`: classe coordenadora que gerencia a demonstração, a interação com o usuário no terminal e instancia a classe anônima de desconto

---

## 💻 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- IntelliJ IDEA
- Git
- GitHub
- Terminal / CLI

---

## ▶️ Execução do Projeto

O projeto é executado em ambiente de terminal, onde são realizados testes de cadastro interativo de clientes, cadastro de veículos, controle de estoque e registro de vendas simulando cenários reais e de exceção (como saldo insuficiente).

---

## 📌 Status do Projeto

Projeto em desenvolvimento.
