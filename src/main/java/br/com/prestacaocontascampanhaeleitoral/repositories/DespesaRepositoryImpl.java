package br.com.prestacaocontascampanhaeleitoral.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.prestacaocontascampanhaeleitoral.dto.DespesaCategoriaDTO;
import br.com.prestacaocontascampanhaeleitoral.dto.DespesaDTO;

@Repository
public class DespesaRepositoryImpl {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public List<DespesaDTO> findTotalByCandidato(Integer candidatoId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT c.ano, COUNT(d.id) AS quantidade, SUM(d.vl_despesa) AS total FROM despesas d ");
		sb.append(" INNER JOIN candidatura c ON c.id = d.id_candidatura WHERE c.id_candidato = " + candidatoId);
		sb.append(" GROUP BY c.ano ORDER BY c.ano DESC");
		
		Query query = manager.createNativeQuery(sb.toString());
				
		@SuppressWarnings("unchecked")
		final List<Object[]> result = query.getResultList();

		List<DespesaDTO> list = new ArrayList<DespesaDTO>();

		for (final Object[] obj : result) {
			DespesaDTO despesa = new DespesaDTO();
			int i = 0;
			despesa.setAno((Integer)obj[i++]);
			despesa.setQuantidade(((BigInteger)obj[i++]).intValue());
			despesa.setTotal((double)obj[i++]);
			list.add(despesa);
		}
				
		
		return list;
	}
	
	
	public List<DespesaCategoriaDTO> findByCandidatoAndAnoGroupByTipo(Integer candidatoId, Integer ano) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT d.tp_despesa AS tipo, SUM(d.vl_despesa) AS total FROM despesas d ");
		sb.append(" INNER JOIN candidatura c ON c.id = d.id_candidatura WHERE c.id_candidato = " + candidatoId + " AND c.ano = " + ano);
		sb.append(" GROUP BY d.tp_despesa ORDER BY total DESC");
		
		Query query = manager.createNativeQuery(sb.toString());
				
		@SuppressWarnings("unchecked")
		final List<Object[]> result = query.getResultList();

		List<DespesaCategoriaDTO> list = new ArrayList<DespesaCategoriaDTO>();

		for (final Object[] obj : result) {
			DespesaCategoriaDTO despesa = new DespesaCategoriaDTO();
			int i = 0;
			despesa.setCategoria(((String)obj[i++]));
			despesa.setTotal((double)obj[i++]);
			list.add(despesa);
		}
				
		
		return list;
	}
}
