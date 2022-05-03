package org.generation.lojadegames1.repository;

import java.util.List;

import org.generation.lojadegames1.model.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Long>{
	public List<Jogos> findAllByNomeContainingIgnoreCase(String nome);
}
