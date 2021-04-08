package br.edu.ifce.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifce.dao.ClienteDao;
import br.edu.ifce.model.Cliente;
import br.edu.ifce.model.Endereco;
import br.edu.ifce.model.Telefone;

@ManagedBean(name = "RegisterMB")
@SessionScoped
public class RegisterManagedBean {
	
	private ClienteDao clienteDao = new ClienteDao();
	private Cliente cliente = new Cliente();
	private Collection<Telefone> telefone;
	private Collection<Endereco> endereco;
	
	@PostConstruct
	private void init() {
		cliente = new Cliente();
		clienteDao = new ClienteDao();
		telefone = cliente.getTelefone();
		endereco = cliente.getEndereco();
	
	}
	
	public void addfone(String numero) {
		Telefone t = new Telefone();
		t.setTelefone(numero);
		t.setTipo("-- não informado --");
		this.telefone.add(t);
	}
	
	public void addEndereco(Endereco end) {
		Endereco en = new Endereco();
		en = end;
		this.endereco.add(en);
	}
	
	public String registrar() {
		clienteDao.salvar(cliente);
		return "/clienteInfo";
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Collection<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(Collection<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Collection<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(Collection<Telefone> telefone) {
		this.telefone = telefone;
	}
	
	
}
