package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.services.ViewAllOrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class GetAllOrdersController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewAllOrdersService viewOrders = (ViewAllOrdersService) request.getServletContext().getAttribute(Constants.VIEW_ALL_ORDERS_SERVICE);
        request.setAttribute(Constants.LIST_OF_ALL_ORDERS, viewOrders.getAllOrders());
        request.getRequestDispatcher("temp/adminpage.jsp").forward(request,response);
    }
}
