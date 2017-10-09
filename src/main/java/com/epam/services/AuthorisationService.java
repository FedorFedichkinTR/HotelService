package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.model.User;

public class AuthorisationService {
    private AbstractDaoFactory daoFactory;

    public AuthorisationService() {
    }

    public AuthorisationService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public User getUser(String loginFromRequest) {
        User user = null;
        user = daoFactory.createUserDAO().readByEmail(loginFromRequest);
        return user;
    }

    public boolean checkPassword(String passwordfromRequest, User user) {
        return user.getPassword().equals(passwordfromRequest);
    }
}
