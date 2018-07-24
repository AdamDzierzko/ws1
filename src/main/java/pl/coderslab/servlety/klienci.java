package pl.coderslab.servlety;

import pl.coderslab.customer;
import pl.coderslab.dao.customerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/klienci")
public class klienci extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerDao customerDao = new customerDao();
        List<customer> customers= customerDao.findAll();

        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/klienci.jsp")
                .forward(request, response);
    }
}
