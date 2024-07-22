/**
 * 
 */
package br.com.rpires.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import br.com.rpires.dao.QuartoDao;
import br.com.rpires.domain.Quarto;
import br.com.rpires.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class QuartoService extends GenericService<Quarto, String>{
	
	private QuartoDao quartoDao;

	
	public QuartoService() {
		super();
	}
	@Inject
	public QuartoService(QuartoDao quartoDao) {
		super(quartoDao);
		this.quartoDao = quartoDao;
	}

	
	public List<Quarto> filtrarProdutos(String query) {
		return quartoDao.filtrarProdutos(query);
	}

}
