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
```

---

## ⚙️ Variáveis de Ambiente e Configuração

O arquivo `src/main/resources/application.properties` está parametrizado para utilizar variáveis de ambiente, com fallbacks adequados para desenvolvimento local:

| Variável | Descrição | Valor Padrão (Local) |
| :--- | :--- | :--- |
| `PORT` | Porta onde a API será executada | `8080` |
| `SPRING_DATASOURCE_URL` | URL de conexão com o banco PostgreSQL | `jdbc:postgresql://localhost:5432/agendamento_db` |
| `SPRING_DATASOURCE_USERNAME` | Usuário do banco de dados | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Senha do banco de dados | `post` |
| `SPRING_JPA_HIBERNATE_DDL_AUTO` | Modo de inicialização do DDL | `update` |
| `JWT_SECRET` | Chave secreta de assinatura dos tokens JWT | `barretto-agendamento-api` |

---

## 🚀 Como Executar Localmente

### Pré-requisitos
* Java 21 JDK instalado.
* PostgreSQL instalado e rodando.
* Maven instalado (ou use o wrapper incluso `./mvnw`).

### Passo 1: Configurar o Banco de Dados
No seu terminal PostgreSQL ou ferramenta cliente (pgAdmin, DBeaver, etc.), crie o banco de dados:
```sql
CREATE DATABASE agendamento_db;
```

### Passo 2: Clonar o Repositório
```bash
git clone https://github.com/SEU-USUARIO/agendamento-api.git
cd agendamento-api
```

### Passo 3: Executar a Aplicação
Você pode rodar diretamente pela sua IDE (como Eclipse/STS - clicando com o botão direito no projeto e selecionando **Run As → Spring Boot App**) ou pelo terminal:

```bash
# No Windows:
.\mvnw spring-boot:run

# No Linux/macOS:
chmod +x mvnw
./mvnw spring-boot:run
```

A aplicação iniciará na porta `8080`.

---

## 📚 Documentação e Testes (Swagger)

Com o servidor local em execução, acesse as rotas abaixo para explorar e testar a API de forma interativa:

* **Swagger UI (Documentação Interativa)**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* **OpenAPI Docs (JSON bruto)**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

> [!TIP]
> Graças ao nosso `HomeController`, acessar simplesmente **`http://localhost:8080/`** redirecionará você de forma automática para o Swagger UI!

---

## 🔐 Fluxo de Autenticação JWT

Para as rotas privadas (`/agendamentos` e listagens/alterações de `/usuarios`), você precisa seguir o fluxo de autenticação:

1. **Cadastre um Usuário**:
   * Faça uma requisição `POST` para `/usuarios` (público) passando nome, e-mail e senha.
2. **Faça Login**:
   * Faça uma requisição `POST` para `/auth/login` (público) passando o e-mail e senha cadastrados.
   * A API retornará um token JWT no formato JSON: `{"token": "eyJhbGciOiJIUzI1NiJ9..."}`.
3. **Autentique as Requisições**:
   * Adicione o cabeçalho HTTP `Authorization` nas próximas requisições protegidas:
     ```http
     Authorization: Bearer <seu_token_jwt_aqui>
     ```

---

## 📡 Endpoints Disponíveis

### Autenticação (`/auth`)
* `POST /auth/login` - Autentica usuário e retorna token JWT.

### Usuários (`/usuarios`)
* `POST /usuarios` - Cria um novo usuário (Rota pública).
* `GET /usuarios` - Lista todos os usuários (Requer JWT).
* `GET /usuarios/{id}` - Detalha usuário por ID (Requer JWT).
* `PUT /usuarios/{id}` - Atualiza dados do usuário (Requer JWT).
* `DELETE /usuarios/{id}` - Exclui usuário (Requer JWT).

### Agendamentos (`/agendamentos`) (Requer JWT)
* `POST /agendamentos` - Cria um novo agendamento.
* `GET /agendamentos` - Lista todos os agendamentos cadastrados.
* `GET /agendamentos/{id}` - Detalha agendamento por ID.
* `PUT /agendamentos/{id}` - Atualiza agendamento.
* `DELETE /agendamentos/{id}` - Cancela/Exclui agendamento.

---

## ☁️ Deploy na Nuvem (Ex: Render)

Para subir o projeto no Render (ou plataformas semelhantes):

1. **Crie um Banco de Dados PostgreSQL** na plataforma.
2. **Crie um Web Service** apontando para o seu repositório GitHub.
3. Defina o **Build Command**: `mvn clean package -DskipTests` (ou utilize o `Dockerfile` que está na raiz do projeto).
4. Defina o **Start Command**: `java -jar target/agendamento-0.0.1-SNAPSHOT.jar` (se usar build do Maven padrão).
5. Configure as seguintes **Environment Variables** nas opções do Web Service:
   * `SPRING_DATASOURCE_URL`: A URL de conexão externa fornecida pelo banco criado.
   * `SPRING_DATASOURCE_USERNAME`: O usuário do banco de dados.
   * `SPRING_DATASOURCE_PASSWORD`: A senha do banco de dados.
   * `JWT_SECRET`: Uma senha forte e segura para criptografar os tokens JWT.
   * `SPRING_JPA_HIBERNATE_DDL_AUTO`: `update`

---

## 👨‍💻 Autor

* **Bruno Barretto** - [LinkedIn](https://www.linkedin.com/in/bruno-barretto/) | [GitHub](https://github.com/BrunoBarretto)

---
⭐ Deixe uma estrela se esse projeto foi útil!

