package com.fdmgroup.bookstore.model;
import java.util.ArrayList;
import java.util.Objects;


public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private ArrayList<Order> orders ;
	
	public User() {
	}	
	public User(String firstName, String lastName, String username, String password, String email,
			ArrayList<Order> orders) {
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);;
		this.setOrders(orders);
		this.setPassword(password);
		this.setUserId(0);
		this.setUsername(username);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", orders=" + orders + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, orders, password, userId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(orders, other.orders)
				&& Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(username, other.username);
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

}
