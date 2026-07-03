package Servlet;

import java.io.IOException;
import java.sql.Timestamp;

import DAOimplement.OrderitemDAOImple;
import DAOimplement.OrdertableDAOImple;
import Model.Cart;
import Model.CartItem;
import Model.Orderitem;
import Model.Ordertable;
import Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedInUser");

        Cart cart = (Cart) session.getAttribute("cart");

        if (user == null || cart == null || cart.getItems().isEmpty()) {

            response.sendRedirect("login.jsp");
            return;
        }

        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");

        float totalAmount = Float.parseFloat(request.getParameter("totalAmount"));

        int restaurantId =
                cart.getItems().values().iterator().next().getRestaurantId();

        Ordertable order = new Ordertable();

        order.setUserId(user.getUserId());
        order.setRestaurantId(restaurantId);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setTotalAmount(totalAmount);
        order.setStatus("PLACED");
        order.setPaymentMethod(paymentMethod);

        OrdertableDAOImple orderDao = new OrdertableDAOImple();

        orderDao.addOrdertable(order);

        int orderId = orderDao.getLatestOrderId();

        OrderitemDAOImple itemDao = new OrderitemDAOImple();

        for(CartItem item : cart.getItems().values()){

            Orderitem oi = new Orderitem();

            oi.setOrderId(orderId);
            oi.setMenuId(item.getMenuId());
            oi.setQuantity(item.getQuantity());
            oi.setItemTotal(item.getPrice()*item.getQuantity());

            itemDao.addOrderitem(oi);
        }

        session.removeAttribute("cart");

        request.setAttribute("name", user.getUserName());
        request.setAttribute("email", user.getEmail());
        request.setAttribute("phone", phone);
        request.setAttribute("address", address);
        request.setAttribute("amount", totalAmount);

        request.getRequestDispatcher("confirmation.jsp")
               .forward(request, response);
        response.sendRedirect("confirmation.jsp");
     
    }
}