package com.example.springbootdockerexercise.dao;

import com.example.springbootdockerexercise.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);

        // UserDao add(user);
        User user = new User();
        user.setId("8");
        user.setName("hyunmok8");
        user.setPassword("1234589");
        userDao.add(user);

        // UserDao get(user);
        User selectedUser = userDao.get("8");
        System.out.println(selectedUser.getId());
        System.out.println(selectedUser.getName());
        System.out.println(selectedUser.getPassword());
    }
}
