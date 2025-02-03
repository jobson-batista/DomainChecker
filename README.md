# Domain Checker CLI 🌍

_[English Version](#domain-checker-cli-en)_

_[Versão em Português](#domain-checker-cli-pt)_


## Domain Checker CLI (PT) 🇧🇷

O **Domain Checker** é uma aplicação Java que verifica a disponibilidade de domínios na internet. Atualmente, a aplicação busca por domínios `.com` e `.com.br` utilizando serviços como **GoDaddy** e **Registro BR**. Além disso, possui um **Web Scraper** que extrai informações de domínios a partir de uma página web e os armazena para consulta.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

Para rodar o projeto você precisa ter:

* [JDK 21](https://www.oracle.com/br/java/technologies/downloads/#java21)

### 🔧 Instalação

1. Clone o repositório em sua máquina local.
```bash
git clone https://github.com/jobson-batista/DomainChecker.git
```
2. Entre no diretório raiz.
```bash
cd DomainChecker
```
3. Gere o arquivo ```.jar``` com o código do projeto e todas a depedências necessárias para a execução do projeto.
```bash
./gradlew clean shadowJar
```
### ⚙️ Execução

1. Por padrão, o programa busca possíveis domínios listados nesse web site de exemplo: https://kworb.net/spotify/artists.html

```bash
java -jar build/libs/{Nome_do_Arquivo}.jar -d
```
2. Para buscar domínios passando um arquivo como parâmetro.
```bash
java -jar build/libs/{Nome_do_Arquivo}.jar -f file.txt
```

## ⚙️ Executando os testes
Para executar os testes automatizados é bem simples, basta rodar a task de teste.
```bash 
./gradlew clean test
```

## 🛠️ Construído com



* [Java 21](https://www.oracle.com/br/java/technologies/downloads/#java21)
* [Gradle 8.10](https://gradle.org/releases/) - Gerente de Dependência
* [JUnit 5](https://junit.org/junit5/) - Framework de testes automatizados
* [ShadowJar 9.0.0-beta7](https://github.com/GradleUp/shadow) - Plugin do Gradle que cria um arquivo `.jar` contendo **todas as dependências do projeto**.
* [JSoup](https://jsoup.org) - Biblioteca para manipular arquivos HTML e XML.


---

## Domain Checker CLI (EN) 🇺🇸

### **Domain Checker**

The **Domain Checker** is a Java application that checks the availability of domains on the internet. Currently, the application searches for `.com` and `.com.br` domains using services like **GoDaddy** and **Registro BR**. Additionally, it includes a **Web Scraper** that extracts domain information from a web page and stores it for reference.

## 🚀 Getting Started

These instructions will help you obtain a copy of the project running on your local machine for development and testing purposes.

### 📋 Prerequisites

To run the project, you need to have:

* [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)

### 🔧 Installation

1. Clone the repository to your local machine.
```bash
git clone https://github.com/jobson-batista/DomainChecker.git
```
2. Navigate to the root directory.
```bash
cd DomainChecker
```
3. Generate the `.jar` file containing the project's code and all necessary dependencies for execution.
```bash
./gradlew clean shadowJar
```

### ⚙️ Execution

1. By default, the program searches for possible domains listed on this sample website: https://kworb.net/spotify/artists.html

```bash
java -jar build/libs/{File_Name}.jar -d
```
2. To search for domains using a file as a parameter:
```bash
java -jar build/libs/{File_Name}.jar -f file.txt
```

## ⚙️ Running Tests
To run the automated tests, simply execute the test task.
```bash 
./gradlew clean test
```

## 🛠️ Built With

* [Java 21](https://www.oracle.com/java/technologies/downloads/#java21)
* [Gradle 8.10](https://gradle.org/releases/) - Dependency Manager
* [JUnit 5](https://junit.org/junit5/) - Automated Testing Framework
* [ShadowJar 9.0.0-beta7](https://github.com/GradleUp/shadow) - A Gradle plugin that creates a `.jar` file containing **all project dependencies**.
* [JSoup](https://jsoup.org) - A library for parsing and manipulating HTML and XML files.
