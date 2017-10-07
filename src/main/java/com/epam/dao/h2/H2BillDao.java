package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.*;
import com.epam.model.Bill;

import java.util.List;

public class H2BillDao implements BillDao {
    private final ConnectionPool connectionPool;

    private static final String CREATE_BILL_SQL =
            "INSERT INTO Bills (user_id, room_id, admin_id, order_id, price, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String READ_BILL_BY_ID =
            "SELECT user_id, room_id, admin_id, order_id, price, status FROM Bills WHERE bill_id = ?";
    private static final String UPDATE_BILL_SQL =
            "UPDATE Bills SET user_id = ?, room_id = ?, admin_id = ?, order_id = ?, price = ?, status =? WHERE bill_id = ?";
    private static final String DELETE_ROOM_SQL =
            "DELETE FROM Bills WHERE bill_id = ?";

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
    public Long deleteById(Long id) {
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
