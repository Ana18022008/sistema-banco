# 💳 Sistema Bancário – Prova Prática  

> Um sistema bancário simples via **terminal**, desenvolvido em **Java**, para gerenciar contas, clientes e operações financeiras.  
> Projeto feito como parte de uma prova prática, explorando **Orientação a Objetos**, **Herança**, **Polimorfismo** e **Tratamento de Exceções**.  

---

## 🛠 Funcionalidades  

### 👤 Login
- Criar nova conta.  
- Fazer login como **Administrador** (nome terminando com `.adm`) ou **Usuário Comum**.  

### 🔑 Administrador  
✔️ Cadastrar nova conta  
✔️ Depositar valores  
✔️ Sacar valores  
✔️ Transferir entre contas  
✔️ Listar todas as contas  
✔️ Excluir conta  
✔️ Pesquisar conta pelo número  

### 👥 Usuário Comum  
✔️ Cadastrar nova conta  
✔️ Realizar transferências  

---

## 🏗 Estrutura do Projeto  

```
src/
└── br/com/banco
    ├── main
    │   └── Main.java        # Classe principal
    │
    ├── model
    │   ├── Conta.java       # Classe mãe (abstrata)
    │   ├── ContaCorrente.java
    │   ├── ContaPoupanca.java
    │   └── Usuario.java
    │
    ├── service
    │   └── Banco.java       # Regras de negócio
    │
    └── view
        └── Atendente.java   # Menus e interação no terminal
```

---

## 📖 Regras de Negócio  

1. **Classe Conta (abstrata)**  
   - Atributos: `numero`, `titular`, `saldo`.  
   - Métodos: getters/setters, `mostrarDetalhes()` (abstrato).  

2. **Subclasses**  
   - `ContaCorrente`  
   - `ContaPoupanca`  
   Cada uma sobrescreve `toString()` e `mostrarDetalhes()`.  

3. **Classe Banco**  
   - Gerencia `List<Conta>`  
   - Métodos: `cadastrarConta()`, `depositar()`, `sacar()`, `transferir()`, `listarContas()`.  

4. **Exceções**  
   - Tratamento de erros como saque maior que o saldo.  

---

## ⚡ Desafios Extras Implementados  

- ✅ **Classe abstrata** `Conta` com método `mostrarDetalhes()`.  
- ✅ **Agregação**: classe `Cliente` associada a `Conta`.  

---

## 📚 Conceitos Praticados  

| 🧩 Conceito              | 📘 Descrição                                                                 |
|--------------------------|-----------------------------------------------------------------------------|
| **Encapsulamento**       | Atributos privados + getters e setters                                      |
| **Herança**              | Subclasses herdando de `Conta`                                              |
| **Polimorfismo**         | Uso de `instanceof` e sobrescrita de métodos                                |
| **List**                 | Armazenamento dinâmico das contas                                           |
| **Sobrescrita**          | Métodos `toString()` e `mostrarDetalhes()`                                  |
| **Exceções**             | `try/catch` para operações inválidas                                        |
| **Menus via Terminal**   | Interação com usuário                                                       |

---

## ▶️ Como Executar  

1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/sistema-bancario.git
   ```
2. Acesse a pasta:  
   ```bash
   cd sistema-bancario
   ```
3. Compile o projeto:  
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:  
   ```bash
   java -cp target/sistema-bancario-1.0-SNAPSHOT.jar br.com.banco.main.Main
   ```

---

## 📌 Exemplo de Menus  

**Administrador:**  
```
 -------- MENU --------
|1. Cadastrar Conta
|2. Depositar
|3. Sacar
|4. Transferir
|5. Listar Contas
|6. Excluir Conta
|7. Pesquisar por número
| -----------------------
|0. Voltar
 -----------------------
>
```

**Usuário Comum:**  
```
 -------- MENU --------
|1. Cadastrar Conta
|2. Transferir
| -----------------------
|0. Voltar
 -----------------------
>
```

---

## ⚙️ Tecnologias Utilizadas  

- ☕ **Java 17+**  
- 📦 **Maven**  
- 🖥 **IntelliJ IDEA**  

---

## ✨ Autores  

Desenvolvido por **Ana Beatriz de Oliveira Ribeiro, Catarina Klein e Gabriel Ehrat Fagundes** 🎓  
Turma: **MIDS-77**  
