package br.com.rpires.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Diaria;

import br.com.rpires.domain.Quarto;

import br.com.rpires.exceptions.DAOException;
import br.com.rpires.service.DiariaService;
import br.com.rpires.service.IClienteService;

import br.com.rpires.service.QuartoService;

/**
 * @author rodrigo.pires
 *
 */
@Named
@ViewScoped
public class DiariaController implements Serializable {

	private static final long serialVersionUID = -3508753726177740824L;
	
	private Diaria venda;
	
	private Collection<Diaria> vendas;
	
	@Inject
	private DiariaService vendaService;
	
	@Inject
	private IClienteService clienteService;
	
	@Inject
	private QuartoService produtoService;
	
	private Boolean isUpdate;
	
	private Integer quantidadeProduto;
	
	private Quarto produtoSelecionado;
	
	private BigDecimal valorTotal; 
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.venda = new Diaria();
			this.vendas = vendaService.buscarTodos();
			this.valorTotal = BigDecimal.ZERO;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar as vendas"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.venda = new Diaria();
			this.valorTotal = BigDecimal.ZERO;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Diaria venda) {
		try {
			this.isUpdate = true;
			this.venda = this.vendaService.consultarComCollection(venda.getId());
			this.valorTotal = this.venda.recalcularValorTotalVenda();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar a venda"));
		}
		
    } 
	
	public void delete(Diaria venda) {
		try {
			vendaService.cancelarVenda(venda);
			cancel();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar a venda"));
		}
		
    } 
	
	public void finalizar(Diaria venda) {
		try {
			vendaService.finalizarVenda(venda);
			cancel();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar finalizar a venda"));
		}
		
    } 
	
	public void add() {
		try {
			vendaService.cadastrar(venda);
			this.vendas = vendaService.buscarTodos();
			cancel();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cadastrar a venda"));
		}
    }
	
	public void update() {
    	try {
    		vendaService.alterar(this.venda);
    		this.vendas = vendaService.buscarTodos();
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Venda atualiada com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar a venda"));
		}
        
    }
	
	public void adicionarProduto() {
		
		this.venda.setQuarto(this.produtoSelecionado);
		
		this.venda.recalcularValorTotalVenda();
		this.valorTotal = this.venda.recalcularValorTotalVenda();
	}
	
	public void removerProduto() throws DAOException {
		this.vendaService.excluir(venda);
		
	}
	
	
	public void onRowEdit() {
	
    }

    public void onRowCancel() {
      
    }
    
    public void adicionarOuRemoverProduto() {
   
    }
	
	public List<Cliente> filtrarClientes(String query) {
		return this.clienteService.filtrarClientes(query);
	}
	
	public List<Quarto> filtrarProdutos(String query) {
		return this.produtoService.filtrarProdutos(query);
	}
    
    public String voltarTelaInicial() {
		return "/index.xhtml"; 
	}

	public Diaria getVenda() {
		return venda;
	}

	public void setVenda(Diaria venda) {
		this.venda = venda;
	}

	public Collection<Diaria> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Diaria> vendas) {
		this.vendas = vendas;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}


	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Quarto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Quarto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
    

}