[![GlueCatCode](https://circleci.com/gh/GlueCatCode/multiple-databases-spring-boot-rest-api.svg?style=shield)](https://github.com/GlueCatCode/multiple-databases-spring-boot-rest-api)

# Multiple Databases with Spring Boot Rest API
Gerencie multiplos bancos de dados através do Spring Boot. Segue vídeo demonstrativo utilizando o banco Postgres:<br>
https://www.youtube.com/watch?v=SbbVKxIrb88

### Observações
- O parêmetro header para as requisições é hash-multipledb;  
![Screenshot 2021-06-25 163652](https://user-images.githubusercontent.com/26276218/123476907-b2d43700-d5d3-11eb-9f5e-410fed3ea0cc.png)
- Para testar crie os bancos de dados antes de rodar a aplicação;

### Melhorias / Bugs
- Uma classe PrincipalView foi criada como um DTO para facilitar o controller e demais testes;
- Classe MultipleDbApplicationTests implementada para realização de testes em (http://localhost:8000/principal) validando o retorno do wrapper PrincipalView;
