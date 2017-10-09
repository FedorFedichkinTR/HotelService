package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.UserDao;
import com.epam.model.Roles;
import com.epam.model.User;


public class RegistrationService {
    private AbstractDaoFactory daoFactory;

    public RegistrationService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * @return true - if new user is added to database, false - if in database there is a user with such mail
     */
    public boolean signUp(String userMail, String userPassword, String userFirstName, String userLastName) {
        //if in base there is no user with this mail - add him to the base
        //otherwise - error - user with this mail is already registered
        User newUser = new User();
        UserDao userDao = daoFactory.createUserDAO();
        newUser.setEmail(userMail);
        if (userDao.readByEmail(userMail).getUserID() == null) {
            newUser.setPassword(userPassword);
            newUser.setFirstName(userFirstName);
            newUser.setLastName(userLastName);
            newUser.setRole(Roles.USER);
            userDao.create(newUser);
            return true;
        } else {
            return false;
        }
    }
}
