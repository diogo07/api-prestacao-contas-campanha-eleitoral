package br.com.prestacaocontascampanhaeleitoral.domain;

import java.util.Date;

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
@Table(name = "despesas")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name="id_candidatura", nullable=false)
	private Candidatura candidatura; 
	
	@Column(name = "vl_despesa")
	private double valor;
	
	@Column(name = "tp_despesa")
	private String tipo;
	
	@Column(name = "tp_documento")
	private String tipoDocumento;
	
	@Column(name = "nr_documento")
	private String numeroDocumento;
	
	@Column(name = "ds_despesa")
	private String descricao;
		
	@Column(name = "fonte_recurso")
	private String fonteRecurso;
	
	@Column(name = "especie_recurso")
	private String especieRecurso;
	
	@Column(name = "is_entrega_em_conjunto")
	private boolean entregaEmConjunto;
	
	@Column(name = "dt_despesa")
	private Date data;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public boolean isEntregaEmConjunto() {
		return entregaEmConjunto;
	}

	public void setEntregaEmConjunto(boolean entregaEmConjunto) {
		this.entregaEmConjunto = entregaEmConjunto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Candidatura getCandidatura() {
		return candidatura;
	}

	public void setCandidatura(Candidatura candidatura) {
		this.candidatura = candidatura;
	}
	
	
	
}
