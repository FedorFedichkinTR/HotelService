package dao.interfaces;

import model.Order;

public interface OrderDAO {
    public Order create();

    public Order read(long readOrderID);

    public Order update(Order updatedOrder);

    public void delete(Order deletedOrder);

    public void insert(Order insertedOrder);
}
