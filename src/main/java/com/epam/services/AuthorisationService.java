package com.epam.services;

import com.epam.dao.interfaces.AbstractDaoFactory;
import com.epam.dao.interfaces.UserDao;
import com.epam.exceptions.UnmatchedPassword;
import com.epam.exceptions.UserDoesNotExist;
import com.epam.model.User;
import lombok.extern.log4j.Log4j;

import static com.epam.util.Encoder.encode;

/**
 * Authorise user, checks his password.
 */
@Log4j
public class AuthorisationService {
    private UserDao userDao;

    public AuthorisationService() {
    }

    public AuthorisationService(AbstractDaoFactory daoFactory) {
        this.userDao = daoFactory.createUserDAO();
    }

    /**
     * Checks if password from form and password of this user in database are the same.
     *
     * @param passwordFromRequest - input password
     * @param user                - use, found by email
     * @return true, if password matches, false otherwise
     */
    private boolean checkPassword(String passwordFromRequest, User user) {
        String encodedPasswordFromRequest = encode(passwordFromRequest);
        return encodedPasswordFromRequest.equals(user.getPassword());
    }

    /**
     * Log in for user. Gets user from database by email, if this user exists, check whether passwords match.
     *
     * @param userMail
     * @param userPassword
     * @return logged in user
     */
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
