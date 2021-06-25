package com.gcc.multipledb.views;

import java.util.List;

import com.gcc.multipledb.entities.Filial;
import com.gcc.multipledb.entities.FormaPagamento;
import com.gcc.multipledb.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrincipalView {
	
	private List<Usuario> usuarios;
	private List<Filial> filiais;
	private List<FormaPagamento> formasDePagamento;
	
}
