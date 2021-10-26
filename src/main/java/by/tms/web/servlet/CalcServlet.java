package by.tms.web.servlet;

import by.tms.service.Calc;
import by.tms.storage.InMemoryResultStorage;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
    private final InMemoryResultStorage inMemoryResultStorage = new InMemoryResultStorage();
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (inMemoryUserStorage.getUserIndex() > -1) {
            List<Double> nums = (List<Double>) req.getSession().getAttribute("listOfNumbers");
            String operation = (String) req.getSession().getAttribute("operation");
            if(nums == null) {
                resp.getWriter().println("invalid number format");
            }
            if (operation == null) {
                resp.getWriter().println("invalid operator");
            } else {
                double result = Calc.valueOf(operation).compute(nums.get(0), nums.get(1));
                System.out.println(result);
                resp.getWriter().println("RESULT = " + result);
                inMemoryResultStorage.addResult(nums.get(0) + " " + operation + " " + nums.get(1), Double.toString(result));
            }
        } else {
            resp.getWriter().println("unknown user");
        }
    }
}