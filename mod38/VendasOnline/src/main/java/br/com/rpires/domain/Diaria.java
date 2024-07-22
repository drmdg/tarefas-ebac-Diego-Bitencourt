package br.com.rpires.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DIARIA")
@NamedQuery(name = "Diaria.findByCodigo", query = "SELECT c FROM Diaria c WHERE c.codigo LIKE :codigo") 
public class Diaria implements Persistente{

	
	public enum Status {
		INICIADA, CONCLUIDA, CANCELADA;

		public static Status getByName(String value) {
			for (Status status : Status.values()) {
	            if (status.name().equals(value)) {
	                return status;
	            }
	        }
			return null;
		}
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="diaria_seq")
	@SequenceGenerator(name="diaria_seq", sequenceName="sq_diaria", initialValue = 1, allocationSize = 1)
	private Long id;
		
	@Column(name = "codigo", nullable = false, length = 10, unique = true)
	private String codigo;
	

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
    @JoinColumn(name = "quarto_id")
	private Quarto quarto;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_VENDA", nullable = false)
	private Status status;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal recalcularValorTotalVenda() {
		return this.quarto.getValor();
		
	}
	
	
	
	
}
