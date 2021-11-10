package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") == null) {
            getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/userPage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = inMemoryUserStorage.getUserFromDB(new User(login, password));
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/userPage");
        } else {
            resp.sendRedirect("/");
        }
    }
}