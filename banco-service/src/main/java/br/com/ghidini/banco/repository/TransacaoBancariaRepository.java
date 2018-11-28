package br.com.ghidini.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ghidini.banco.model.TransacaoBancaria;

@Repository
public interface TransacaoBancariaRepository extends JpaRepository<TransacaoBancaria, Long>{
	

}
