/**
 * 
 */
package br.com.diego.dao.jpa;

import br.com.diego.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.diego.domain.jpa.ClienteJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
