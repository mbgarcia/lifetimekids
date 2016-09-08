LifetimeKids

Parametrizando a conexao com o banco de dados.
    
No Heroku, o parametro de conexao com o banco de dados eh JDBC_DATABASE_URL, que eh utilizado no application.properties.
    
Localmente, eh preciso criar uma variavel de ambiente com este nome:
    
export DATABASE_URL='jdbc:postgresql://localhost:5432/lifetimekids?user=<user>&password=<password>'
    
Link: https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku#connecting-to-a-database
    
No eclipse, variaveis de ambiente sao criadas em:
  . Run -> Run Configurations -> Environment
    
Na secao de variaveis criar uma da seguinte forma:
  JDBC_DATABASE_URL='jdbc:postgresql://localhost:5432/lifetimekids?user=<user>&password=<password>'
