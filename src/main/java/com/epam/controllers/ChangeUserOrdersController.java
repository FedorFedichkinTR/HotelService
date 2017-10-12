package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.services.ChangeUserOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change_user_orders")
public class ChangeUserOrdersController extends HttpServlet {
    private ChangeUserOrderService changeOrderService;

    @Override
    public void init() throws ServletException {
        changeOrderService = (ChangeUserOrderService) getServletContext().getAttribute(Constants.CHANGE_USER_ORDER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("order_to_delete")!=null) {
            Long orderId = Long.parseLong(request.getParameter("order_to_delete"));
            changeOrderService.deleteOrder(orderId);
            request.getRequestDispatcher("/user_orders").forward(request, response);
        }
    }
}
