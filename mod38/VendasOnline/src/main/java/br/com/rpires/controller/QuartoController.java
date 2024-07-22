package br.com.rpires.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rpires.domain.Quarto;

import br.com.rpires.service.QuartoService;

/**
 * @author rodrigo.pires
 *
 */
@Named
@ViewScoped
public class QuartoController implements Serializable {

	private static final long serialVersionUID = 367088063926303823L;
	
	private Quarto produto;
	
	private Collection<Quarto> produtos;
	
	@Inject
	private QuartoService produtoService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.produto = new Quarto();
			this.produtos = produtoService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os produtos"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.produto = new Quarto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Quarto produto) {
		try {
			this.isUpdate = true;
			this.produto = produto;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar o produto"));
		}
		
    } 
	
	public void delete(Quarto produto) {
		try {
			produtoService.excluir(produto);
			produtos.remove(produto);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
		}
		
    } 
	
	public void add() {
		try {
			produtoService.cadastrar(produto);
			this.produtos = produtoService.buscarTodos();
			this.produto = new Quarto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o produto"));
		}
		
        
    }

    public void update() {
    	try {
    		produtoService.alterar(this.produto);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Produto Atualiado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o produto"));
		}
        
    }
    
    public String voltarTelaInicial() {
		return "/index.xhtml"; 
	}

	public Quarto getProduto() {
		return produto;
	}

	public void setProduto(Quarto produto) {
		this.produto = produto;
	}

	public Collection<Quarto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Quarto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
    
    

}
