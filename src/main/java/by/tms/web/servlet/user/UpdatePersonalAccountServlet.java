package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePersonalAccount")
public class UpdatePersonalAccountServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") != null) {
            getServletContext().getRequestDispatcher("/pages/user/updatePersonalAccount.jsp").forward(req, resp);
        } else {resp.sendRedirect("/");}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            User user = (User) req.getSession().getAttribute("user");
            String newLogin = req.getParameter("login");
            String newPassword = req.getParameter("password");
            inMemoryUserStorage.updateUserInDB(newLogin, newPassword);
            resp.sendRedirect("/logout");
    }
}