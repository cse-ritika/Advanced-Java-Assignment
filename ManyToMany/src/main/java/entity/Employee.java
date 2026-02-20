package entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String empName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "employee_project",
        joinColumns = @JoinColumn(name = "emp_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    // 🔹 Default Constructor (Required)
    public Employee() {}

    // 🔹 Parameterized Constructor (ADD THIS)
    public Employee(String empName, List<Project> projects) {
        this.empName = empName;
        this.projects = projects;
    }

    // Getters & Setters
    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
