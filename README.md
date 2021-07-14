# Multiple Databases with Spring Boot Rest API [![GlueCatCode](https://circleci.com/gh/GlueCatCode/multiple-databases-spring-boot-rest-api.svg?style=shield)](https://app.circleci.com/pipelines/github/GlueCatCode/multiple-databases-spring-boot-rest-api)
Gerencie multiplos bancos de dados através do Spring Boot. Segue vídeo demonstrativo utilizando o banco Postgres:<br>
https://www.youtube.com/watch?v=SbbVKxIrb88

### Motivação
<div align="justify">
A principal motivação deste projeto no controle de múltiplas base de dados foi o baixo investimento de seu mantenedor no desenvolvimento da ferramenta, porém o único requisito não funcional acordado foi o uso da base de dados separada para cada cliente. Com a equipe extremamente reduzida, não foi possível a contratação de profissionais operacionais capacitados, como DevOps, para organização e integração contínua; dessa forma descartando até a utilização de uma estrutura disponível no mercado como AWS.<br>
A implantação da ferramenta foi por meio de servidor virtual privado, VPS, existindo aumento significativo no uso de memória, chegando a aumentar por volta de 1,5GB a cada cliente ou instância nova. A utilização deste projeto veio então sanar pontualmente esse problema que através de um código hash específico para cada cliente na requisição foi possível selecionar a base de dados desejada, utilizando ao invés de 1,5GB para cada cliente, uma média de 2GB para 8 clientes em uma só instância.<br>
A ferramenta criada por este projeto foi um B2B (Bussiness to Bussiness) que resumidamente disponibiliza entre pessoas jurídicas o comércio eletrônico em consideráveis quantidades, envolvendo: tabela de preços, filiais, políticas comerciais e grade de produto, como por exemplo: cor, estampa, tamanho.
</div>

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
