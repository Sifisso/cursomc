package com.sifissomuianga.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifissomuianga.cursomc.domain.Categoria;
import com.sifissomuianga.cursomc.domain.Cliente;
import com.sifissomuianga.cursomc.repositories.ClienteRepository;
import com.sifissomuianga.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
