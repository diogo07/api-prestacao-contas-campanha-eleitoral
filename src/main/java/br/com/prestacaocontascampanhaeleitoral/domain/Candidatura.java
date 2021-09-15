package br.com.prestacaocontascampanhaeleitoral.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "candidatura")
public class Candidatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer ano;
	
	private String numero;
	
	private String sequencial;
	
	@OneToOne
	@JoinColumn(name = "id_partido")
	private Partido partido;
	
	@OneToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	
	@Column(name = "sigla_uf")
	private String uf;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name="id_candidato", nullable=false)
	private Candidato candidato; 
	
	@OneToMany(mappedBy="candidatura")
	private Set<Receita> receitas;
	
	@OneToMany(mappedBy="candidatura")
	private Set<Despesa> despesas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSequencial() {
		return sequencial;
	}

	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Set<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(Set<Receita> receitas) {
		this.receitas = receitas;
	}

	public Set<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(Set<Despesa> despesas) {
		this.despesas = despesas;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
	
}
