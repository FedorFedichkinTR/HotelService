package dao.interfaces;

public interface AbstractDAOFactory {
    UserDAO createUserDAO();

    OrderDAO createOrderDAO();

    RoomDAO createRoomDAO();

    BillDAO createBillDAO();
}
