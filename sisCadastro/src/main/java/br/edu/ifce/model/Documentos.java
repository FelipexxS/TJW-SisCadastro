package br.edu.ifce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "tbl_docs")
public class Documentos {
	
	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;
	
	@Column(unique = true)
	private String rg;
	
	@Column(unique = true)
	private String cpf;
	
	@OneToOne(mappedBy = "documentos", cascade = CascadeType.ALL)
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
