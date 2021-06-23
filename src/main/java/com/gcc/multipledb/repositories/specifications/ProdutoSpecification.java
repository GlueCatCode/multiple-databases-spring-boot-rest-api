package com.gcc.multipledb.repositories.specifications;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Path;

import org.springframework.data.jpa.domain.Specification;

import com.gcc.multipledb.entities.Produto;

public class ProdutoSpecification {
	
	public static <T> Specification<Produto> list(List<T> list,Class<T> clazz, String property ) {
		return (root, criteriaQuery, criteriaBuilder) -> {
			final Path<T> group = root.<T> get(property);
			return group.in(list);
		};
	}
	
	public static Specification<Produto> equalsToAnyId(Set<Integer> ids) {
	    return (root, query, builder) ->  builder.or(builder.in(root.get("id")).value(ids));
	}
	
	public static Specification<Produto> greaterThan(BigDecimal valor,String property ) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.greaterThanOrEqualTo(root.get(property), valor);		
	}
	
	public static Specification<Produto> lessThan(BigDecimal valor,String property ) {
		return (root, criteriaQuery, criteriaBuilder) -> 
		criteriaBuilder.lessThanOrEqualTo(root.get(property), valor);		
	}
	
	public static Specification<Produto> descricaoContains(String descricao) {
		return (root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.like(
				criteriaBuilder.upper(root.get("descricao")), "%" + descricao.toUpperCase() + "%");
	}
	
	public static Specification<Produto> ativo() {
		return (root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.equal(root.get("ativo"), true);
	}

}
