package com.isa.userengine.dao;

import com.isa.userengine.domain.User;
import com.isa.userengine.repository.UsersRepository;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao{
    @Override
    public User addUser(User u) {
        UsersRepository.getRepository().add(u);
        return u;
    }

    @Override
    public User getUserByld(int id) {
        return UsersRepository.getRepository().stream().filter(user ->user.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<User> getUsersList() {
        return UsersRepository.getRepository();
    }
}
