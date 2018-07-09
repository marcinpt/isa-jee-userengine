package com.isa.userengine.dao;

import com.isa.userengine.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersRepositoryDao {
    User addUser(User u);
    User getUserByld(int id);
    List<User> getUsersList();
}
