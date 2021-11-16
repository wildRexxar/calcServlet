package by.tms.web.servlet.user;

import by.tms.entity.Result;
import by.tms.entity.User;
import by.tms.storage.InMemoryResultStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listOfResults")
public class GetResultsServlet extends HttpServlet {
    private final InMemoryResultStorage inMemoryResultStorage = new InMemoryResultStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            List<Result> listOfResults = inMemoryResultStorage.getListOfResults(user.getLogin());
            req.setAttribute("listOfResults", listOfResults);
            getServletContext().getRequestDispatcher("/pages/user/resultHistory.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/");
        }
    }
}