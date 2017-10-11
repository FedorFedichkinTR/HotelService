package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.UserDao;
import com.epam.exceptions.UnmatchedPassword;
import com.epam.exceptions.UserDoesNotExist;
import com.epam.model.Role;
import com.epam.model.User;
import com.epam.util.Encoder;
import lombok.extern.log4j.Log4j;

import java.security.NoSuchAlgorithmException;

import static com.epam.util.Encoder.encode;

@Log4j
public class AuthorisationService {
    //private AbstractDaoFactory daoFactory;
    private UserDao userDao;

    public AuthorisationService() {
    }

    public AuthorisationService(AbstractDaoFactory daoFactory) {
        this.userDao = daoFactory.createUserDAO();
    }

    private boolean checkPassword(String passwordFromRequest, User user) {
        String encodedPasswordFromRequest = encode(passwordFromRequest);
        return encodedPasswordFromRequest.equals(user.getPassword());
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
