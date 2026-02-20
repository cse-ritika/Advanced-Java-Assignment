package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    private String projectName;

    // mappedBy → field name in Employee class
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    // Constructors
    public Project() {}

    public Project(String projectName) {
        this.projectName = projectName;
    }

    // Getters & Setters
    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
