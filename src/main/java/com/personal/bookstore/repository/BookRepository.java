package com.personal.bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.personal.bookstore.model.Book;

public class BookRepository {

	@PersistenceContext(unitName="bookStorePU")
	private EntityManager em;
	
	public Book find(Long id) {
		return em.find(Book.class, id);
	}
	
	@Transactional(TxType.REQUIRED)
	public Book create(Book book) {
		em.persist(book);
		return book;
	}
	
	@Transactional(TxType.REQUIRED)
	public void delete(Long id) {
		em.remove(em.getReference(Book.class, id));
	}
	
	public List<Book> findAll(){
		TypedQuery<Book> createQuery = em.createQuery("SELECT b from Book b order by b.title", Book.class);
		return createQuery.getResultList();
	}
	
	public Long countAll() {
		TypedQuery<Long> createQuery = em.createQuery("SELECT count(b) from Book b", Long.class);
		return createQuery.getSingleResult();
	}
}
