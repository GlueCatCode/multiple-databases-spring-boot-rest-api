# Multiple Databases with Spring Boot Rest API [![GlueCatCode](https://circleci.com/gh/GlueCatCode/multiple-databases-spring-boot-rest-api.svg?style=shield)](https://app.circleci.com/pipelines/github/GlueCatCode/multiple-databases-spring-boot-rest-api)
Gerencie multiplos bancos de dados através do Spring Boot. Segue vídeo demonstrativo utilizando o banco Postgres:<br>
https://www.youtube.com/watch?v=SbbVKxIrb88

### Configurações
![Screenshot 2021-06-25 164355](https://user-images.githubusercontent.com/26276218/123477581-a1d7f580-d5d4-11eb-82f4-e4aec09a9e5e.png)<br>
**gcc.databases** - Bancos de dados separados por vírgula<br>
**gcc.hostdb** - Host dos bancos de dados<br>
**gcc.userdb** - User dos bancos de dados<br>
**gcc.passdb** - Password dos bancos de dados<br> 
**gcc.entities** - Pacotes de entidades para ser escaneado pelo entity manager separados por vírgula<br>
**gcc.hash.\*** - Hash de acesso através da requisição para cada do banco de dados<br>
**gcc.pool.initial-size** - Número de conexões serão estabilizadas quando o pool de conexão for iniciado<br>
**gcc.pool.max-active** - Número máximo de conexões ativas que podem ser alocadas no pool ao mesmo tempo<br>
**gcc.pool.max-idle** - Número máximo de conexões que devem ser mantidas no pool ocioso 

### Observações
- O parêmetro header para as requisições é hash-multipledb;  
![Screenshot 2021-06-25 163652](https://user-images.githubusercontent.com/26276218/123476907-b2d43700-d5d3-11eb-9f5e-410fed3ea0cc.png)
- Note que este hash irá trafegar pela intenet, então evite caracteres especiais;
- Para testar crie os bancos de dados antes de rodar a aplicação;

### Melhorias / Bugs
- [x] Criar DTO, PrincipalView, para facilitar o controller e demais testes;
- [x] Implementar testes em MultipleDbApplicationTests, para validar o retorno do wrapper PrincipalView;
- [ ] Melhorar integração contínua pelo CircleCi, informar imagem de banco de dados para realizar os testes;
