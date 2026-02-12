package com.capgemini.hibernet.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // Load configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Create SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();

        // Open session
        Session session = factory.openSession();

        Transaction tx = null;

        try {
            // Begin transaction
            tx = session.beginTransaction();

            // ================= CREATE =================
            Customer newCustomer = new Customer();
            newCustomer.setId(11);
            newCustomer.setName("Alice Johnson");
            newCustomer.setCity("Chicago");

            session.save(newCustomer);
            System.out.println("Inserted: " + newCustomer.getName());

            // ================= READ =================
            Customer foundCustomer =
                    session.get(Customer.class, 5);

            if (foundCustomer != null) {
                System.out.println(
                        "Found: " +
                        foundCustomer.getName() + " " +
                        foundCustomer.getCity());
            }

            // ================= UPDATE =================
            if (foundCustomer != null) {

                foundCustomer.setCity("Delhi");
                session.update(foundCustomer);

                System.out.println("Updated Customer ID 5");
            }

            // ================= DELETE =================
            Customer deleteCustomer =
                    session.get(Customer.class, 3);

            if (deleteCustomer != null) {

                session.delete(deleteCustomer);
                System.out.println("Deleted Customer ID 3");
            }

            // Commit
            tx.commit();

        } catch (Exception e) {

            if (tx != null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();
            factory.close();
        }

        System.out.println("CRUD Operations Completed!");
    }
}
