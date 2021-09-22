package br.com.prestacaocontascampanhaeleitoral.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prestacaocontascampanhaeleitoral.domain.Despesa;
import br.com.prestacaocontascampanhaeleitoral.dto.DespesaCategoriaDTO;
import br.com.prestacaocontascampanhaeleitoral.dto.DespesaDTO;
import br.com.prestacaocontascampanhaeleitoral.services.DespesaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/despesas")
public class DespesaResource {

	@Autowired
	private DespesaService despesaService;
	
	@GetMapping
	ResponseEntity<List<Despesa>> byCandidatoAndAno(@RequestParam Integer candidatoId, @RequestParam Integer ano) throws ObjectNotFoundException{
		return ResponseEntity.ok(despesaService.findByCandidatoAndAno(candidatoId, ano));
	}
	
	
	@GetMapping("/total")
	ResponseEntity<List<DespesaDTO>> byCandidato(@RequestParam Integer candidatoId){
		return ResponseEntity.ok(despesaService.findTotalByCandidato(candidatoId));
	}
	
	@GetMapping("/por-categoria")
	ResponseEntity<List<DespesaCategoriaDTO>> byCandidatoGroupCategoria(@RequestParam Integer candidatoId, @RequestParam Integer ano){
		return ResponseEntity.ok(despesaService.findByCandidatoAndAnoGroupByTipo(candidatoId, ano));
	}
}
