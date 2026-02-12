package com.capgemini.hibernet.HibernateDemo2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // -------------------------------
            // CUSTOMER CRUD
            // -------------------------------

            // 🔹 Use NEW ID to avoid duplicate error
            Customer newCustomer =
                    new Customer(0, "John Johnson", "Chicago");

            em.persist(newCustomer);

            // READ
            Customer foundCustomer =
                    em.find(Customer.class, 300);

            System.out.println("Found Customer: " + foundCustomer);

            // UPDATE
            if (foundCustomer != null) {
                foundCustomer.setName("Alice Updated");
                foundCustomer.setCity("Seattle");

                em.merge(foundCustomer);
            }

            // DELETE (only if exists)
            Customer customerToDelete =
                    em.find(Customer.class, 101);

            if (customerToDelete != null) {
                em.remove(customerToDelete);
            }

            // -------------------------------
            // EMPLOYEE + ADDRESS (Embedded)
            // -------------------------------

            Address addr =
                    new Address("Himachal Pradesh", "Himachal Pradesh", "India");

            Employee emp =
                    new Employee(3, "Pallavi Employee", addr);

            em.persist(emp);

            // -------------------------------

            em.getTransaction().commit();

            System.out.println("Data Inserted Successfully...");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
