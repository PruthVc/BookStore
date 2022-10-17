package com.fdmgroup.bookstore.data;

import java.util.ArrayList;
import com.fdmgroup.bookstore.model.User;

public class UserArrayListRepository implements UserRepository {
	private ArrayList<User> users = new ArrayList<User>();
	private static int ID = 1;

	public UserArrayListRepository() {
	} 
	
	public UserArrayListRepository(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public static int getID() {
		return UserArrayListRepository.ID;
	}

	public static void setID(int id) {
		UserArrayListRepository.ID = id;
	}

	@Override
	public boolean validate(String username, String password) {
		for (User user : this.getUsers()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User findByUsername(String username) {
		for (User user : this.getUsers()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
 
	@Override
	public User save(User user) {
		if (!this.users.contains(user)) {
			user.setUserId(UserArrayListRepository.generateId());
			this.users.add(user);

		} else if (this.users.contains(user)) {
			for (User user1 : this.getUsers()) {
				if (user1.getUserId() == user.getUserId()) {
					user1 = user;
					return user1;
				}
			}
		}
		return user;
	}

	public static int generateId() {
		int availableId = UserArrayListRepository.getID();
		UserArrayListRepository.setID(availableId+1);;
		return (availableId);
	}
	
	@Override
	public boolean delete(User user) {
		if(this.users.contains(user)) {
		this.users.remove(user);
		return true;
		}
		else {
			return false;
		}
	} 

	@Override
	public User findById(int userId) {
		User resultUser = new User();
		for ( User tempUser : this.getUsers()) {
			if (tempUser.getUserId() == userId) {
				resultUser = tempUser;
			}
		}
		return resultUser;
	}

	@Override
	public ArrayList<User> findAll() {
		return this.getUsers();
	}

}
