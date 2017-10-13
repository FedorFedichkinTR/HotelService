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
    private BookingService bookingService;

    @Override
    public void init() throws ServletException {
        bookingService = (BookingService) getServletContext().getAttribute(Constants.BOOKING_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        order.setUserID(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getUserID());
        order.setRoomCapacity(Integer.parseInt(request.getParameter("number-of-people")));
        order.setRoomType(RoomType.valueOf(request.getParameter("room-type")));
        order.setStartDate(LocalDate.parse(request.getParameter("arrival"), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        order.setEndDate(LocalDate.parse(request.getParameter("departure"), DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        if (bookingService.bookRoom(order) != null) {
            request.getRequestDispatcher("/user_orders").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/booking.jsp").forward(request, response);
        }
    }
}
