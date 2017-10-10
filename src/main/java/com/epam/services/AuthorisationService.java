package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.model.User;
import com.epam.util.Encoder;

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

    public boolean checkPassword(String passwordFromRequest, User user) {
        String encodedPasswordFromRequest = Encoder.encode(passwordFromRequest);
        return encodedPasswordFromRequest.equals(user.getPassword());
    }
}
