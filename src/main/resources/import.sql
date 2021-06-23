INSERT INTO public.usuario (id,ativo,login,nome,senha,tipo) VALUES
(-1000,true,'adminagilb2b','Administrador Master','$2a$10$zy41p4zgvGQ7n2hJFUa9IUWuLmVhjrpwZs2wdx0ZvW1LeRhpKEs1rCS','ADMINISTRADOR'),
(1,true,'admin','Administrador','$2a1$10$MXVrYYNyX02LbTkj1YM3dhOur.XlbhP5qwozdrZogmpfzgoZEeoBOK6','GESTOR');

create index idx_estoque_produto on estoque(produto);
create index idx_estoque_filial on estoque(filial);
create index idx_preco_produto on preco(produto);
create index idx_preco_tabela on preco(tabela);
create index idx_produto_categoria on produto(categoria);
create index idx_produto_colecao on produto(colecao);
create index idx_produto_departamento on produto(departamento);
create index idx_produto_divisao on produto(divisao);
create index idx_produto_grupo on produto(grupo);
create index idx_produto_marca on produto(marca);
create index idx_produto_tipo on produto(tipo);

create or replace view vw_estoque as
select 
	x.cor, x.estampa, x.filial, x.produto, x.tamanho, greatest(sum(x.quantidade),0) as quantidade 
from(
	select 
		e.cor, e.estampa, e.filial, e.produto, e.tamanho, e.quantidade
   	from estoque e
	union all
	select 
		pi.cor, pi.estampa, p.filial, pi.produto, pi.tamanho,-1 * pi.quantidade 
	from pedido_item pi inner join pedido p on (p.id = pi.pedido and p.status != 'ABERTO')
) x
group by 
	x.cor, x.estampa, x.filial, x.produto, x.tamanho;
