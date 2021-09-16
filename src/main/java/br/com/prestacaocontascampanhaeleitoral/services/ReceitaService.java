package br.com.prestacaocontascampanhaeleitoral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;
import br.com.prestacaocontascampanhaeleitoral.domain.Receita;
import br.com.prestacaocontascampanhaeleitoral.dto.ReceitaDTO;
import br.com.prestacaocontascampanhaeleitoral.repositories.ReceitaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private CandidatoService candidatoService;
	
	public List<ReceitaDTO> findTotalByCandidato(Integer candidatoId) {
		return receitaRepository.findTotalByCandidato(candidatoId);
	}
	
	public List<Receita> findByCandidatoAndAno(Integer candidatoId, Integer ano) throws ObjectNotFoundException {
		Candidato candidato = candidatoService.findById(candidatoId);		
		return receitaRepository.findByCandidatura_candidatoAndCandidatura_ano(candidato, ano);
	}
}
