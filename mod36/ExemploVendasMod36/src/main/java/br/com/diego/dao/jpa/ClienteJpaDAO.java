/**
 * 
 */
package br.com.diego.dao.jpa;

import br.com.diego.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.diego.domain.jpa.ClienteJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
