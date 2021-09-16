package br.com.prestacaocontascampanhaeleitoral.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;
import br.com.prestacaocontascampanhaeleitoral.services.CandidatoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/candidatos")
public class CandidatoResource {
	
	@Autowired
	private CandidatoService service;
	
	@GetMapping
	ResponseEntity<Page<Candidato>> findByNome(@RequestParam(defaultValue = "") String nome,
			@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer linesPerPage,
            @RequestParam(defaultValue = "id") String orderBy,
            @RequestParam(defaultValue = "ASC") String direction){
		return ResponseEntity.ok(service.findByNome(nome, page, linesPerPage, orderBy, direction));
	}
	
	@GetMapping(value="/{id}")
	ResponseEntity<Candidato> findById(@PathVariable Integer id) throws ObjectNotFoundException{
		Candidato candidato = service.findById(id);
		return ResponseEntity.ok(candidato);
	}

}
