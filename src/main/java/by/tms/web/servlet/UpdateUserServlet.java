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
        String newLogin = req.getParameter("login");
        String newPassword = req.getParameter("password");
        int userId = (Integer) req.getSession().getAttribute("userId");
        if(inMemoryUserStorage.updateUserInDB(newLogin, newPassword, userId)) {
            resp.getWriter().println("rename successful");
        } else {
            resp.getWriter().println("error");
        }
    }
}