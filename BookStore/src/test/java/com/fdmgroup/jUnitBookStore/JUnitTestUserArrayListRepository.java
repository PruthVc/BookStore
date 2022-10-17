package com.fdmgroup.jUnitBookStore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.fdmgroup.bookstore.data.UserArrayListRepository;
import com.fdmgroup.bookstore.model.Order;
import com.fdmgroup.bookstore.model.User;

public class JUnitTestUserArrayListRepository {

	@Test 
	public void testing_UserArrayRepository_getUsers_withParameterizedConstructor() {
		User user1forTest1 = new User();
		User user2forTest1 = new User();
		ArrayList<User> usersArrayListforTest1 = new ArrayList<User>();
		usersArrayListforTest1.add(user1forTest1);
		usersArrayListforTest1.add(user2forTest1);
		UserArrayListRepository userArrayListRepositoryforTest1 = new UserArrayListRepository(usersArrayListforTest1);
		assertEquals(usersArrayListforTest1, userArrayListRepositoryforTest1.getUsers());
	}
	@Test
	public void testing_UserArrayRepository__userValidation() {
		ArrayList<Order> ordersArrayListForTest2= new ArrayList<Order>();
		User user1forTest2 = new User( "Adam", "Grant", "AGrant","root", "email", ordersArrayListForTest2);
		User user2forTest2 = new User( "Kyle", "Franks", "KFranks","admin", "email", ordersArrayListForTest2);
		ArrayList<User> usersArrayListforTest2 = new ArrayList<User>();
		usersArrayListforTest2.add(user1forTest2);
		usersArrayListforTest2.add(user2forTest2);
		UserArrayListRepository userArrayListRepositoryForTest2 = new UserArrayListRepository(usersArrayListforTest2);
		//should return True
		assertTrue( userArrayListRepositoryForTest2.validate("AGrant", "root"));
		// should return false
		assertFalse( userArrayListRepositoryForTest2.validate("AGran", "root"));
	}
	@Test
	public void testing_UserArrayRepository_findByUserName() {
		ArrayList<Order> ordersArrayListForTest3= new ArrayList<Order>();
		User user1ForTest3 = new User( "Adam", "Grant", "AGrant","root", "email", ordersArrayListForTest3);
		User user2ForTest3 = new User( "Kyle", "Franks", "KFranks","admin", "email", ordersArrayListForTest3);
		ArrayList<User> usersArrayListForeTest3 = new ArrayList<User>();
		usersArrayListForeTest3.add(user1ForTest3);
		usersArrayListForeTest3.add(user2ForTest3);
		UserArrayListRepository userArrayListRepositoryForTest3 = new UserArrayListRepository(usersArrayListForeTest3);
		// find user by name should return the user object with matching username
		assertEquals( user1ForTest3, userArrayListRepositoryForTest3.findByUsername(user1ForTest3.getUsername()));
		//returns null if username not in the users ArrayList<User>
		assertNull(userArrayListRepositoryForTest3.findByUsername("Pruthvi"));
	}
	@Test  
	public void testing_UserArrayRepository_saveMethod_With_UpdateIfExistsFeature() {
		ArrayList<Order> ordersArrayListForTest4= new ArrayList<Order>();
		User user1ForTest4 = new User( "Adam", "Grant", "AGrant","root", "email", ordersArrayListForTest4);
		UserArrayListRepository userArrayListRepositoryForTest4 = new UserArrayListRepository();
		//adding and Saving a new User to uerArrayrepository using save method
		User resultUser=userArrayListRepositoryForTest4.save(user1ForTest4);
		assertEquals(user1ForTest4,resultUser); 
		//trying to add and save an existing user with different password the method should update the user. 
		user1ForTest4.setPassword("NewPassword");
		User resultUser2=userArrayListRepositoryForTest4.save(user1ForTest4);
		assertEquals(user1ForTest4, resultUser2);
	}	
	@Test
	public void testing_removeMethod() {
		ArrayList<Order> ordersArrayListForTest5 = new ArrayList<Order>();
		User user1Test5 = new User("Lilly", "White", "LWhite", "lil", "email", ordersArrayListForTest5);
		User user2Test5 = new User("Sarah", "Davis", "SDavic", "sara", "email", ordersArrayListForTest5);
		UserArrayListRepository userArrayListRepositoryForTest5 = new UserArrayListRepository();
		userArrayListRepositoryForTest5.save(user1Test5);
		// deleting the user1 which is saved in users arrayList should return true;
		assertTrue(userArrayListRepositoryForTest5.delete(user1Test5));
		// deleting the user1 which is NOT saved in users arrayList should return false;
		assertFalse(userArrayListRepositoryForTest5.delete(user2Test5));
	}	 
	@Test
	public void testing_generateIdMethod_shouldReturn_returnNextId() {
		int nextId = UserArrayListRepository.getID();
		assertEquals(nextId, UserArrayListRepository.generateId()); 
	}
	@Test
	public void testing_findByIdMethod_shouldReturn_userHavingSElectedUserId() {
		ArrayList<Order> ordersForTest7= new ArrayList<Order>();
		User user1ForTest7 = new User( "Sarah", "Davis", "SDavic","sara", "email", ordersForTest7);
		User user2ForTest7 = new User( "Soni", "Kenny", "SKenny","ken", "email", ordersForTest7);
		User user3ForTest7 = new User( "Mark", "Cubban", "MShark","Shark", "email", ordersForTest7);
		UserArrayListRepository userArrayListRepositoryForTest7 = new UserArrayListRepository();
		userArrayListRepositoryForTest7.save(user1ForTest7);
		userArrayListRepositoryForTest7.save(user2ForTest7);
		userArrayListRepositoryForTest7.save(user3ForTest7);
		assertEquals(user1ForTest7, userArrayListRepositoryForTest7.findById(user1ForTest7.getUserId())); 
	}
	@Test
	public void testing_findAllMethod_shouldReturn_allUsersInTheSystem() {
		ArrayList<Order> ordersForTest8= new ArrayList<Order>();
		User user1ForTest8 = new User( "Sarah", "Davis", "SDavic","sara", "email", ordersForTest8);
		User user2ForTest8 = new User( "Soni", "Kenny", "SKenny","ken", "email", ordersForTest8);
		User user3ForTest8 = new User( "Mark", "Cubban", "MShark","Shark", "email", ordersForTest8);
		ArrayList<User> actualArrayListOfUsersforTest8 = new ArrayList<User>();
		ArrayList<User> expectedArrayListOfUsersforTest8 = new ArrayList<User>();
		UserArrayListRepository userArrayListRepositoryForTest8 = new UserArrayListRepository();
		userArrayListRepositoryForTest8.save(user1ForTest8);
		userArrayListRepositoryForTest8.save(user2ForTest8);
		userArrayListRepositoryForTest8.save(user3ForTest8);
		actualArrayListOfUsersforTest8 = userArrayListRepositoryForTest8.findAll();
		expectedArrayListOfUsersforTest8.add(user1ForTest8);
		expectedArrayListOfUsersforTest8.add(user2ForTest8);
		expectedArrayListOfUsersforTest8.add(user3ForTest8);
		assertEquals(expectedArrayListOfUsersforTest8, actualArrayListOfUsersforTest8);	
	}
	
}


