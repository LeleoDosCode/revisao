package com.example.entities;

import com.example.entities.Aluno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(name = "Nome")
	private String nome;
	
	@NotNull
	@Column(name = "CPF")
	private String cpf;
	
	@NotNull
	@Column(name ="RG")
	private String rg;
	
	@NotNull
	@NotBlank
	@Column(name ="Endereco")
	private String endereco;
	
	@NotNull
	@NotBlank
	@Column(name ="Email")
	private String email;
}
