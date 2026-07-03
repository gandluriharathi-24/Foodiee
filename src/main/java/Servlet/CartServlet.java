package Servlet;

import java.io.IOException;

import DAOimplement.MenuDAOImple;
import Model.Cart;
import Model.CartItem;
import Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");

        if (action == null) action = "add";

        // ================= ADD ITEM =================
        if (action.equals("add")) {

            int menuId = Integer.parseInt(req.getParameter("MenuId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            MenuDAOImple dao = new MenuDAOImple();
            Menu menu = dao.getMenu(menuId);

            CartItem item = new CartItem(
                    menu.getMenuId(),
                    menu.getRestaurantId(),
                    menu.getItemName(),
                    menu.getPrice(),
                    quantity
            );

            cart.addItem(item);

            resp.sendRedirect("cart.jsp");
            return;
        }

        // ================= INCREASE =================
        if (action.equals("increase")) {

            int id = Integer.parseInt(req.getParameter("id"));

            CartItem item = cart.getItems().get(id);

            if (item != null) {
                cart.updateItem(id, item.getQuantity() + 1);
            }

            resp.sendRedirect("cart.jsp");
            return;
        }

        // ================= DECREASE =================
        if (action.equals("decrease")) {

            int id = Integer.parseInt(req.getParameter("id"));

            CartItem item = cart.getItems().get(id);

            if (item != null && item.getQuantity() > 1) {
                cart.updateItem(id, item.getQuantity() - 1);
            }

            resp.sendRedirect("cart.jsp");
            return;
        }

        // ================= REMOVE =================
        if (action.equals("remove")) {

            int id = Integer.parseInt(req.getParameter("id"));

            cart.removeItem(id);

            // go back to restaurant page
            resp.sendRedirect("callRestaurantservlet");
            return;
        }

        // default
        resp.sendRedirect("cart.jsp");
    }
}