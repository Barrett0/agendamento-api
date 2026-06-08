# 💈 Agendamento API

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue.svg)](https://www.postgresql.org/)
[![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203-green.svg)](https://swagger.io/)
[![JWT](https://img.shields.io/badge/JWT-Authentication-blueviolet.svg)](https://jwt.io/)

API REST robusta desenvolvida em **Java** e **Spring Boot 3** para gerenciamento e automação de agendamentos em uma barbearia ou salão de beleza. O sistema oferece cadastro de usuários, autenticação baseada em tokens JWT e operações CRUD completas para os agendamentos, com todas as rotas documentadas via Swagger.

---

## 🛠️ Tecnologias Utilizadas

* **Java 21** - Linguagem de programação principal.
* **Spring Boot 3.3.0** - Framework para simplificar o setup e desenvolvimento.
* **Spring Security** - Controle de acesso e segurança das rotas.
* **Spring Data JPA** - Abstração de banco de dados e ORM com Hibernate.
* **PostgreSQL** - Banco de dados relacional robusto.
* **Auth0 Java JWT** - Biblioteca para geração e validação de tokens JWT.
* **Springdoc OpenAPI UI (Swagger)** - Geração automática da documentação interativa da API.
* **Lombok** - Redução de código boilerplate (getters, setters, construtores).
* **Jakarta Validation** - Validação de dados de entrada nos DTOs.
* **Maven** - Gerenciador de dependências e build.

---

## 📋 Funcionalidades Principais

* **Autenticação Segura**: Geração de tokens JWT expiráveis no login e filtro de segurança stateless para interceptar rotas privadas.
* **Cadastro de Usuários**: Fluxo público para criação de novas contas com senhas criptografadas via `BCrypt`.
* **Gerenciamento de Agendamentos (CRUD)**:
  * Criação de agendamentos associando cliente, serviço, data e hora.
  * Listagem e busca detalhada por ID.
  * Atualização e cancelamento (exclusão) de agendamentos.
* **Documentação Interativa (Swagger UI)**: Acesso visual e testes diretos de todos os endpoints.
* **Redirecionamento Inteligente**: A rota raiz (`/`) redireciona automaticamente para o Swagger UI facilitando o uso em produção.

---

## 📁 Estrutura do Projeto

```text
src/main/java/com/barretto/agendamento
│
├── AgendamentoApplication.java      # Classe principal de inicialização da aplicação
│
├── config
│   └── SecurityConfig.java          # Configuração do Spring Security, CORS e rotas públicas
│
├── controller                       # Controladores REST (Endpoints)
│   ├── HomeController.java          # Redirecionamento da raiz (/) para o Swagger UI
│   ├── AuthController.java          # Endpoints de autenticação/login
│   ├── UsuarioController.java       # Endpoints de gerenciamento de usuários
│   └── AgendamentoController.java   # Endpoints para manipulação de agendamentos
│
├── dto                              # Objetos de Transferência de Dados (DTOs)
│   ├── LoginDTO.java
│   ├── TokenDTO.java
│   ├── UsuarioDTO.java
│   └── AgendamentoDTO.java
│
├── modelo                           # Entidades JPA mapeadas para as tabelas do banco
│   ├── Usuario.java
│   └── Agendamento.java
│
├── repository                       # Interfaces Spring Data JPA para acesso ao banco de dados
│   ├── UsuarioRepository.java
│   └── AgendamentoRepository.java
│
├── security                         # Componentes de autenticação e validação JWT
│   └── JwtFilter.java               # Filtro de segurança personalizado para tokens Bearer
│
├── service                          # Regras de negócio da aplicação
│   ├── AuthService.java
│   ├── UsuarioService.java
│   ├── AgendamentoService.java
│   └── JwtService.java              # Geração, assinatura e decodificação do JWT
│
└── exception
    └── GlobalExceptionHandler.java  # Tratador centralizado de exceções e erros de validação
