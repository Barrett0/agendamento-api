# 💈 Agendamento API

API REST desenvolvida com Java e Spring Boot para gerenciamento de agendamentos de uma barbearia.

O sistema permite o cadastro de usuários, autenticação via JWT e gerenciamento de agendamentos através de endpoints protegidos.

---

# 🚀 Tecnologias Utilizadas

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* PostgreSQL
* Maven
* Swagger / OpenAPI
* Hibernate

---

# 📋 Descrição do Sistema

Esta API foi desenvolvida para automatizar o processo de agendamento de serviços em uma barbearia.

O sistema permite:

* Cadastro de usuários
* Autenticação com JWT
* Criação de agendamentos
* Consulta de agendamentos
* Atualização de agendamentos
* Exclusão de agendamentos
* Proteção de rotas através de autenticação

---

# ⚙️ Funcionalidades Disponíveis

## Usuários

* Criar usuário
* Listar usuários
* Buscar usuário por ID
* Atualizar usuário
* Excluir usuário

## Autenticação

* Login com e-mail e senha
* Geração de Token JWT
* Proteção de endpoints

## Agendamentos

* Criar agendamento
* Listar agendamentos
* Buscar agendamento por ID
* Atualizar agendamento
* Excluir agendamento

---

# 📁 Estrutura do Projeto

```text
src/main/java
│
├── controller
│   ├── AgendamentoController
│   ├── UsuarioController
│   └── AuthController
│
├── service
│   ├── AgendamentoService
│   ├── UsuarioService
│   ├── AuthService
│   └── JwtService
│
├── repository
│   ├── AgendamentoRepository
│   └── UsuarioRepository
│
├── modelo
│   ├── Agendamento
│   └── Usuario
│
├── dto
│   ├── AgendamentoDTO
│   ├── UsuarioDTO
│   ├── LoginDTO
│   └── TokenDTO
│
├── security
│   └── JwtFilter
│
├── config
│   └── SecurityConfig
│
└── exception
    └── GlobalExceptionHandler
```

---

# 🛠️ Como Instalar e Executar Localmente

## 1. Clonar o repositório

```bash
git clone https://github.com/SEU-USUARIO/agendamento-api.git
```

```bash
cd agendamento-api
```

---

## 2. Configurar o PostgreSQL

Crie um banco de dados:

```sql
CREATE DATABASE agendamento_db;
```

---

## 3. Configurar application.properties

Arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agendamento_db
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
```

---

## 4. Executar o projeto

Pelo Eclipse:

```text
Run As → Spring Boot App
```

Ou pelo terminal:

```bash
mvn spring-boot:run
```

---

# 🗄️ Configuração do Banco PostgreSQL

Instale o PostgreSQL:

https://www.postgresql.org/download/

Criar banco:

```sql
CREATE DATABASE agendamento_db;
```

Verificar conexão:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agendamento_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

---

# 🔐 Autenticação JWT

O sistema utiliza autenticação baseada em JWT.

Fluxo:

1. Usuário realiza login
2. API gera Token JWT
3. Token é enviado nas requisições protegidas

Exemplo:

```http
Authorization: Bearer SEU_TOKEN
```

---

# 📡 Endpoints da API

## Autenticação

### Login

```http
POST /auth/login
```

Request:

```json
{
  "email": "usuario@email.com",
  "senha": "123456"
}
```

Response:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## Usuários

### Criar usuário

```http
POST /usuarios
```

Request:

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456"
}
```

Response:

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

---

### Listar usuários

```http
GET /usuarios
```

---

### Buscar usuário por ID

```http
GET /usuarios/{id}
```

---

### Atualizar usuário

```http
PUT /usuarios/{id}
```

---

### Excluir usuário

```http
DELETE /usuarios/{id}
```

---

## Agendamentos

### Criar agendamento

```http
POST /agendamentos
```

Request:

```json
{
  "cliente": "João Silva",
  "servico": "Corte Degradê",
  "data": "2026-06-10",
  "horario": "14:00"
}
```

Response:

```json
{
  "id": 1,
  "cliente": "João Silva",
  "servico": "Corte Degradê",
  "data": "2026-06-10",
  "horario": "14:00"
}
```

---

### Listar agendamentos

```http
GET /agendamentos
```

---

### Buscar agendamento por ID

```http
GET /agendamentos/{id}
```

---

### Atualizar agendamento

```http
PUT /agendamentos/{id}
```

---

### Excluir agendamento

```http
DELETE /agendamentos/{id}
```

---

# 🧪 Como Testar no Postman

## 1. Criar usuário

```http
POST /usuarios
```

---

## 2. Fazer login

```http
POST /auth/login
```

Copie o token retornado.

---

## 3. Adicionar token

Em todas as rotas protegidas:

```http
Authorization
Bearer Token
```

Cole o token JWT.

---

## 4. Testar endpoints

```http
GET /agendamentos
POST /agendamentos
PUT /agendamentos/{id}
DELETE /agendamentos/{id}
```

---

# 📚 Swagger/OpenAPI

Após iniciar a aplicação:

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

Documentação OpenAPI:

```text
http://localhost:8080/v3/api-docs
```

---

# ☁️ Deploy

A aplicação pode ser hospedada em plataformas como:

* Render
* Railway
* AWS
* Azure
* Google Cloud

Deploy recomendado:

Render + PostgreSQL

---

# 🔮 Melhorias Futuras

* Cadastro de barbeiros
* Controle de horários disponíveis
* Cancelamento de agendamentos
* Recuperação de senha
* Confirmação por e-mail
* Dashboard administrativo
* Controle de permissões (ADMIN/USER)
* Docker
* Testes automatizados
* CI/CD com GitHub Actions

---

# 👨‍💻 Autor

Bruno Barretto

Desenvolvedor Back-End Java

---

⭐ Se este projeto foi útil para você, deixe uma estrela no repositório.
