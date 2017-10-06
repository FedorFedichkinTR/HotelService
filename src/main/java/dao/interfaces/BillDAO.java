package dao.interfaces;

import model.Bill;
import model.User;

import java.util.List;
import java.util.Map;

public interface BillDAO extends DAOCRUD<Bill,Long> {
    public List<Bill> getAllBills();

    public List<Bill> getAllBillsByUserID(long userId);
}
