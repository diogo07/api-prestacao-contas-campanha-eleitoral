package br.com.prestacaocontascampanhaeleitoral.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.prestacaocontascampanhaeleitoral.dto.ReceitaCategoriaDTO;
import br.com.prestacaocontascampanhaeleitoral.dto.ReceitaDTO;

@Repository
public class ReceitaRepositoryImpl {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public List<ReceitaDTO> findTotalByCandidato(Integer candidatoId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT c.ano, COUNT(r.id) AS quantidade, SUM(r.vl_receita) AS total FROM receitas r ");
		sb.append(" INNER JOIN candidatura c ON c.id = r.id_candidatura WHERE c.id_candidato = " + candidatoId);
		sb.append(" GROUP BY c.ano ORDER BY c.ano DESC");
		
		Query query = manager.createNativeQuery(sb.toString());
				
		@SuppressWarnings("unchecked")
		final List<Object[]> result = query.getResultList();

		List<ReceitaDTO> list = new ArrayList<ReceitaDTO>();

		for (final Object[] obj : result) {
			ReceitaDTO receita = new ReceitaDTO();
			int i = 0;
			receita.setAno((Integer)obj[i++]);
			receita.setQuantidade(((BigInteger)obj[i++]).intValue());
			receita.setTotal((double)obj[i++]);
			list.add(receita);
		}
				
		
		return list;
	}
	
	
	public List<ReceitaCategoriaDTO> findByCandidatoAndAnoGroupByTipo(Integer candidatoId, Integer ano) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT r.tipo_receita AS tipo, SUM(r.vl_receita) AS total FROM receitas r ");
		sb.append(" INNER JOIN candidatura c ON c.id = r.id_candidatura WHERE c.id_candidato = " + candidatoId + " AND c.ano = " + ano);
		sb.append(" GROUP BY r.tipo_receita ORDER BY total DESC");
		
		Query query = manager.createNativeQuery(sb.toString());
				
		@SuppressWarnings("unchecked")
		final List<Object[]> result = query.getResultList();

		List<ReceitaCategoriaDTO> list = new ArrayList<ReceitaCategoriaDTO>();

		for (final Object[] obj : result) {
			ReceitaCategoriaDTO receita = new ReceitaCategoriaDTO();
			int i = 0;
			receita.setCategoria(((String)obj[i++]));
			receita.setTotal((double)obj[i++]);
			list.add(receita);
		}
				
		
		return list;
	}
}
