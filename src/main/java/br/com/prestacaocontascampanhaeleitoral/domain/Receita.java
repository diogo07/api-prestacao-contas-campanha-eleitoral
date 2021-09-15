package br.com.prestacaocontascampanhaeleitoral.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "receitas")
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_doador")
	private Doador doador;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name="id_candidatura", nullable=false)
	private Candidatura candidatura; 
	
	@Column(name = "vl_receita")
	private double valor;
	
	@Column(name = "nr_recibo")
	private String numeroRecibo;

	@Column(name = "tipo_receita")
	private String tipo;
	
	@Column(name = "descricao_receita")
	private String descricao;
	
	@Column(name = "fonte_recurso")
	private String fonteRecurso;
	
	@Column(name = "especie_recurso")
	private String especieRecurso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNumeroRecibo() {
		return numeroRecibo;
	}

	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFonteRecurso() {
		return fonteRecurso;
	}

	public void setFonteRecurso(String fonteRecurso) {
		this.fonteRecurso = fonteRecurso;
	}

	public String getEspecieRecurso() {
		return especieRecurso;
	}

	public void setEspecieRecurso(String especieRecurso) {
		this.especieRecurso = especieRecurso;
	}

	public Candidatura getCandidatura() {
		return candidatura;
	}

	public void setCandidatura(Candidatura candidatura) {
		this.candidatura = candidatura;
	}
	
	
	
}
