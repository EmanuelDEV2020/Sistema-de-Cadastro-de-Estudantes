package com.fourcatsdev.entitycrud.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fourcatsdev.entitycrud.modelo.Estudante;
import java.util.List;


public interface EstudanteRespositorio extends JpaRepository<Estudante, Long> {
	List<Estudante> findByNomeContainingIgnoreCase(String nome);

}
