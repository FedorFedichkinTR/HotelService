package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.UserDao;
import com.epam.exceptions.UnmatchedPassword;
import com.epam.exceptions.UserDoesNotExist;
import com.epam.model.Role;
import com.epam.model.User;
import com.epam.util.Encoder;

import java.security.NoSuchAlgorithmException;

public class AuthorisationService {
    //private AbstractDaoFactory daoFactory;
    private UserDao userDao;

    public AuthorisationService() {
    }

    public AuthorisationService(AbstractDaoFactory daoFactory) {
        this.userDao = daoFactory.createUserDAO();
    }

    private boolean checkPassword(String passwordFromRequest, User user) {
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

    public User authorize(String userMail, String userPassword) throws UserDoesNotExist, UnmatchedPassword {
        User byEmail = userDao.readByEmail(userMail);
        if (byEmail == null) {
            throw new UserDoesNotExist("This user is not registered");
        }

        if (!checkPassword(userPassword, byEmail)) {
            throw new UnmatchedPassword("Invalid password");
        }
        return byEmail;
    }
}
