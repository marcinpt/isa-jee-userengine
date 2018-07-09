package com.isa.userengine;

import com.isa.userengine.dao.UsersRepositoryDaoBean;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World");

        UsersRepositoryDaoBean users = new UsersRepositoryDaoBean();
        users.getUsersList().stream().map(user -> user.getName()).forEach(System.out::println);
    }
}
