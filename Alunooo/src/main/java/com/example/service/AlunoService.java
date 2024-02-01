package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Aluno;
import com.example.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private final AlunoRepository AlunoRepository;

	@Autowired
	public AlunoService(AlunoRepository AlunoRepository) {
		this.AlunoRepository = AlunoRepository;
	}
	public List<Aluno> buscaTodosAlunos(){
		return AlunoRepository.findAll();
	}
	public Aluno buscaAlunoId(Long id) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		return existeAluno.orElse(null);
	}
	public Aluno salvaAluno(Aluno Aluno) {
		return AlunoRepository.save(Aluno);		
	}
	public Aluno alterarAluno(Long id, Aluno alterarAluno) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alterarAluno.setId(id);;
			return AlunoRepository.save(alterarAluno);
		}
		return null;
	}
	public boolean apagarAluno(Long id) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			AlunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}