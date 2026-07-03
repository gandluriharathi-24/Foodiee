package Servlet;

import java.io.IOException;
import java.util.List;

import DAOimplement.RestaurantDAOImple;
import Model.restarunt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/callRestaurantservlet")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RestaurantDAOImple restaurantDAO = new RestaurantDAOImple();

        List<restarunt> allRestaurant = restaurantDAO.getAllRestaurant();
        
//        System.out.println("Restaurant Count = " + allRestaurant.size());

        req.setAttribute("restaurant", allRestaurant);

        req.getRequestDispatcher("restarunt.jsp")
           .forward(req, resp);
    }
}