package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Order;
import com.epam.model.User;
import com.epam.services.UserOrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user_orders")
public class GetUserOrdersController extends HttpServlet {
    private UserOrdersService userOrdersService;

    @Override
    public void init() throws ServletException {
        userOrdersService = (UserOrdersService) getServletContext().getAttribute(Constants.USER_ORDERS_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 11.10.2017 нужно вынести сервис в поле класса, ну и название сменить
        List<Order> listOfOrders = userOrdersService.getOrdersOfUser((User) request.getSession().getAttribute(Constants.USER_SESSION));
        request.setAttribute(Constants.LIST_OF_USER_ORDERS, listOfOrders);
        request.getRequestDispatcher("WEB-INF/myorders.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
