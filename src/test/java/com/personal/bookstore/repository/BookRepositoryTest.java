package com.personal.bookstore.repository;

import static org.junit.Assert.assertEquals;

import java.beans.Beans;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.personal.bookstore.model.Book;
import com.personal.bookstore.model.Language;

@RunWith(Arquillian.class)
public class BookRepositoryTest {
	
	@Inject
	private BookRepository bookRepository;
	
	@Test
	public void create() {
		assertEquals(Long.valueOf(0), bookRepository.countAll());
		assertEquals(Long.valueOf(0), bookRepository.findAll());
	}
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(BookRepository.class)
				.addClass(Book.class)
				.addClass(Language.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
}
