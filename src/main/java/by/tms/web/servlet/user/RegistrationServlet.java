package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            getServletContext().getRequestDispatcher("/pages/user/registration.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (!login.matches("\\s*") && !password.matches("\\s*") && login != null && password != null) {
                User user = new User(login, password);
                if (inMemoryUserStorage.checkLogin(user) == false) {
                    inMemoryUserStorage.saveUserInDB(user);
                    req.setAttribute("message1", "Registration completed successfully");
                } else {
                    req.setAttribute("message2", "This user exist");
                }
            } else {
                req.setAttribute("message2", "wrong login or password");
            }
            getServletContext().getRequestDispatcher("/pages/user/registration.jsp").forward(req, resp);
        }
    }
}