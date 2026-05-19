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
- Cadastro de clientes
- Consulta de clientes por ID
- Consulta de clientes por data de nascimento
- Controle de saldo por carteira

### 🚘 Controle de Estoque
- Cadastro de veículos
- Remoção de veículos do estoque
- Identificação de veículos por ID

### 💰 Controle de Vendas
- Realização de vendas
- Validação de saldo do cliente antes da compra
- Registro das vendas realizadas
- Consulta de vendas por ID
- Consulta de vendas por data

---

## 🧠 Modelagem Orientada a Objetos

O projeto foi desenvolvido com base em conceitos de Programação Orientada a Objetos (POO), utilizando:

- Encapsulamento
- Herança
- Polimorfismo
- Interface

### Onde cada conceito foi aplicado

- **Encapsulamento**: utilizado por meio de atributos `private` e métodos `getters` e `setters`, protegendo os dados das classes.
- **Herança**: aplicada nas classes `Cliente`, que herda de `Pessoa`, e `Carro` e `Moto`, que herdam de `Veiculo`.
- **Polimorfismo**: aplicado na exibição dos dados dos veículos, já que objetos das classes `Carro` e `Moto` podem ser tratados como `Veiculo`, mas cada um mantém suas características próprias.
- **Interface**: utilizada para definir comportamentos comuns entre classes do sistema, permitindo padronizar a exibição de informações.

---

## 🏗️ Estrutura do Projeto

A organização principal do sistema foi dividida da seguinte forma:

- `Pessoa`: classe base com os dados comuns de uma pessoa
- `Cliente`: herda de `Pessoa` e possui carteira própria
- `Carteira`: responsável pelo controle do saldo do cliente
- `Veiculo`: classe abstrata com os dados e comportamentos comuns dos veículos
- `Carro`: classe filha de `Veiculo`
- `Moto`: classe filha de `Veiculo`
- `ControleClientes`: responsável pelo gerenciamento dos clientes
- `ControleEstoque`: responsável pelo gerenciamento do estoque de veículos
- `ControleVendas`: responsável pelo fluxo de vendas
- `Venda`: responsável pelo registro das vendas realizadas
- `Calculavel`: interface implementada por itemEstoque e Venda


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

O projeto é executado em ambiente de terminal, onde são realizados testes de cadastro de clientes, cadastro de veículos, controle de estoque e registro de vendas.

---

## 📌 Status do Projeto

Projeto em desenvolvimento.
