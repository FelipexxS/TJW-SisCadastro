package br.edu.ifce.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table (name = "tbl_aluno")
public class Cliente implements Serializable {
	
	public Cliente() {
			documentos = new Documentos();
			telefone = new ArrayList<Telefone>();
			endereco = new ArrayList<Endereco>();
	}
	
	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;
	
	//length: Limita a quantidade de caracteres de uma string
	//nullable: Determina se o campo pode possuir valores null ou não
	//unique: Determina se uma coluna pode ter valores repetidos ou não
	//precision: Determina a quantidade de dígitos de um número decimal a serem armazenadas
	//scale: Determina a quantidade de casas decimais de um número decimal
	
	@Column (name = "nome_cliente")
	private String nome;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="docs_id" , unique = true)
	private Documentos documentos;
	
	@OneToMany (cascade = CascadeType.PERSIST)
	private Collection<Endereco> endereco;
	
	@OneToMany (cascade = CascadeType.PERSIST)
	private Collection<Telefone> telefone ;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Collection<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Collection<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Documentos getDocumentos() {
		return documentos;
	}
	public void setDocumentos(Documentos documentos) {
		this.documentos = documentos;
	}
	public Collection<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(Collection<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
	
		
}
