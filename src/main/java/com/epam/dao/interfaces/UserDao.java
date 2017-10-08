package com.epam.dao.interfaces;

import com.epam.model.User;

import java.util.List;

interface UserDao extends CrudDao<User,Long> {
    public User readByEmail(String eMail);

    public List<User> getAllUsers();
}
