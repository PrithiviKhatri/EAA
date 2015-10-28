package edu.mum.hw2.control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Artist;
import edu.mum.hw2.domain.Movie;

public class Application {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

		addMovies();
		printMoviesReport();
		emf.close();
	}

	private static void printMoviesReport() {
		// TODO Auto-generated method stub

	}

	private static void addMovies() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Movie movie = new Movie();

			Artist artist1 = new Artist();
			artist1.setName("sharakuh");
			artist1.setCharacter("hero");
			artist1.setRating("5");

			Artist artist2 = new Artist();
			artist2.setName("salman");
			artist2.setCharacter("villain");
			artist2.setRating("3");

			Artist artist3 = new Artist();
			artist3.setName("deepika");
			artist3.setCharacter("actress");
			artist3.setRating("4");

			List<Artist> artists = new ArrayList<Artist>();
			artists.add(artist1);
			artists.add(artist2);
			artists.add(artist3);

			Set<String> categories = new HashSet<String>();
			categories.add("Comedy");
			categories.add("romantic");

			movie.setArtists(artists);
			movie.setCategories(categories);
			// TODO your code

			em.persist(movie);

			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
