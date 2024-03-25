package com.fourcatsdev.entitycrud.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourcatsdev.entitycrud.excecao.EstudanteNotFoundException;
import com.fourcatsdev.entitycrud.modelo.Estudante;
import com.fourcatsdev.entitycrud.repositorio.EstudanteRespositorio;

@Service
public class EstudanteServico {
	
	@Autowired
	private EstudanteRespositorio estudanteRepositorio;
	
	public Estudante criarEstudante(Estudante estudante) {
		return estudanteRepositorio.save(estudante);
	}

	public List<Estudante> buscarTodosEstudante(Estudante estudante) {
		return estudanteRepositorio.findAll();
	}
	
	public Estudante buscarEstudantePorId(Long id) throws EstudanteNotFoundException {
		Optional<Estudante> opt = estudanteRepositorio.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new EstudanteNotFoundException("Estudante com id : " + id + " não existe");
		}		
	}
	
	public void apagarEstudante(Long id) throws EstudanteNotFoundException {
		Estudante estudante = buscarEstudantePorId(id);
		estudanteRepositorio.delete(estudante);
	}
	
	public Estudante alterarEstudante(Estudante estudante) {
		return estudanteRepositorio.save(estudante);
	}
	
	public List<Estudante> buscarTodosEstudantePorNome(String  nome) {
		return estudanteRepositorio.findByNomeContainingIgnoreCase(nome);
	}
	


	

}
