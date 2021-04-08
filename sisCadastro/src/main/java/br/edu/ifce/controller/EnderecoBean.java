package br.edu.ifce.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifce.model.Endereco;

@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Endereco endereco;

	@PostConstruct
	private void init() {
		setEndereco(new Endereco());
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
