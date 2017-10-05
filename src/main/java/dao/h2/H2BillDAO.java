package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.BillDAO;
import dao.interfaces.UserDAO;
import model.Bill;
import model.User;

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
    public void insert(Bill bill) {

    }

    @Override
    public List<Bill> getAllBills() {
        return null;
    }

    @Override
    public List<Bill> getAllBillsByUserID(long userId) {
        return null;
    }
}
