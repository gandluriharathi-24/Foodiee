

package Servlet;

import java.io.IOException;

import DAOimplement.UserDAOimplement;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserDAOimplement dao = new UserDAOimplement();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate user from database
        User user = dao.validateUser(email, password);

        if (user != null) {

            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);

            // Redirect to restaurant page
            response.sendRedirect("callRestaurantservlet");

        } else {

            // Show error on the same login page
            request.setAttribute("error", "Invalid Email or Password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    

        
        
        
    }
}

















































//package Servlet;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/LoginServlet")
//public class LoginServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        System.out.println("Email : " + email);
//        System.out.println("Password : " + password);
//
//        // Temporary Login Check
//        if(email.equals("admin@gmail.com") &&
//           password.equals("1234")) {
//
//            response.sendRedirect("RestaurantServlet");
//
//        } else {
//
//            response.getWriter().println(
//                "<h2>Invalid Email or Password</h2>"
//            );
//        }
//    }
//}