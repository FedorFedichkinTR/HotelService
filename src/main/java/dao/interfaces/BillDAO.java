package dao.interfaces;

import model.Bill;

public interface BillDAO {
    public Bill create();

    public Bill read(long billID);

    public void update(Bill bill);

    public void delete(Bill bill);

    public void insert(Bill bill);

}
