package br.com.prestacaocontascampanhaeleitoral.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
	Page<Candidato> findByNomeContaining(String nome, Pageable pageable);
}
