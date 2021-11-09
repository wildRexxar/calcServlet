package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users_list")
public class GetUserListServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/usersList.jsp").forward(req, resp);
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getStatus()) {
            List<User> listOfUsers = inMemoryUserStorage.getAllUsersFromDB();
            req.getSession().setAttribute("list", listOfUsers);
        } else {
            resp.sendRedirect("/");
        }
    }
}
