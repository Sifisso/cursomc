package com.sifissomuianga.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sifissomuianga.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
