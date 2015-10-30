package cs544.lab04_1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import cs544.lab04_1.model.Airline;
import cs544.lab04_1.model.Flight;

public class Application {

	public static void main(String[] args) {

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = App.emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			// All airlines that use A380 (model) airplanes

			/*
			 * Query query1 = em.createQuery(
			 * "select Distinct AL from Flight F join F.airline AL join F.airplane AP where AP.model = :model"
			 * ); query1.setParameter("model", "A380"); List<Airline> airlines =
			 * query1.getResultList(); System.out.println(
			 * "Name of airplanes are ::::"); for (Airline airline : airlines) {
			 * System.out.println(airline.getName()); }
			 */
			// All flights leaving the USA with a capacity > 500

			/*
			 * Query query2 = em.createQuery(
			 * "select Distinct F from Flight F join " +
			 * "F.origin FO join F.destination FD join F.airplane FA where  FO.country = :ocountry"
			 * + "AND FD.country != :dcountry AND FA.capacity > :capacity");
			 * query2.setParameter("ocountry", "USA");
			 * query2.setParameter("dcountry", "USA");
			 * query2.setParameter("capacity", 500); System.out.println(
			 * "Flights are "); List<Flight> flights = query2.getResultList();
			 * for (Flight flight : flights) {
			 * System.out.println(flight.getFlightnr()); }
			 */

			// All fights using 747 planes that don’t belong to ‘Star Alliance’

			/*
			 * Query query3 = em.createQuery(
			 * "select Distinct F from Flight F join F.airplane FP join F.airline FR"
			 * + "where FP.model = :model AND FR.name != :name");
			 * 
			 * query3.setParameter("model", "747"); query3.setParameter("name",
			 * "Star Alliance"); List<Flight> flights = query3.getResultList();
			 * System.out.println(
			 * "Flights using 747 planes that don’t belong to ‘Star Alliance’");
			 * for (Flight flight : flights) {
			 * System.out.println(flight.getFlightnr());
			 * 
			 * }
			 */

			// All flights leaving before 12pm on 08/07/2009
			Query query4 = em.createQuery("select Distinct F from Flight F where  F.departureTime < :departureTime "
					+ "AND F.departureDate = :departuredate");
			query4.setParameter("departureTime", "12:00 pm");
			query4.setParameter("departuredate", "08/07/2009");
			List<Flight> flights = query4.getResultList();
			System.out.println("All flights leaving before 12pm on 08/07/2009  ");
			for (Flight flight : flights) {
				System.out.println(flight.getFlightnr());
			}

			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
}
