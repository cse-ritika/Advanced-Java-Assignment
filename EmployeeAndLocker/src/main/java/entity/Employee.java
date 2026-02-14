package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	private String name;
	private String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "locker_id")
	private Locker locker;
	
	public Employee() {}
	public Employee(String name, String department, Locker locker) {
		this.name = name;
		this.department = department;
		this.locker = locker;
	}
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Locker getLocker() {
		return locker;
	}
	public void setLocker(Locker locker) {
		this.locker = locker;
	}
	
}
