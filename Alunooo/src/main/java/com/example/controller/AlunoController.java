package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Aluno;
import com.example.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Aluno")
public class AlunoController {

	private final AlunoService AlunoService;

	@Autowired
	public AlunoController(AlunoService AlunoService) {
		this.AlunoService = AlunoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id){
		Aluno Aluno  = AlunoService.buscaAlunoId(id);
		if(Aluno != null) {
			return ResponseEntity.ok(Aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Aluno>> buscaTodosAlunosControl(){
		List<Aluno> Alunos = AlunoService.buscaTodosAlunos();
		return ResponseEntity.ok(Alunos);
	}

	@PostMapping
	public ResponseEntity<Aluno> salvaAlunosControl(@RequestBody @Valid Aluno Aluno){
		Aluno salvaAluno = AlunoService.salvaAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody @Valid Aluno Aluno){
		Aluno alteraAluno = AlunoService.alterarAluno(id, Aluno);
		if(alteraAluno != null) {
			return ResponseEntity.ok(Aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){
		boolean apagar = AlunoService.apagarAluno(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Aluno foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
