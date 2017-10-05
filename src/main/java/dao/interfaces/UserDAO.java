package dao.interfaces;

import model.User;

public interface UserDAO {
    public User create();

    public User read(long reaUserID);

    public User read(String eMail);

    public User update(User updatedUser);

    public void delete(User deletedUser);

    public void insert(User insertedUser);
}
