package dao.interfaces;

import model.Bill;
import model.User;

import java.util.List;
import java.util.Map;

public interface BillDAO {
    public Bill read(long billID);

    public void update(Bill bill);

    public void delete(Bill bill);

    public void insert(Bill bill);

    public List<Bill> getAllBills();

    public List<Bill> getAllBillsByUserID(long userId);
}
