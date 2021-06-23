package com.gcc.multipledb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.gcc.multipledb.entities.types.UF;

import lombok.Data;

@Data
@Entity
@Table
public class Cidade {
	
	@NotNull
	@Id @Column
	private Integer id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@NotNull
	@Column
	private String nome;
		
	public Cidade(){}
	
	public Cidade(String id, String uf, String nome){
		this.id = Integer.parseInt(id);
		this.uf = UF.valueOf(uf);
		this.nome = nome;
	}
	
	//https://www.ibge.gov.br/explica/codigos-dos-municipios.php
	//DTB_2018.zip
	//RELATORIO_DTB_BRASIL_MUNICIPIO.ods
	//=CONCAT("cidades.add(new Cidade(", B2, ", ", A2, ", """, C2,"""));")
	//=CONCAT("new Cidade(", B2, ", ", A2, ", """, C2,""") + "", "" +")
	public Cidade(Integer id, Integer numUf, String nome){
		
		switch(numUf) {
			case 12: uf = UF.AC; break; //Acre - 12
			case 27: uf = UF.AL; break; //Alagoas - 27
			case 16: uf = UF.AP; break; //Amapá - 16
			case 13: uf = UF.AM; break; //Amazonas - 13
			case 29: uf = UF.BA; break; //Bahia - 29
			case 23: uf = UF.CE; break; //Ceará - 23
			case 53: uf = UF.DF; break; //Distrito Federal - 53
			case 32: uf = UF.ES; break; //Espírito Santo - 32
			case 52: uf = UF.GO; break; //Goiás - 52
			case 21: uf = UF.MA; break; //Maranhão - 21
			case 51: uf = UF.MT; break; //Mato Grosso - 51
			case 50: uf = UF.MS; break; //Mato Grosso do Sul - 50
			case 31: uf = UF.MG; break; //Minas Gerais - 31
			case 15: uf = UF.PA; break; //Pará - 15
			case 25: uf = UF.PB; break; //Paraíba - 25
			case 41: uf = UF.PR; break; //Paraná - 41
			case 26: uf = UF.PE; break; //Pernambuco - 26
			case 22: uf = UF.PI; break; //Piauí - 22
			case 24: uf = UF.RN; break; //Rio Grande do Norte - 24
			case 43: uf = UF.RS; break; //Rio Grande do Sul - 43
			case 33: uf = UF.RJ; break; //Rio de Janeiro - 33
			case 11: uf = UF.RO; break; //Rondônia - 11
			case 14: uf = UF.RR; break; //Roraima - 14
			case 42: uf = UF.SC; break; //Santa Catarina - 42
			case 35: uf = UF.SP; break; //São Paulo - 35
			case 28: uf = UF.SE; break; //Sergipe - 28
			case 17: uf = UF.TO; break; //Tocantins - 17
		}
		
		this.id = id;
		this.nome = nome;
	}
	
	@Override
    public String toString() { 
		return "(" + id + ", '" + uf.toString() + "', '" + nome.replace("'", "''") + "')";
	}

}
