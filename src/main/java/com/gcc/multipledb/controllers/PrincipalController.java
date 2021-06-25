package com.gcc.multipledb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcc.multipledb.entities.Filial;
import com.gcc.multipledb.entities.FormaPagamento;
import com.gcc.multipledb.entities.Usuario;
import com.gcc.multipledb.repositories.FilialRepository;
import com.gcc.multipledb.repositories.FormaPagamentoRepository;
import com.gcc.multipledb.repositories.UsuarioRepository;
import com.gcc.multipledb.views.PrincipalView;

@RestController
@RequestMapping("/principal")
public class PrincipalController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private FilialRepository filialRepository;
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@GetMapping
	public ResponseEntity<?> principal(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Filial> filiais = filialRepository.findAll();
		List<FormaPagamento> formasDePagamento = formaPagamentoRepository.findAll();
		PrincipalView view = new PrincipalView(usuarios, filiais, formasDePagamento);
		return ResponseEntity.ok().body(view);
	}
	
}
