package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Room;
import com.epam.services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/approve_order")
public class AdminController extends HttpServlet {
    AdminService adminService;

    @Override
    public void init() throws ServletException {
       adminService = (AdminService) getServletContext().getAttribute(Constants.ADMIN_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long orderId = Long.parseLong(request.getAttribute("order_id").toString());
        Long roomId = Long.parseLong(request.getAttribute("room_id").toString());
        Room room = new Room();
        room.setRoomId(adminService.getARoom(roomId,orderId));
        request.setAttribute("roomId",room.getRoomId());
    }
}
