/**
 * 
 */
package br.com.diego.dao;

import br.com.diego.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.diego.dao.jpa.IVendaJpaDAO;
import br.com.diego.domain.jpa.VendaJpa;
import br.com.diego.exceptions.DAOException;
import br.com.diego.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 * Classe utilizada somente no teste para fazer a exclusão das vendas
 *
 */
public class VendaExclusaoJpaDAO extends GenericJpaDB1DAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
