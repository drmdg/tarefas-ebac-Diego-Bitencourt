/**
 * 
 */
package br.com.diego.dao.jpa;

import br.com.diego.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.diego.domain.jpa.ProdutoJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
