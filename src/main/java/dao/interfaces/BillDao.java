package dao.interfaces;

import model.Bill;

import java.util.List;

public interface BillDao extends CrudDao<Bill,Long> {
    public List<Bill> getAllBills();

    public List<Bill> getAllBillsByUserID(long userId);
}
