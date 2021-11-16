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
            getServletContext().getRequestDispatcher("/pages/user/authorization.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = inMemoryUserStorage.getUserFromDB(new User(login, password));
        System.out.println(user);
        if (user != null) {
            if(user.getPassword().equals(password)){
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/userPage");
                return;
            } else {
                req.setAttribute("message", "Wrong password");
            }
        } else {
            req.setAttribute("message", "Wrong login or password");
        }
        getServletContext().getRequestDispatcher("/pages/user/authorization.jsp").forward(req, resp);
    }
}