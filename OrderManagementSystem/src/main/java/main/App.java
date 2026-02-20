package main;

import java.time.LocalDate;

import entity.Customer;
import entity.Order;   // ✅ Correct Import

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        // Step 1: Create Factory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("OrderPU");

        // Step 2: Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Step 3: Begin Transaction
        em.getTransaction().begin();

        // Step 4: Create Customer
        Customer c = new Customer(
                "Ritika",
                "ritika@gmail.com"
        );

        em.persist(c);

        // Step 5: Create Orders
        Order o1 = new Order(
                LocalDate.now(),
                2500.0,
                c
        );

        Order o2 = new Order(
                LocalDate.now(),
                4800.0,
                c
        );

        // Step 6: Persist Orders
        em.persist(o1);
        em.persist(o2);

        // Step 7: Commit
        em.getTransaction().commit();

        // Step 8: Close
        em.close();
        emf.close();

        System.out.println("Data Inserted Successfully...");
    }
}
