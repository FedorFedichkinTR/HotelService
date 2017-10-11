package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.model.Role;
import com.epam.model.User;
import com.epam.util.Encoder;

import java.security.NoSuchAlgorithmException;

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
        if (user.getRole() == Role.ADMINISTRATOR) {
            return passwordFromRequest.equals(user.getPassword());
        } else {
            try {
                final Encoder encoder = new Encoder();
                String encodedPasswordFromRequest = encoder.encode(passwordFromRequest);
                return encodedPasswordFromRequest.equals(user.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
