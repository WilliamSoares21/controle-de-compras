# 🛒 Sistema de Controle de Compras

Um sistema de loja virtual desenvolvido em Java para prática e aplicação de conceitos fundamentais de Programação Orientada a Objetos (POO).

## 📋 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de praticar e consolidar os principais pilares da Programação Orientada a Objetos, incluindo **Encapsulamento**, **Herança**, **Polimorfismo** e **Abstração**. O sistema simula uma loja virtual completa, permitindo que clientes naveguem por um catálogo de produtos, adicionem itens ao carrinho e realizem pagamentos utilizando diferentes formas de pagamento.

## ✨ Funcionalidades

- **Cadastro de Cliente**: Sistema de cadastro com geração automática de saldos aleatórios
- **Catálogo de Produtos**: Organização de produtos por setores (Eletrodomésticos e Vestuário)
- **Carrinho de Compras**: Adição de múltiplos produtos ao carrinho
- **Múltiplas Formas de Pagamento**:
  - Cartão de Crédito
  - Dinheiro
  - PIX
- **Validação de Saldo**: Verificação automática de saldo disponível antes da conclusão da compra
- **Geração de Cupom Fiscal**: Emissão de comprovante detalhado após pagamento aprovado
- **Interface de Usuário**: Menu interativo via terminal com formatação visual aprimorada

## 🎯 Conceitos de POO Aplicados

### 1. **Encapsulamento**
- Atributos privados com acesso controlado via getters e setters
- Proteção de dados sensíveis do cliente e das transações
- Exemplo: classe `Cliente` com atributos privados e métodos públicos de acesso

### 2. **Herança**
- Classe abstrata `Produto` como base para todos os produtos da loja
- Produtos específicos herdam características comuns:
  - **Vestuário**: `Camisa`, `Calca`, `Calcao`, `Moletom`
  - **Eletrodomésticos**: `Batedeira`, `Liquidificador`, `Microondas`, `Geladeira`

### 3. **Polimorfismo**
- Interface `FormaDePagamento` implementada por diferentes métodos de pagamento
- Cada forma de pagamento possui comportamento específico no método `pagar()`
- Interface `Vitrine` implementada pela classe `Produto` para exibição de informações

### 4. **Abstração**
- Classe abstrata `Produto` define o contrato base para todos os produtos
- Interface `FormaDePagamento` abstrai o conceito de pagamento
- Foco no "o que fazer" ao invés de "como fazer"

## 🏗️ Estrutura do Projeto

```
src/main/java/
├── principal/
│   └── Main.java                 # Classe principal com menu interativo
├── pagamento/
│   ├── FormaDePagamento.java     # Interface para formas de pagamento
│   ├── Cartao.java               # Implementação de pagamento com cartão
│   ├── Dinheiro.java             # Implementação de pagamento em dinheiro
│   ├── Pix.java                  # Implementação de pagamento via PIX
│   ├── Cliente.java              # Gerenciamento de dados do cliente
│   ├── Compra.java               # Representação de uma compra
│   └── CupomFiscal.java          # Geração de cupom fiscal
└── loja/
    ├── Catalogo.java             # Gerenciamento do catálogo de produtos
    ├── Secao.java                # Organização por seções
    └── produtos/
        ├── Produto.java          # Classe abstrata base
        ├── Vitrine.java          # Interface para exibição
        ├── Camisa.java           # Produto específico
        ├── Calca.java            # Produto específico
        ├── Calcao.java           # Produto específico
        ├── Moletom.java          # Produto específico
        ├── Batedeira.java        # Produto específico
        ├── Liquidificador.java   # Produto específico
        ├── Microondas.java       # Produto específico
        └── Geladeira.java        # Produto específico
```

## 🚀 Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal
- **Maven**: Gerenciamento de dependências e build
- **Java Collections**: ArrayList, HashMap, List para gerenciamento de dados

## 📦 Pré-requisitos

- JDK 21 ou superior
- Maven 3.6 ou superior

## ⚙️ Como Executar

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd controle-de-compras
```

2. Compile o projeto com Maven:
```bash
mvn clean compile
```

3. Execute a aplicação:
```bash
mvn exec:java -Dexec.mainClass="principal.Main"
```

## 🎮 Como Usar

1. **Inicialização**: Digite seu nome quando solicitado
2. **Visualização de Saldo**: O sistema exibe automaticamente seus saldos disponíveis em cada forma de pagamento
3. **Navegação no Catálogo**:
   - Escolha um setor (Eletrodomésticos ou Vestuário)
   - Selecione produtos para adicionar ao carrinho
   - Digite `0` para voltar ao menu anterior
4. **Finalização da Compra**:
   - Revise os itens no carrinho e o valor total
   - Escolha a forma de pagamento desejada
   - O sistema valida o saldo e confirma o pagamento
5. **Cupom Fiscal**: Após aprovação, um cupom fiscal detalhado é gerado automaticamente

## 💡 Exemplo de Uso

```
╔════════════════════════════════════════════╗
║       BEM-VINDO À LOJA VIRTUAL            ║
╚════════════════════════════════════════════╝

Digite seu nome: João Silva

Olá, João Silva! Bem-vindo à nossa loja virtual!
╔═══════════════════════════════════════════╗
║             SALDOS DISPONÍVEIS            ║
╠═══════════════════════════════════════════╣
║ Cartão de Crédito: R$ 3456.78            ║
║ Dinheiro: R$ 789.45                      ║
║ PIX: R$ 2134.56                           ║
╚═══════════════════════════════════════════╝

╔════════════════════════════════════════════╗
║         CATÁLOGO DE PRODUTOS               ║
╚════════════════════════════════════════════╝
======= SETORES DA LOJA =======
1 - Vestuário
2 - Eletrodomésticos
...
```

## 📚 Aprendizados

Este projeto proporcionou prática hands-on com:

- Design de classes e relacionamentos entre objetos
- Implementação de interfaces e classes abstratas
- Uso efetivo de coleções Java (List, Map)
- Manipulação de entrada/saída via terminal
- Formatação de strings e números para apresentação
- Organização de código em pacotes lógicos
- Aplicação de princípios SOLID básicos

## 🔄 Possíveis Melhorias Futuras

- Implementação de persistência de dados (banco de dados)
- Sistema de autenticação e login
- Histórico de compras do cliente
- Sistema de descontos e promoções
- Carrinho persistente entre sessões
- Interface gráfica (GUI) com JavaFX ou Swing
- Testes unitários com JUnit
- Sistema de estoque com controle de quantidade

## 👤 Autor

Desenvolvido como projeto de estudo e prática de Programação Orientada a Objetos.

## 📄 Licença

Este é um projeto educacional de código aberto, livre para uso e modificação.

---

⭐ **Nota**: Este projeto foi desenvolvido exclusivamente para fins de aprendizado e prática dos conceitos de POO em Java.
