/**
 * 
 */
package br.com.rpires.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Diaria;

import br.com.rpires.domain.Quarto;

import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class DiariaDao extends GenericDAO<Diaria, Long>  {

	public DiariaDao() {
		super(Diaria.class);
	}

	
	public void finalizarVenda(Diaria venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	
	public void cancelarVenda(Diaria venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	
	public void excluir(Diaria entity) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	
	public Diaria cadastrar(Diaria entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			
			Quarto quartoJpa = entityManager.merge(entity.getQuarto());
			entity.setQuarto(quartoJpa);
			Cliente cliente = entityManager.merge(entity.getCliente());
			entity.setCliente(cliente);
			entityManager.persist(entity);
//			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			throw new DAOException("ERRO SALVANDO Diaria ", e);
		}
		
	}

	
	public Diaria consultarComCollection(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Diaria> query = builder.createQuery(Diaria.class);
		Root<Diaria> root = query.from(Diaria.class);
		root.fetch("cliente");
		root.fetch("quarto");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Diaria> tpQuery = 
				entityManager.createQuery(query);
		Diaria venda = tpQuery.getSingleResult(); 
		return venda;
	}


	public List<Diaria> filtrarProdutos(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public Collection<Venda> buscarTodos() throws DAOException {
//		StringBuilder sb = new StringBuilder();
//		sb.append("SELECT obj FROM ");
//		sb.append(this.persistenteClass.getSimpleName());
//		sb.append(" obj");
//		sb.append(" WHERE obj.status = :status");
//		TypedQuery<Venda> query = this.entityManager.createQuery(sb.toString(), Venda.class);
//		query.setParameter("status", Venda.Status.);
//		
//		List<T> list = 
//				entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
//		return list;
//	}

}