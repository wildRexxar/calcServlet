package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_user_status")
public class UpdateUserStatusServlet extends HttpServlet {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/updateUserStatus.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
        String login = req.getParameter("login");
        String statusStr = req.getParameter("status");
        boolean status = false;
        if(statusStr.equals("true")) {
            status = true;
        }
        inMemoryUserStorage.updateUserStatus(login, status );
            resp.sendRedirect("/users_list");
        } else {
            resp.sendRedirect("/");
        }
    }
}