package br.com.prestacaocontascampanhaeleitoral.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prestacaocontascampanhaeleitoral.CandidatoService;
import br.com.prestacaocontascampanhaeleitoral.domain.Candidato;

@RestController
@RequestMapping("/candidatos")
public class CandidatoResource {
	
	@Autowired
	private CandidatoService service;
	
	@GetMapping
	ResponseEntity<Page<Candidato>> findAll(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer linesPerPage,
            @RequestParam(defaultValue = "id") String orderBy,
            @RequestParam(defaultValue = "ASC") String direction){
		return ResponseEntity.ok(service.findAll(page, linesPerPage, orderBy, direction));
	}

}
