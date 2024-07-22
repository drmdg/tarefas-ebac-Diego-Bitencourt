/**
 * 
 */
package br.com.rpires.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.rpires.dao.DiariaDao;
import br.com.rpires.domain.Diaria;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.generic.GenericService;
import br.com.rpires.domain.Diaria.Status;
/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class DiariaService extends GenericService<Diaria, Long>  {
	 @Inject
	    private DiariaDao dao;

	    // Public default constructor
	    public DiariaService() {
	        // Default constructor
	    }

	    // Constructor for injection
	    @Inject
	    public DiariaService(DiariaDao dao) {
	        super(dao);
	        this.dao = dao;
	    }

	
	public void finalizarVenda(Diaria diaria) throws TipoChaveNaoEncontradaException, DAOException {
		diaria.setStatus(Status.CONCLUIDA);
		dao.finalizarVenda(diaria);
	}

	
	public void cancelarVenda(Diaria diaria) throws TipoChaveNaoEncontradaException, DAOException {
		diaria.setStatus(Status.CANCELADA);
		dao.cancelarVenda(diaria);
	}

	
	public Diaria consultarComCollection(Long id) {
		return dao.consultarComCollection(id);
	}

	
	public Diaria cadastrar(Diaria entity) throws TipoChaveNaoEncontradaException, DAOException {
		entity.setStatus(Status.INICIADA);
		return super.cadastrar(entity);
	}
	
	

}
