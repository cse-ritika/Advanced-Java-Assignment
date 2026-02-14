package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;
import entity.Locker;

public class App {

    public static void main(String[] args) {

        // Step 1: Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeLockerPU");

        // Step 2: Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {

            // Step 3: Begin Transaction
            em.getTransaction().begin();

            // Step 4: Create Locker Object
            Locker locker = new Locker();
            locker.setLockerNumber("L-101");
            locker.setFloor("2nd Floor");

            // Step 5: Create Employee Object
            Employee emp = new Employee();
            emp.setName("Ritika");
            emp.setDepartment("IT");

            // Step 6: Assign Locker to Employee
            emp.setLocker(locker);

            // Step 7: Persist Employee
            // (Locker will be saved automatically due to CascadeType.ALL)
            em.persist(emp);

            // Step 8: Commit Transaction
            em.getTransaction().commit();

            System.out.println("Employee and Locker saved successfully!");

            // ==============================
            // FETCH DATA
            // ==============================

            // Step 9: Retrieve Employee
            Employee fetchedEmp =
                    em.find(Employee.class, emp.getEmpId());

            System.out.println("\n Employee Details");
            System.out.println("----------------------");
            System.out.println("ID: " + fetchedEmp.getEmpId());
            System.out.println("Name: " + fetchedEmp.getName());
            System.out.println("Department: " + fetchedEmp.getDepartment());

            // Step 10: Get Locker Details
            Locker fetchedLocker = fetchedEmp.getLocker();

            System.out.println("\n Locker Details");
            System.out.println("----------------------");
            System.out.println("Locker ID: " + fetchedLocker.getLockerId());
            System.out.println("Locker Number: " + fetchedLocker.getLockerNumber());
            System.out.println("Floor: " + fetchedLocker.getFloor());

        } catch (Exception e) {

            // Rollback if error occurs
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {

            // Step 11: Close Resources
            em.close();
            emf.close();
        }
    }
}
