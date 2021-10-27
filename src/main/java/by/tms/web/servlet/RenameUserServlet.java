package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rename")
public class RenameUserServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newLogin = req.getParameter("login");
        String newPassword = req.getParameter("password");
        User user = (User) req.getSession().getAttribute("user");
        if(inMemoryUserStorage.renameUser(newLogin, newPassword, user)) {
            resp.getWriter().println("rename successful");
        } else {
            resp.getWriter().println("error");
        }
    }
}