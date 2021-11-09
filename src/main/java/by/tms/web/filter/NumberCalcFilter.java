package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/calc")
public class NumberCalcFilter extends HttpFilter {
    private final List<Double> listOfNumbers = new ArrayList<>();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, res);
        listOfNumbers.clear();
        if (req.getSession().getAttribute("user") != null) {
            String[] nums = req.getParameterValues("num");
            for (String s : nums) {
                if (s.matches("(-|\\+)?\\d+") && !s.isEmpty()) {
                    listOfNumbers.add(Double.parseDouble(s));
                }
            }
            if (listOfNumbers.size() == 2) {
                req.setAttribute("listOfNumbers", listOfNumbers);
            } else {
                req.setAttribute("listOfNumbers", null);
            }
            chain.doFilter(req, res);
        }
    }
}
