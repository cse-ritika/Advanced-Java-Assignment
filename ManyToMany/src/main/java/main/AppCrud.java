package main;
import entity.Employee;
import entity.Project;

import jakarta.persistence.*;
import java.util.List;

public class AppCrud {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("manyToManyPU");

        EntityManager em = emf.createEntityManager();

        // 🔹 READ
        Employee emp = em.find(Employee.class, 1);
        System.out.println("Employee Name: " + emp.getEmpName());

        List<Project> projects = emp.getProjects();
        for (Project p : projects) {
            System.out.println("Project: " + p.getProjectName());
        }

        // 🔹 UPDATE
        em.getTransaction().begin();
        emp.setEmpName("Ritika Sharma");
        em.merge(emp);
        em.getTransaction().commit();
        System.out.println("Updated Successfully");

        // 🔹 DELETE
        em.getTransaction().begin();
        Employee empDelete = em.find(Employee.class, 2);
        em.remove(empDelete);
        em.getTransaction().commit();
        System.out.println("Deleted Successfully");

        em.close();
        emf.close();
    }
}
