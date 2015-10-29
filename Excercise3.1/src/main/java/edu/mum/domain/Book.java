package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	Long id;

	String isbn;
	String title;
	String author;

	@ManyToOne
	@JoinTable(name="BOOKS_PUBLISHER")
	Publisher publisher;

}
