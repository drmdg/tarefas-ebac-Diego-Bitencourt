package br.com.rpires.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_QUARTO")
@NamedQuery(name = "Quarto.findByNome", query = "SELECT c FROM Quarto c WHERE c.nome LIKE :nome") 
public class Quarto implements Persistente{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="quarto_seq")
	@SequenceGenerator(name="quarto_seq", sequenceName="sq_quarto", initialValue = 1, allocationSize = 1)
	private Long id;
		
	@Column(name = "codigo", nullable = false, length = 10, unique = true)
	private String codigo;
		
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	@Column(name = "quantidade", nullable = false)	
	private int quantidade;
	@Column(name = "quantidadeDisponivel", nullable = false)	
	private int quantidadeDisponivel;
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	@OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diaria> diarias;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		
		this.valor = valor;
	}
	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}
	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	
	
	
}
