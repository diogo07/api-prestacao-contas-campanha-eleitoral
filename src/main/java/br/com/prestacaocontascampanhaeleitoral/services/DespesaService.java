package br.com.prestacaocontascampanhaeleitoral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;
import br.com.prestacaocontascampanhaeleitoral.domain.Despesa;
import br.com.prestacaocontascampanhaeleitoral.dto.DespesaCategoriaDTO;
import br.com.prestacaocontascampanhaeleitoral.dto.DespesaDTO;
import br.com.prestacaocontascampanhaeleitoral.repositories.DespesaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private CandidatoService candidatoService;
	
	public List<DespesaDTO> findTotalByCandidato(Integer candidatoId) {
		return despesaRepository.findTotalByCandidato(candidatoId);
	}
	
	public List<DespesaCategoriaDTO> findByCandidatoAndAnoGroupByTipo(Integer candidatoId, Integer ano) {
		return despesaRepository.findByCandidatoAndAnoGroupByTipo(candidatoId, ano);
	}
	
	public List<Despesa> findByCandidatoAndAno(Integer candidatoId, Integer ano) throws ObjectNotFoundException {
		Candidato candidato = candidatoService.findById(candidatoId);		
		return despesaRepository.findByCandidatura_candidatoAndCandidatura_ano(candidato, ano);
	}
}
