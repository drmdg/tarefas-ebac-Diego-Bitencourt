/**
 * 
 */
package br.com.diego.dao.jpa;

import br.com.diego.dao.generic.jpa.GenericJpaDB3DAO;
import br.com.diego.domain.jpa.ClienteJpa2;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
