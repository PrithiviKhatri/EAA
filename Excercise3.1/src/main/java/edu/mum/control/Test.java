package edu.mum.control;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("excercise3");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

	}

}
