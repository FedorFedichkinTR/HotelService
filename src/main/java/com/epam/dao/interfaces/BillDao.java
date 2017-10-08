package com.epam.dao.interfaces;

import com.epam.model.Bill;

import java.util.List;

interface BillDao extends CrudDao<Bill,Long> {
    public List<Bill> getAllBills();

    public List<Bill> getAllBillsByUserID(long userId);
}
