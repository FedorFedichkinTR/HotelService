package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Order;
import com.epam.model.User;
import com.epam.services.ViewUserOrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userOrders")
public class GetUserOrdersController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUserOrdersService viewOrders = (ViewUserOrdersService) request.getServletContext().getAttribute(Constants.VIEW_USER_ORDERS_SERVICE);
        List<Order> listOfOrders = viewOrders.getOrdersOfUser((User) request.getSession().getAttribute(Constants.USER_SESSION));
        request.setAttribute(Constants.LIST_OF_USER_ORDERS, listOfOrders);
        request.getRequestDispatcher("temp/myorders.jsp").forward(request, response);
    }
}
