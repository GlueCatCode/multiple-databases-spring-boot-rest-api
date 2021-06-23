package com.gcc.multipledb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gcc.multipledb.entities.Cliente;
import com.gcc.multipledb.entities.types.TipoDocumento;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("select c from Cliente c join c.usuarios u where c.ativo = true and u.id = :userId and ( lower(c.nome) like :busca or lower(c.fantasia) like :busca or c.numDocumento like :busca or c.codigo like :busca )")
	List<Cliente> getClientesByUser(Pageable pageable, Integer userId, String busca);
	
	@Query("select c from Cliente c where c.ativo = true and lower(c.nome) like :busca or lower(c.fantasia) like :busca or c.numDocumento like :busca or c.codigo like :busca")
	List<Cliente> getClientes(Pageable pageable, String busca);
	
	Optional<Cliente> findByIdErp(Integer idErp);
	
	@Query("SELECT COUNT(c.id) FROM Cliente c WHERE c.email=:email")
	Long countClientesWithEmail(String email);
	
	Optional<Cliente> findByNumDocumento(String numDocumento);
	
	@Query("select c from Cliente c where c.idErp = :idErp or (c.tipoDocumento = :tipoDocumento and c.numDocumento = :numDocumento)")
	List<Cliente> findByExiste(Integer idErp, TipoDocumento tipoDocumento, String numDocumento);

	List<Cliente> findByIdErpIsNullAndRegistroIsNull();
		
}
