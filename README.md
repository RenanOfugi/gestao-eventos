#Projeto Gestão de Eventos

## Tecnologias Utilizadas

  1. Spring Boot - Framework para criação de API REST
  2. Lombok - Biblioteca redutor de código boilerplate
  3. Flyway - Biblioteca para controle e versionamento de migrates
  4. JPA - Biblioteca ORM para abstrair o mapeamento entre objeto e banco de dados
  5. Java 17
  6. PostgreSQL

## Como executar este projeto

  1. Tenha o java 17 instalado - jdk17
  2. Tenha o PostgreSQL instalado - qualquer versão mais recente
  3. No terminal, navegue até a pasta do projeto
  4. Modifique o arquivo .properties (**src/main/resources/application.properties**) com o username e password do postgresql usado na máquina.
  5. Execute o maven wrapper com o comando abaixo

```maven
./mvnw spring-boot:run

```

