package com.epam.controllers;

import com.epam.constants.Constants;
import com.epam.model.Order;
import com.epam.model.RoomType;
import com.epam.model.User;
import com.epam.services.BookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/order")
public class BookingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        order.setUserID(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getUserID());
        order.setRoomCapacity(Integer.parseInt(request.getParameter("numberOfPeople")));
        String typeOfRoom = request.getParameter("roomType");
        order.setRoomType(RoomType.valueOf(typeOfRoom.toUpperCase()));
        System.out.println(order.getRoomType());
        order.setStartDate(LocalDate.parse(request.getParameter("arrival"), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        order.setEndDate(LocalDate.parse(request.getParameter("departure"), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        BookingService bookingService = (BookingService) request.getServletContext().getAttribute(Constants.BOOKING_SERVICE);
        if (bookingService.bookRoom(order) != null) {
            request.getRequestDispatcher("/userOrders").forward(request, response);
        } else {
            request.getRequestDispatcher("temp/booking.jsp").forward(request, response);
        }
    }
}
