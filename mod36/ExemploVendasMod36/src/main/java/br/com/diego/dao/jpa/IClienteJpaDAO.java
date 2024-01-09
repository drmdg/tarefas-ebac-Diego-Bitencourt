/**
 * 
 */
package br.com.diego.dao.jpa;

import br.com.diego.dao.generic.jpa.IGenericJapDAO;
import br.com.diego.domain.jpa.Persistente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
