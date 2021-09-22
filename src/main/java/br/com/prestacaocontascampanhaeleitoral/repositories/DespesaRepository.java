package br.com.prestacaocontascampanhaeleitoral.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;
import br.com.prestacaocontascampanhaeleitoral.domain.Despesa;
import br.com.prestacaocontascampanhaeleitoral.dto.DespesaCategoriaDTO;
import br.com.prestacaocontascampanhaeleitoral.dto.DespesaDTO;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer>{

	
	public List<DespesaDTO> findTotalByCandidato(Integer candidatoId);

	
	public List<DespesaCategoriaDTO> findByCandidatoAndAnoGroupByTipo(Integer candidatoId, Integer ano);
	
	
	public List<Despesa> findByCandidatura_candidatoAndCandidatura_ano(Candidato candidato, Integer ano);
}
