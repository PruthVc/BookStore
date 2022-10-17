package com.fdmgroup.bookstore.data;

import com.fdmgroup.bookstore.model.User;

public interface Removeable {
	boolean delete(User user);
}
