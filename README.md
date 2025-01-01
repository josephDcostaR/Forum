# Forum_alura

**Forum_alura** é uma API REST desenvolvida em Java, projetada para simular o funcionamento de um fórum online. Este projeto foi criado como parte da formação backend com Java Spring oferecida pela Oracle Next Education em parceria com a Alura.

---

## Funcionalidades

### Gerenciamento de Usuários
- **Cadastro:** Permite o registro de novos usuários.
- **Login:** Autenticação segura utilizando JWT.
- **Listagem:** Exibe todos os usuários cadastrados.

### Gerenciamento de Tópicos
- **CRUD de Tópicos:** Criação, listagem, edição e exclusão de tópicos.
- **Respostas:** Possibilita que usuários adicionem respostas a tópicos, atualizando automaticamente seu status.

### Segurança
- **JWT (JSON Web Token):** Sistema de autenticação robusto baseado em tokens.

### Documentação Interativa
- **Swagger:** Proporciona acesso à documentação interativa para exploração e teste das rotas da API.

---

## Configuração do Ambiente

### Requisitos
- Java 17
- Maven
- MySQL

### Passos para Configuração
1. **Clone o repositório:**
   ```bash
   https://github.com/josephDcostaR/Forum
   cd Forum
   ```
2. **Configure o banco de dados:**
   - Crie um banco chamado `forumhub`.
   - Atualize as configurações no arquivo `application.properties` ou `application.yml`.

3. **Execute as migrações do Flyway:**
   ```bash
   mvn flyway:migrate
   ```

4. **Compile e inicie a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a documentação interativa:**
   - URL: `http://localhost:8080/swagger-ui.html`

---

## Endpoints Principais

### Usuários
- **POST /login:** Gera um token JWT para autenticação.
- **GET /usuarios:** Lista todos os usuários cadastrados.
- **POST /usuarios:** Registra um novo usuário.
- **PUT /usuarios:** Atualiza nome e senha do usuário autenticado.
- **DELETE /usuarios:** Realiza um delete lógico, tornando o usuário inativo.
- **GET /usuarios/topicos:** Lista os tópicos criados pelo usuário autenticado, paginados em 10 itens.

### Tópicos
- **GET /topicos:** Lista todos os tópicos do fórum, paginados em 10 itens.
- **POST /topicos:** Cria um novo tópico.
- **GET /topicos/{id}:** Detalha um tópico específico.
- **PUT /topicos/{id}:** Atualiza um tópico pelo ID (se criado pelo usuário autenticado).
- **DELETE /topicos/{id}:** Exclui um tópico pelo ID (se criado pelo usuário autenticado).

### Respostas
- **POST /respostas/{id}:** Adiciona uma resposta a um tópico. Atualiza o status do tópico automaticamente.
- **PUT /respostas/{id}:** Atualiza uma resposta específica pelo ID.
- **DELETE /respostas/{id}:** Remove uma resposta pelo ID. Caso seja a última resposta, o status do tópico retorna para `NAO_RESPONDIDO`.

> Consulte a documentação do Swagger para mais detalhes sobre os dados enviados e recebidos em cada endpoint.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **Flyway**
- **MySQL**
- **Hibernate**
- **Spring Data JPA**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Lombok**
- **Swagger**

---

## Contribuições
Contribuições são muito bem-vindas! Para colaborar:
1. Faça um fork do repositório.
2. Crie uma branch para sua funcionalidade ou correção: `git checkout -b minha-feature`.
3. Envie suas alterações: `git push origin minha-feature`.
4. Abra um pull request para revisão.

---

Desenvolvido com 💻 por Joas Barros como parte da formação em backend da Oracle Next Education.
