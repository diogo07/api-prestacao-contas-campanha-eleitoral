package br.com.prestacaocontascampanhaeleitoral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;
import br.com.prestacaocontascampanhaeleitoral.repositories.CandidatoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	
	public Page<Candidato> findByNome(String nome, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return candidatoRepository.findByNomeContaining(nome, pageRequest);
	}


	public Candidato findById(Integer id) throws ObjectNotFoundException {
		return candidatoRepository.findById(id)
				.orElseThrow(()-> new ObjectNotFoundException("Candidato não encontrado!"));
	}
}
