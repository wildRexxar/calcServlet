package by.tms.web.servlet.admin;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminService")
public class AdminServiceServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/adminService.jsp").forward(req, resp);
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getStatus()) {
            List<User> listOfUsers = inMemoryUserStorage.getAllUsersFromDB();
            req.getSession().setAttribute("listOfUsers", listOfUsers);
        } else {
            resp.sendRedirect("/");
        }
    }
}
