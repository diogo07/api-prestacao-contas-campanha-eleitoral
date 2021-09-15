package br.com.prestacaocontascampanhaeleitoral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;
import br.com.prestacaocontascampanhaeleitoral.repositories.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	
	public Page<Candidato> findAll(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return candidatoRepository.findAll(pageRequest);
	}
}
