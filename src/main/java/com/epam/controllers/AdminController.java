package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Room;
import com.epam.model.User;
import com.epam.services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet takes information from page adminpage.jsp, when administrator wants to approve order
 * and choose room number for order, calls function from AdminService to set room id for order.
 */
@WebServlet("/approve_order")
public class AdminController extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = (AdminService) getServletContext().getAttribute(Constants.ADMIN_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long orderId = Long.parseLong(request.getParameter("order_id"));
        Long roomId = Long.parseLong(request.getParameter("room_id"));
        Room room = new Room();
        room.setRoomId(adminService.getARoom(roomId, orderId, ((User) request.getSession().getAttribute(Constants.USER_SESSION)).getUserID()));
        response.getWriter().append(roomId.toString());
    }
}
