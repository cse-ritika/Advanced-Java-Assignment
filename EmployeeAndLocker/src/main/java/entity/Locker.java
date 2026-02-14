package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lockers")
public class Locker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lockerId;
	private String lockerNumber;
	private String floor;
	
	public Locker() {
	}
	public Locker(String lockerNumber,String floor) {
		this.lockerNumber=lockerNumber;
		this.floor=floor;
	}
	public int getLockerId() {
		return lockerId;
	}
	public String getLockerNumber() {
		return lockerNumber;
	}
	public void setLockerNumber(String lockerNumber) {
		this.lockerNumber = lockerNumber;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
}
