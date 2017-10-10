package com.epam.dao.h2;

import com.epam.connection_pool.ConnectionPool;
import com.epam.dao.interfaces.*;
import com.epam.model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class H2BillDao implements BillDao {
    private final ConnectionPool connectionPool;

    private static final String CREATE_BILL_SQL =
            "INSERT INTO Bills (user_id, room_id, admin_id, order_id, price, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String READ_BILL_BY_ID =
            "SELECT user_id, room_id, admin_id, order_id, price, status FROM Bills WHERE bill_id = ?";
    private static final String UPDATE_BILL_SQL =
            "UPDATE Bills SET user_id = ?, room_id = ?, admin_id = ?, order_id = ?, price = ?, status =? WHERE bill_id = ?";
    private static final String DELETE_BILL_SQL =
            "DELETE FROM Bills WHERE bill_id = ?";
    private static final String GET_ALL_ORDERS_SQL =
            "SELECT order_id, user_id, room_id, capacity, type, status, start_date, end_date FROM Users";

    public H2BillDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Long create(Bill bill) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_BILL_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, bill.getUserID());
            statement.setLong(2, bill.getRoomID());
            statement.setLong(3, bill.getAdminID());
            statement.setLong(4, bill.getOrderID());
            statement.setInt(5, bill.getPrice());
            statement.setBoolean(6, bill.getStatus());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Bill read(Long billId) {
        Bill bill = new Bill();

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(READ_BILL_BY_ID)) {
            statement.setLong(1, billId);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                bill.setUserID(resultSet.getLong("user_id"));
                bill.setRoomID(resultSet.getLong("room_id"));
                bill.setAdminID(resultSet.getLong("admin_id"));
                bill.setOrderID(resultSet.getLong("order_id"));
                bill.setPrice(resultSet.getInt("price"));
                bill.setStatus(resultSet.getBoolean("status"));
                bill.setBillID(billId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }

    @Override
    public Boolean update(Bill bill) {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BILL_SQL)) {
            statement.setLong(1, bill.getUserID());
            statement.setLong(2, bill.getRoomID());
            statement.setLong(3, bill.getAdminID());
            statement.setLong(4, bill.getOrderID());
            statement.setInt(5, bill.getPrice());
            statement.setBoolean(6, bill.getStatus());
            statement.setLong(7, bill.getBillID());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();//todo add to LOG
        }
        return false;
    }

    @Override
    public Long deleteById(Long billId) {
        return delete(billId, connectionPool, DELETE_BILL_SQL);
    }

    @Override
    //TODO
    public List<Bill> getAllBills() {
//        try(Connection connection = connectionPool.takeConnection();
//       // PreparedStatement statement = connection.prepareStatement()) {
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    //TODO
    public List<Bill> getAllBillsByUserID(long userId) {
        return null;
    }
}
