package by.tms.web.servlet;

import by.tms.service.Calc;
import by.tms.storage.InMemoryResultStorage;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
        int userIndex = (Integer) req.getSession().getAttribute("userId");
        List<Double> nums = (List<Double>) req.getSession().getAttribute("listOfNumbers");
        String operation = req.getParameter("operation");
        double result = Calc.valueOf(operation).compute(nums.get(0), nums.get(1));
        inMemoryResultStorage.writeResultToDB(nums.get(0).toString(), operation, nums.get(1).toString(), Double.toString(result), userIndex);
        req.getSession().setAttribute("result", result);
        getServletContext().getRequestDispatcher("pages/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}