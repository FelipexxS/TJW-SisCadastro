package br.edu.ifce.dao;

import javax.persistence.EntityManager;

import br.edu.ifce.model.Cliente;
import br.edu.ifce.utils.JPAUtil;


public class ClienteDao {

	private final EntityManager manager = JPAUtil.getEntityManager();
	
	public void salvar(Cliente cliente) {
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
	}
	
	public Cliente consultarPorId(Long id) {
		return manager.find(Cliente.class, id);
	}
	
	public void Excluir(Cliente cliente) {
		manager.getTransaction().begin();
		manager.remove(cliente);
		manager.getTransaction().commit();
	}
	
	public void Excluir(Long id) {
		Excluir(consultarPorId(id));
	}
}
