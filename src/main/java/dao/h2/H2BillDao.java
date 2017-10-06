package dao.h2;

import connection_pool.ConnectionPool;
import dao.interfaces.*;
import model.Bill;

import java.util.List;

public class H2BillDao implements BillDao {
    private final ConnectionPool connectionPool;

    public H2BillDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Long create(Bill entity) {
        return null;
    }

    @Override
    public Bill read(Long id) {
        return null;
    }

    @Override
    public Long update(Bill entity) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
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
