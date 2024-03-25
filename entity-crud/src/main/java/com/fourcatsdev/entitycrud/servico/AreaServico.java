package com.fourcatsdev.entitycrud.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourcatsdev.entitycrud.modelo.Area;
import com.fourcatsdev.entitycrud.repositorio.AreaRepositorio;

@Service
public class AreaServico {
	
	@Autowired	
	private AreaRepositorio areaRepositorio;
	
	public Area gravar(Area area) {
		return areaRepositorio.save(area);
		
	}
	
	public List<Area> listar(){
		return areaRepositorio.findAll();
	}

}
