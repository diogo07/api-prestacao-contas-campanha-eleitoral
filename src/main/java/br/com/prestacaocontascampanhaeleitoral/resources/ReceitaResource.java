package br.com.prestacaocontascampanhaeleitoral.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prestacaocontascampanhaeleitoral.domain.Receita;
import br.com.prestacaocontascampanhaeleitoral.dto.ReceitaDTO;
import br.com.prestacaocontascampanhaeleitoral.services.ReceitaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/receitas")
public class ReceitaResource {

	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping
	ResponseEntity<List<Receita>> byCandidatoAndAno(@RequestParam Integer candidatoId, @RequestParam Integer ano) throws ObjectNotFoundException{
		return ResponseEntity.ok(receitaService.findByCandidatoAndAno(candidatoId, ano));
	}
	
	
	@GetMapping("/total")
	ResponseEntity<List<ReceitaDTO>> byCandidato(@RequestParam Integer candidatoId){
		return ResponseEntity.ok(receitaService.findTotalByCandidato(candidatoId));
	}
}
