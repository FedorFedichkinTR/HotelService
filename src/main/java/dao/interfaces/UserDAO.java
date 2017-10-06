package dao.interfaces;

import model.User;

import java.util.List;

public interface UserDAO extends DAOCRUD<User,Long> {
    public User readByEmail(String eMail);

    public List<User> getAllUsers();
}
