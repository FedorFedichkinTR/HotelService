package dao.interfaces;

import model.User;

import java.util.List;

public interface UserDAO {
    public User readByID(long reaUserID);

    public User readByEmail(String eMail);

    public User update(User updatedUser);

    public void delete(User deletedUser);

    public Long insert(User insertedUser);

    public List<User> getAllUsers();
}
