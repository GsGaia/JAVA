<div align="center">
  <h1>Projeto Gaia</h1>
  <p><strong>API para Monitoramento e Gerenciamento de Eventos Climáticos Extremos</strong></p>
  <p>
    <img src="https://img.shields.io/badge/Java-21-blue?logo=java&logoColor=white" alt="Java 21">
    <img src="https://img.shields.io/badge/Spring_Boot-3.2.6-green?logo=spring&logoColor=white" alt="Spring Boot 3.2.6">
    <img src="https://img.shields.io/badge/Gradle-8.1.3-blue?logo=gradle&logoColor=white" alt="Gradle 8.1.3">
    <img src="https://img.shields.io/badge/PostgreSQL-13-blue?logo=postgresql&logoColor=white" alt="PostgreSQL">
    <img src="https://img.shields.io/badge/Docker-blue?logo=docker&logoColor=white" alt="Docker">
  </p>
</div>

---

## 📋 Tabela de Conteúdos

1.  [Visão Geral](#-visão-geral)
2.  [Funcionalidades Principais](#-funcionalidades-principais)
3.  [Arquitetura do Projeto](#-arquitetura-do-projeto)
4.  [Tecnologias Utilizadas](#-tecnologias-utilizadas)
5.  [Como Executar o Projeto](#-como-executar-o-projeto)
    - [Pré-requisitos](#pré-requisitos)
    - [Configuração do Ambiente](#configuração-do-ambiente)
    - [Execução com Docker](#execução-com-docker)
6.  [Endpoints da API e Exemplos de JSON](#-endpoints-da-api-e-exemplos-de-json)
    - [Autenticação](#autenticação)
    - [Usuários (Users)](#usuários-users)
    - [Localizações (Locations)](#localizações-locations)
    - [Acidentes (Accidents)](#acidentes-accidents)
    - [Requisições (Requestions)](#requisições-requestions)

---

## 🌍 Visão Geral

O **Projeto Gaia** é uma solução de software desenvolvida como parte da Global Solution da FIAP. A plataforma é uma API RESTful projetada para centralizar e gerenciar informações sobre eventos climáticos e geológicos extremos, permitindo o cadastro de locais afetados, acidentes, requisições de ajuda e o gerenciamento de usuários (administradores e voluntários).

O objetivo é fornecer um backend robusto e seguro que possa ser consumido por uma aplicação front-end (web ou mobile) para monitoramento e resposta a desastres em tempo real.

---

## ✨ Funcionalidades Principais

-   **Autenticação Segura:** Sistema de registro e login com autenticação baseada em JSON Web Tokens (JWT) para proteger os dados.
-   **Controle de Acesso por Papel (Role):** Distinção entre usuários `ADMIN` e `USER` para futuras implementações de regras de acesso.
-   **Gerenciamento Completo (CRUD):** Operações de Criar, Ler, Atualizar e Deletar para todas as entidades principais da aplicação.
-   **Documentação Interativa:** Uso do Springdoc (Swagger) para gerar uma documentação da API que permite interagir e testar os endpoints diretamente pelo navegador.
-   **Containerização:** Aplicação e banco de dados totalmente containerizados com Docker, facilitando o deploy e a execução em qualquer ambiente.

---

## 🏗️ Arquitetura do Projeto

A API segue uma arquitetura em camadas para garantir a separação de responsabilidades e a manutenibilidade do código:

-   **`Controller`**: Camada responsável por expor os endpoints da API, receber as requisições HTTP e retornar as respostas.
-   **`Service`**: Onde reside a lógica de negócio da aplicação.
-   **`Repository`**: Interfaces que gerenciam o acesso e a persistência dos dados no banco.
-   **`Models` / `Entities`**: Classes que mapeiam as tabelas do banco de dados (ORM).
-   **`Dto` (Data Transfer Objects)**: Objetos que carregam os dados entre o cliente e o servidor de forma segura.
-   **`Security`**: Pacote dedicado à configuração do Spring Security, filtros de autenticação e tokens JWT.

---

## 🛠️ Tecnologias Utilizadas

-   **Backend:** Java 21, Spring Boot 3
-   **Persistência:** Spring Data JPA, Hibernate
-   **Banco de Dados:** PostgreSQL
-   **Segurança:** Spring Security, JWT
-   **Containerização:** Docker
-   **Build:** Gradle 8.1.3
-   **Documentação:** Springdoc OpenAPI (Swagger UI)
-   **Validação:** Jakarta Bean Validation

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

-   [Java 21](https://www.oracle.com/java/technologies/downloads/#java21)
-   [Docker](https://www.docker.com/products/docker-desktop/)

### Configuração do Ambiente

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    cd seu-repositorio
    ```

2.  **Compile o projeto com Gradle:**
    Use o Wrapper do Gradle para compilar a aplicação e gerar o arquivo `.jar`. No Windows, use `gradlew.bat build`.
    ```bash
    ./gradlew build
    ```
    Isso irá gerar o arquivo JAR dentro da pasta `build/libs/`.

### Execução com Docker

Vamos subir os contêineres da aplicação e do banco de dados usando apenas comandos do Docker.

1.  **Crie a rede Docker:**
    É uma boa prática criar uma rede dedicada para que os contêineres se comuniquem.
    ```bash
    docker network create gaia-rede
    ```

2.  **Inicie o contêiner do Banco de Dados (PostgreSQL):**
    Este comando irá baixar a imagem do Postgres, iniciar o contêiner, conectá-lo à nossa rede e definir as credenciais.
    ```bash
    docker run -d \
        --name postgres-db \
        --network gaia-rede \
        -p 5432:5432 \
        -e POSTGRES_DB=gaiadatabase \
        -e POSTGRES_USER=admin \
        -e POSTGRES_PASSWORD=admin123 \
        postgres:13
    ```

3.  **Inicie o contêiner da Aplicação Gaia:**
    Este comando irá construir a imagem da sua aplicação a partir do `Dockerfile` local e iniciar o contêiner, conectando-o ao banco de dados.
    ```bash
    # Primeiro, construa a imagem a partir do seu Dockerfile
    docker build -t gaia-app .

    # Agora, inicie o contêiner com a imagem criada
    docker run -d \
        --name gaia-container \
        --network gaia-rede \
        -p 8080:8080 \
        -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres-db:5432/gaiadatabase \
        -e SPRING_DATASOURCE_USERNAME=admin \
        -e SPRING_DATASOURCE_PASSWORD=admin123 \
        -e JWT_SECRET=sua-chave-secreta-super-longa-e-segura \
        gaia-app
    ```
    
4.  **Acesse a aplicação:**
    -   API disponível em: `http://localhost:8080` (localmente) ou `http://191.234.186.183:8080` (pelo IP da VM)
    -   Documentação Swagger UI: `http://191.234.186.183:8080/swagger-ui/index.html`

---

## 📖 Endpoints da API e Exemplos de JSON

A seguir, exemplos de JSON para os principais endpoints de criação (`POST`). Você pode copiar e colar o corpo da requisição diretamente no Swagger UI para testar.

### Autenticação

-   `POST /auth/register` - Cria um novo usuário.
-   `POST /auth/login` - Autentica um usuário e retorna um token JWT.

**Exemplo JSON para `POST /auth/register`**
```json
{
  "name": "Luiz da Silva",
  "password": "senhaSegura123",
  "cpf": "12345678901",
  "email": "luiz.silva@example.com",
  "role": "ADMIN"
}
```

**Exemplo JSON para `POST /auth/login`**
```json
{
  "email": "luiz.silva@example.com",
  "password": "senhaSegura123"
}
```

### Usuários (Users)

-   `POST /api/user` - Cria um novo usuário (geralmente uma rota protegida para administradores).

**Exemplo JSON para `POST /api/user`**
```json
{
  "name": "Mariana Costa",
  "email": "mariana.costa@example.com",
  "password": "outraSenhaForte456",
  "cpf": "11122233344",
  "creationDate": "2025-06-07",
  "role": "USER",
  "activeUser": true,
  "requestions": []
}
```

### Localizações (Locations)

-   `POST /api/location` - Cria uma nova localização.

**Exemplo JSON para `POST /api/location`**
```json
{
  "state": "SP",
  "city": "São Paulo",
  "startAccident": "2025-06-07",
  "endAccident": "2025-06-08",
  "statusLocation": "MONITORING",
  "active": true
}
```

### Acidentes (Accidents)

-   `POST /api/accident` - Registra um novo acidente associado a uma localização.

**Exemplo JSON para `POST /api/accident`**
```json
{
  "dateAccidentStart": "2025-06-07",
  "dateAccidentEnd": "2025-06-08",
  "typeAccident": "FLOODING",
  "severityAccident": "HIGH",
  "locationId": 1
}
```

### Requisições (Requestions)

-   `POST /api/requestion` - Cria uma nova requisição de ajuda.

**Exemplo JSON para `POST /api/requestion`**
```json
{
  "title": "Necessidade de Água Potável",
  "description": "Precisamos de 100 litros de água potável para o abrigo central.",
  "unit": "LITERS",
  "requestDate": "2025-06-07",
  "status": "PENDING",
  "userId": 1,
  "locationId": 1
}
```
