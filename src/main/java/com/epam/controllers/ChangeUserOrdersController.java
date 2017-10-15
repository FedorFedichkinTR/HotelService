package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Order;
import com.epam.model.RoomType;
import com.epam.model.User;
import com.epam.services.ChangeUserOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/change_user_orders")
public class ChangeUserOrdersController extends HttpServlet {
    private ChangeUserOrderService changeOrderService;

    @Override
    public void init() throws ServletException {
        changeOrderService = (ChangeUserOrderService) getServletContext().getAttribute(Constants.CHANGE_USER_ORDER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("delete") != null) {
            Long orderId = Long.parseLong(request.getParameter("order_to_delete"));
            if (changeOrderService.isBelongToUser((User) request.getSession().getAttribute(Constants.USER_SESSION), orderId)) {
                changeOrderService.deleteOrder(orderId);
                request.getRequestDispatcher("/user_orders").forward(request, response);
            }
        }
        if (request.getParameter("pay_up_order") != null) {
            Long orderId = Long.parseLong(request.getParameter("order_to_pay"));
            if (changeOrderService.payOrder(orderId)) {
                response.getWriter().append("true");
            }
        }
        if (request.getParameter("capacity") != null) {
            Order changedOrder = new Order();
            //changedOrder.setUserID(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getUserID());
            changedOrder.setRoomCapacity(Integer.parseInt(request.getParameter("capacity")));
            changedOrder.setRoomType(RoomType.valueOf((request.getParameter("room_type")).toUpperCase()));
            changedOrder.setStartDate(LocalDate.parse(request.getParameter("arrival"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            changedOrder.setEndDate(LocalDate.parse(request.getParameter("departure"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            changedOrder.setOrderID(Long.parseLong(request.getParameter("order_id")));
            if (changeOrderService.changeOrder(changedOrder) != null) {
                response.getWriter().append("true");
            }
        }
    }
}