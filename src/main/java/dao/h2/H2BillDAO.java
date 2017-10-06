package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.*;
import model.Bill;

import java.util.List;

public class H2BillDAO implements BillDAO{
    private final ConnectionPool connectionPool;

    public H2BillDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Bill read(long billID) {
        return null;
    }

    @Override
    public void update(Bill bill) {

    }

    @Override
    public void delete(Bill bill) {

    }

    @Override
    public void create(Bill bill) {

    }

    @Override
    public List<Bill> getAllBills() {
        return null;
    }

    @Override
    public List<Bill> getAllBillsByUserID(long userId) {
        return null;
    }

    public static class H2DAOFactory implements AbstractDAOFactory {
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
            return userDAO;
        }

        @Override
        public OrderDAO createOrderDAO() {
            return orderDAO;
        }

        @Override
        public RoomDAO createRoomDAO() {
            return null;
        }

        @Override
        public BillDAO createBillDAO() {
            return billDAO;
        }

        @Override
        public void close() throws Exception {
        }
    }
}
