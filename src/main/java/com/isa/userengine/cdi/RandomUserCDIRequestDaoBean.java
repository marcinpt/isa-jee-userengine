package com.isa.userengine.cdi;

import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.User;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.Random;

@RequestScoped
public class RandomUserCDIRequestDaoBean implements RandomUserCDIRequestDao {

    int index = Math.abs(new Random().nextInt()) % 3;

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    public User getRandomUser() {
        return usersRepositoryDao.getUsersList().get(index);
    }
}
