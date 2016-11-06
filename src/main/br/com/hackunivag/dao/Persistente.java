package br.com.hackunivag.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;


public interface Persistente<T> {
	
	Session getSession();

    void delete(final T obj);

    void persist(final T obj) throws Exception;
    
    void evict(final T obj) throws Exception; 
    
    List<T> findByExample(final T example) throws Exception ;

    List<T> findByExample(T exampleInstance, String[] excludeProperty);

	T findByField(String[] fieldOnTable, Object[] expression) throws Exception;
    
    List<T> findByFieldBetween(String field, Object valueInit, Object valueEnd) throws Exception;
    
    List<T> findByFieldLike(String field, Object value) throws Exception ;
    
    List<T> findByFieldLike(String fieldOnTable, String value) throws Exception;
    
    List<T> findByFieldLike(String[] fieldOnTable, Object[] value) throws Exception;
    
    List<T> findByFieldLikeOrdered(String fieldOnTable, String value, String orderBy) throws Exception;
    
    List<T> findByFieldOrdered(String fieldOnTable, Object value, String orderBy) throws Exception;
    
    Serializable insert(T obj) throws Exception ;
    
    List<T> listAll(String orderBy) throws Exception ;
    
    List<T> listAll() throws Exception ;
    
    T loadByField(String fieldName, Object value ) throws Exception ;
    
    T loadByField(String[] fieldOnTable, Object[] values) throws Exception;
    
    T loadById(Serializable id ) throws Exception ;
    
    T merge(final T obj) throws Exception ;
    
    T saveOrUpdate(final T obj) throws Exception;
    
    void update(final T obj) throws Exception ;

    void refresh(final T obj) throws Exception;
    
    List<T> findInField(String field, List<Object> values);
    
    boolean isAttached(T t);
    
    void flush();
    
}