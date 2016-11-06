package br.com.hackunivag.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;

import br.com.hackunivag.entidade.Usuario;

public class BaseDAO<T> implements Persistente<T> {

	protected Class<T> objClass = null;

	@Logger
	protected Log log;

	@In
	private Session session;

	@In
	protected EntityManager entityManager;

	@In(create = false, required = false, value = "usuarioLogado")
	private Usuario usuarioLogado;


	public BaseDAO() {
		log.info("Iniciando BaseDAO");
		log.info("session: " + session);
		log.info("entityManager: " + entityManager);
	}

	public BaseDAO(Class<T> obj) {

		this.setObjectClass(obj);
	}

	public Session getSession() {
		
		return this.session;
	}

	public Session getSessionSemFiltroEmpresa() {
		return this.session;
	}

	public void setObjectClass(Class<T> objectKlass) {
		this.objClass = objectKlass;
	}

	public void delete(final T obj) {
		session.merge(obj);
		session.delete(obj);
	}

	public void persist(final T obj) throws Exception {
		session.merge(obj);
		session.persist(obj);
	}

	public void refresh(final T obj) throws Exception {
		session.refresh(obj);
	}

	public void evict(final T obj) throws Exception {
		session.evict(obj);
	}

	public void evict(final List<T> listObj) throws Exception {
		session.evict(listObj);
	}

	public void evictAndClear(final List<T> listObj) throws Exception {
		session.evict(listObj);
		session.clear();
	}

	public List<T> findByExample(final T example) throws Exception {
		return this.findByCriteria(Example.create(example).enableLike(MatchMode.ANYWHERE).ignoreCase());
	}

	public List<T> findByExample(final T exampleInstance, String[] excludeProperty) {
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		return this.findByCriteria(example);
	}

	@SuppressWarnings("unchecked")
	public T findByField(String[] fieldOnTable, Object[] expression) throws Exception {

		Criteria c = getSession().createCriteria(this.objClass);

		for (int i = 0; i < fieldOnTable.length; i++) {

			if (expression[i] instanceof String) {
				c.add(Restrictions.eq(fieldOnTable[i], String.valueOf(expression[i])));
			} else if (expression[i] instanceof Date) {
				c.add(Restrictions.eq(fieldOnTable[i], expression[i]));
			} else {
				c.add(Restrictions.eq(fieldOnTable[i], expression[i]));
			}
		}

		return (T) c.uniqueResult();
	}

	public List<T> findByFieldBetween(String field, Object valueInit, Object valueEnd) throws Exception {
		return this.findByCriteria(Restrictions.between(field, valueInit, valueEnd));
	}

	public List<T> findByFieldLike(String fieldOnTable, Object value) throws Exception {
		return this.findByCriteria(Restrictions.like(fieldOnTable, value).ignoreCase());
	}

	public List<T> findByFieldLike(String fieldOnTable, String value) throws Exception {
		return this.findByCriteria(Restrictions.like(fieldOnTable, value, MatchMode.ANYWHERE).ignoreCase());
	}

	@SuppressWarnings("unchecked")
	public List<T> findByFieldLike(String[] fieldOnTable, Object[] value) throws Exception {

		Criteria c = getSession().createCriteria(this.objClass);

		for (int i = 0; i < fieldOnTable.length; i++) {

			if (value[i] instanceof String) {
				c.add(Restrictions.like(fieldOnTable[i], String.valueOf(value[i]), MatchMode.ANYWHERE).ignoreCase());
			} else if (value[i] instanceof Date) {
				c.add(Restrictions.eq(fieldOnTable[i], value[i]));
			} else {
				c.add(Restrictions.like(fieldOnTable[i], value[i]));
			}
		}

		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByFieldLikeOrdered(String fieldOnTable, String value, String orderBy) throws Exception {
		Criteria criteria = getSession().createCriteria(this.objClass).add(Restrictions.like(fieldOnTable, value, MatchMode.ANYWHERE).ignoreCase());
		criteria.addOrder(Order.asc(orderBy));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByFieldOrdered(String fieldOnTable, Object value, String orderBy) throws Exception {
		Criteria criteria = getSession().createCriteria(this.objClass).add(Restrictions.eq(fieldOnTable, value));
		criteria.addOrder(Order.asc(orderBy));
		return criteria.list();
	}

	public Serializable insert(T obj) throws Exception {
		Serializable idGerado = getSession().save(obj);
		return idGerado;
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll(String orderBy) throws Exception {
		Criteria criteria = getSession().createCriteria(this.objClass);

		criteria.addOrder(Order.asc(orderBy));
		final List<T> result = criteria.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll() throws Exception {
		Criteria criteria = getSession().createCriteria(this.objClass);

	
		final List<T> result = criteria.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public T loadByField(String fieldName, Object value) throws Exception {
		Criteria criteria = getSession().createCriteria(this.objClass).add(Restrictions.eq(fieldName, value));
		Object obj = criteria.uniqueResult();
		return (obj != null) ? (T) obj : null;
	}

	@SuppressWarnings("unchecked")
	public T loadByField(String[] fields, Object[] values) throws Exception {

		Criteria criteria = getSession().createCriteria(this.objClass);

		for (int i = 0; i < fields.length; i++) {
			criteria.add(Restrictions.eq(fields[i], values[i]));
		}
		Object obj = criteria.uniqueResult();

		return (obj != null) ? (T) obj : null;
	}

	@SuppressWarnings("unchecked")
	public T loadById(Serializable id) throws Exception {
		return (T) getSession().load(this.objClass.getName(), id);
	}

	@SuppressWarnings("unchecked")
	public T merge(T obj) throws Exception {
		return (T) getSession().merge(obj);
	}

	public T saveOrUpdate(final T obj) {
		getSession().saveOrUpdate(obj);
		return obj;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void update(final T obj) throws Exception {
		getSession().update(obj);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(this.objClass);
		for (Criterion c : criterion) {
			crit.add(c);
		}

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findInField(String field, List<Object> values) {
		Criteria criteria = getSession().createCriteria(this.objClass);
		criteria.add(Restrictions.in(field, values));
		return criteria.list();
	}

	

	public void begin() {
		getSession().beginTransaction();
	}

	public void commit() {
		getSession().getTransaction().commit();
	}

	
	public boolean isAttached(T t) {
		return session.contains(t);
	}

	public void flush() {
		getSession().flush();
	}

	public void limparCache() {
		getSession().clear();
	}

	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}


}