package br.com.rpires.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.rpires.dao.generic.GenericDAO;

import br.com.rpires.domain.Quarto;

/**
 * @author rodrigo.pires
 *
 */
public class QuartoDao extends GenericDAO<Quarto, String>  {

	public QuartoDao() {
		super(Quarto.class);
	}

	
	public List<Quarto> filtrarProdutos(String query) {
		TypedQuery<Quarto> tpQuery = 
				this.entityManager.createNamedQuery("Quarto.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}

}
