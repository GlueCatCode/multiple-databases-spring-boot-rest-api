package com.gcc.multipledb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gcc.multipledb.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByLogin(String login);
	
	@Query("select u from Usuario u where u.id not in (1, -1000) and (lower(u.nome) like :busca or lower(u.login) like :busca)")
	List<Usuario> getUsuarios(Pageable pageable, String busca);
	
	@Query("select u.login from Usuario u where u.id not in (1, -1000) and u.tipo in ('ADMINISTRADOR', 'GESTOR')")
	List<String> getEmailAdminGestores();
	
}
