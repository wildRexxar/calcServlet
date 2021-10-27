package by.tms.web.servlet;

import by.tms.entity.Result;
import by.tms.entity.User;
import by.tms.storage.InMemoryResultStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/history")
public class GetResultServlet extends HttpServlet {
    private final InMemoryResultStorage inMemoryResultStorage = new InMemoryResultStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        for (Result result : inMemoryResultStorage.showResults(user)) {
            resp.getWriter().println(result);
        }
    }
}
