package br.com.prestacaocontascampanhaeleitoral.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;
import br.com.prestacaocontascampanhaeleitoral.domain.Receita;
import br.com.prestacaocontascampanhaeleitoral.dto.ReceitaDTO;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

	
	public List<ReceitaDTO> findTotalByCandidato(Integer candidatoId);
	
	
	public List<Receita> findByCandidatura_candidatoAndCandidatura_ano(Candidato candidato, Integer ano);
}
