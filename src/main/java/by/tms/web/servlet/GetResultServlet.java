package by.tms.web.servlet;

import by.tms.entity.Result;
import by.tms.storage.InMemoryResultStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class GetResultServlet extends HttpServlet {
    private final InMemoryResultStorage inMemoryResultStorage = new InMemoryResultStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("id") != null) {
            int userId = (Integer) req.getSession().getAttribute("id");
            List<Result> results = inMemoryResultStorage.getResult(userId);
            req.setAttribute("results", results);
            getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/");
        }
    }
}
