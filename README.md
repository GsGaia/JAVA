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

- [📋 Tabela de Conteúdos](#-tabela-de-conteúdos)
- [🎥 Demonstração da Solução Completa](#-demonstração-da-solução-completa)
- [🌍 Visão Geral](#-visão-geral)
- [✨ Funcionalidades Principais](#-funcionalidades-principais)
- [🏗️ Arquitetura do Projeto](#️-arquitetura-do-projeto)
- [🛠️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
- [👥 Integrantes](#-integrantes)
- [🚀 Como Executar o Projeto](#-como-executar-o-projeto)
  - [Pré-requisitos](#pré-requisitos)
  - [Configuração do Ambiente](#configuração-do-ambiente)
- [📖 Endpoints da API e Exemplos de JSON](#-endpoints-da-api-e-exemplos-de-json)
  - [Autenticação](#autenticação)
  - [Usuários (Users)](#usuários-users)
  - [Localizações (Locations)](#localizações-locations)
  - [Acidentes (Accidents)](#acidentes-accidents)
  - [Requisições (Requestions)](#requisições-requestions)

---

## 🎥 Demonstração da Solução Completa

- **[Pitch da Solução](https://www.canva.com/design/DAGJWb25iBw/L6xT_3d-WESf2h-R2ODfbA/edit?utm_content=DAGJWb25iBw&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)**: Apresentação visual e conceitual do projeto.
- **[Deploy da Aplicação](http://191.234.186.183:8080/swagger-ui/index.html)**: Acesse a API em produção e interaja com os endpoints.
- **[Vídeo Demonstração](link-para-seu-video-aqui)**: Assista a um tour completo pelas funcionalidades da solução.

---

## 🌍 Visão Geral

O **Projeto Gaia** é uma solução de software desenvolvida como parte da Global Solution da FIAP. A ideia é fazer um software que irá ajudar na logistica das equipes de apoio na parte das doações e nas bases de apoio.

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

## 👥 Integrantes

**Por favor, preencha com os dados da sua equipe:**

| Nome Completo     | RM      | Turma   |
| ----------------- | ------- | ------- |
| [Luiz Eduardo Da Silva Pinto] | [555213 ] | [2TDSPM] |
| [Eduardo Augusto Pelegrino Einsfeldt] | [556460] | [2TDSPM] |
| [Murillo Ari Ferreira Sant'Anna] | [557183] | [2TDSPM] |


---

## 🚀 Como Executar o Projeto

### Pré-requisitos

-   [Java 21](https://www.oracle.com/java/technologies/downloads/#java21) ou superior
-   [Gradle 8.1.3](https://gradle.org/releases/) ou superior
-   Um banco de dados PostgreSQL rodando localmente ou em um servidor.

### Configuração do Ambiente

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/GsGaia/JAVA.git](https://github.com/GsGaia/JAVA.git)
    cd JAVA
    ```

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
  "statusLocation": "BOM",
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
  "typeAccident": "ENCHENTE",
  "severityAccident": "BAIXA",
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
  "status": "COMPLETA",
  "userId": 1,
  "locationId": 1
}
