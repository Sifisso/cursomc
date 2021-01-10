package com.sifissomuianga.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifissomuianga.cursomc.domain.Categoria;
import com.sifissomuianga.cursomc.repositories.CategoriaRepository;
import com.sifissomuianga.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
