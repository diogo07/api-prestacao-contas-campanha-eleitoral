package br.com.prestacaocontascampanhaeleitoral.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.prestacaocontascampanhaeleitoral.utils.Utils;

@Table(name = "candidato")
@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max=11)
	private String cpf;
	
	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy="candidato")
	private Set<Candidatura> candidaturas;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return Utils.cpfWithMask(cpf);
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Candidatura> getCandidaturas() {
		return candidaturas;
	}
	public void setCandidaturas(Set<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}
	
	
}
