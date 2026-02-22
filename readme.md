📦 CRUD com Spring Boot

Este projeto é uma API REST desenvolvida com Spring Boot, implementando operações completas de CRUD (Create, Read, Update, Delete) para gerenciamento de usuários.

O objetivo deste projeto é demonstrar a construção de uma API backend seguindo boas práticas de arquitetura, utilizando camadas bem definidas, DTOs, tratamento de exceções e integração com banco de dados relacional.

🚀 Tecnologias utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Hibernate

MySQL

Maven

Bean Validation

REST API

🧠 Funcionalidades implementadas

A API permite:

✅ Criar um usuário

Salva um novo usuário no banco de dados.

POST /usuarios
✅ Buscar todos os usuários

Retorna uma lista de usuários cadastrados.

GET /usuarios
✅ Buscar usuário por ID

Retorna um usuário específico.

GET /usuarios/{id}
✅ Atualizar usuário

Atualiza os dados de um usuário existente.

PUT /usuarios/{id}
✅ Deletar usuário

Remove um usuário do banco de dados.

DELETE /usuarios/{id}

🧱 Arquitetura do projeto

O projeto segue o padrão de arquitetura em camadas:

controller → recebe as requisições HTTP

service → contém a lógica de negócio

repository → comunicação com o banco de dados

entity → representa a tabela do banco

dto → objeto de transferência de dados

exception → exceções personalizadas

handler → tratamento global de exceções


🔄 Fluxo de funcionamento

Exemplo de fluxo ao criar um usuário:

Client → Controller → Service → Repository → Database

O Service é responsável pela lógica e o Repository pela persistência.

📊 Exemplo de requisição

POST /usuarios
{
  "nome": "Nathã"
}

Resposta:

{
  "id": 1,
  "nome": "Nathã"
}

⚙️ Como executar o projeto

1. Clone o repositório
git clone https://github.com/NathaRosa/CRUD-Springboot.git

2. Configure o banco de dados

No arquivo:

application.properties

Configure:

spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update

3. Execute o projeto

No terminal:

./mvnw spring-boot:run

ou execute pela sua IDE.


🌐 A API estará disponível em
http://localhost:8080/usuarios


🎯 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de:

Praticar desenvolvimento backend com Spring Boot

Entender a arquitetura em camadas

Implementar uma API REST completa

Trabalhar com persistência de dados usando JPA

Aplicar boas práticas de desenvolvimento

👨‍💻 Autor

Nathã Rogério Rosa

GitHub:
https://github.com/NathaRosa

LinkedIn:
https://www.linkedin.com/in/nath%C3%A3-rosa-b3b656211/

⭐ Possíveis melhorias futuras

Implementar autenticação com Spring Security

Adicionar paginação

Implementar testes com JUnit

Documentação com Swagger

Integração com frontend Angular