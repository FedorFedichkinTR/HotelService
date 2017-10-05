package dao.implementation;

import connection_pool.ConnectionPool;
import dao.h2.H2BillDAO;
import dao.h2.H2OrderDAO;
import dao.h2.H2RoomDAO;
import dao.h2.H2UserDAO;
import dao.interfaces.*;

public class H2DAOFactory implements AbstractDAOFactory {
    private final UserDAO userDAO;
    private final OrderDAO orderDAO;
    private final RoomDAO roomDAO;
    private final BillDAO billDAO;
    private final ConnectionPool connectionPool;

    public H2DAOFactory(ConnectionPool connectionPool){
        this.userDAO = new H2UserDAO(connectionPool);
        this.orderDAO = new H2OrderDAO(connectionPool);
        this.roomDAO = new H2RoomDAO(connectionPool);
        this.billDAO = new H2BillDAO(connectionPool);
        this.connectionPool = connectionPool;
    }


    @Override
    public UserDAO createUserDAO() {
        return null;
    }

    @Override
    public OrderDAO createOrderDAO() {
        return null;
    }

    @Override
    public RoomDAO createRoomDAO() {
        return null;
    }

    @Override
    public BillDAO createBillDAO() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
