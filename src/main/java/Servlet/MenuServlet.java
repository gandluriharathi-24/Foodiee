package Servlet;

import java.io.IOException;
import java.util.List;

import DAOimplement.MenuDAOImple;
import Model.Menu;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("restaurantId");

        System.out.println("Restaurant ID = " + id);

        int restaurantId = Integer.parseInt(id);

        MenuDAOImple dao = new MenuDAOImple();

        List<Menu> menuList = dao.getMenuByRestaruntId(restaurantId);

        System.out.println("Menu Size = " + menuList.size());

        req.setAttribute("getMenuByRestaruntId", menuList);

        RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
        rd.forward(req, resp);
    }
}