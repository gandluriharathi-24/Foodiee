package Servlet;

import java.io.IOException;

import DAOimplement.UserDAOimplement;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        User user = new User();

        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setRole("customer");

        UserDAOimplement dao = new UserDAOimplement();

        dao.addUser(user);

        response.sendRedirect("login.jsp");
    }
}