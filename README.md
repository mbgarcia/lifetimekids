# LifetimeKids

LifetimeKids é um aplicativo que pode ser utilizado para registrar alguns momentos da vida da criança:

* eventos: Em 10/10/2016 - João deu os primeiros passos
* as medidas em determinado dia

### Tecnologias utilizadas:

LifetimeKids está sendo desenvolvido com:

* SpringBoot
* SpringMVC
* Thymeleaf
* Gradle
* SpringToolSuite (STS)
* Twitter Bootstrap

Além disso, a idéia é desenvolver utilizando TDD. Para isso, adotou-se o framework de testes do próprio Spring.

### Parametrizando a conexao com o banco de dados.
    
No Heroku, o parametro de conexao com o banco de dados eh JDBC_DATABASE_URL, que eh utilizado no application.properties.
    
Localmente, eh preciso criar uma variavel de ambiente com este nome:
    
export DATABASE_URL='jdbc:postgresql://localhost:5432/lifetimekids?user=<user>&password=<password>'
    
Link: https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku#connecting-to-a-database
    
No eclipse, variaveis de ambiente sao criadas em:
  . Run -> Run Configurations -> Environment
    
Na secao de variaveis criar uma da seguinte forma:
  JDBC_DATABASE_URL='jdbc:postgresql://localhost:5432/lifetimekids?user=<user>&password=<password>'
