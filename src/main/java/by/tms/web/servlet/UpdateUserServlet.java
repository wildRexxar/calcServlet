package by.tms.web.servlet;

import by.tms.storage.InMemoryUserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("id") != null) {
            String newLogin = req.getParameter("login");
            String newPassword = req.getParameter("password");
            int id = (Integer) req.getSession().getAttribute("id");
            inMemoryUserStorage.update(newLogin, newPassword, id);
            resp.sendRedirect("/userPage");
//            getServletContext().getRequestDispatcher("/userPage").forward(req, resp);
        } else {
            resp.sendRedirect("/");
        }
    }
}