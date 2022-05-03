package org.generation.lojadegames1.repository;

import java.util.List;

import org.generation.lojadegames1.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>{
	public List<Categorias> findAllByNomeContainingIgnoreCase(String nome);
}
