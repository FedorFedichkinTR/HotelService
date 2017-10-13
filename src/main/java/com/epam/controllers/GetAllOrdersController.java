package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Order;
import com.epam.services.ViewAllOrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin")
public class GetAllOrdersController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewAllOrdersService viewOrders = (ViewAllOrdersService) request.getServletContext().getAttribute(Constants.VIEW_ALL_ORDERS_SERVICE);
        List<Order> orders = viewOrders.getAllOrders();
        Map<Long,List> freeRoomsForAllOrders = new HashMap<>();
        for (Order order : orders) {
            if(order.getRoomID()!=0L) {
                List<Long> freeRooms = viewOrders.getFreeRooms(order);
                freeRoomsForAllOrders.put(order.getOrderID(),freeRooms);
            }
        }
        request.setAttribute(Constants.MAP_OF_FREE_ROOMS_FOR_ALL_ORDERS, freeRoomsForAllOrders);
        request.setAttribute(Constants.LIST_OF_ALL_ORDERS, orders);
        request.getRequestDispatcher("/WEB-INF/adminpage.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
