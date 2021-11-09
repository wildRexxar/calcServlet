package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeletingPersonalAccountServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            inMemoryUserStorage.deleteAccount(user.getLogin());
            resp.sendRedirect("/logout");
        } else {
            resp.sendRedirect("/");
        }
    }
}