package com.fourcatsdev.entitycrud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fourcatsdev.entitycrud.modelo.Area;

public interface AreaRepositorio extends JpaRepository<Area, Long> {

}
