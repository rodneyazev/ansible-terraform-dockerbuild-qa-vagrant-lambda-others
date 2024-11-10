package com.main.app;

public class User {
	private String username;
	private double salary;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void readjustment(int note) {
		if (note > 8) {
			this.salary = salary * 1.50;
		} else {
			this.salary = salary * 1.10;
		}
		
	}
	
	
	
}
