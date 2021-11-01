package by.tms.web.servlet;

import by.tms.storage.InMemoryResultStorage;
import by.tms.storage.InMemoryUserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    private final InMemoryResultStorage inMemoryResultStorage = new InMemoryResultStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userId") != null) {
            int id = (Integer) req.getSession().getAttribute("userId");
            inMemoryUserStorage.delete(id);
            inMemoryUserStorage.delete(id);
            resp.sendRedirect("/");
        }
    }
}