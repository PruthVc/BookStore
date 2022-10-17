package com.fdmgroup.bookstore.data;

import com.fdmgroup.bookstore.model.User;

public interface UserRepository extends Persistable , Removeable, Searchable{
	boolean validate(String username, String password);
	User findByUsername(String username);
}
