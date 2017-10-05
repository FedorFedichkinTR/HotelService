package dao.interfaces;

public interface AbstractDAOFactory extends AutoCloseable {
    UserDAO createUserDAO();

    OrderDAO createOrderDAO();

    RoomDAO createRoomDAO();

    BillDAO createBillDAO();
}
