package pl.coderslab.servlety;

import pl.coderslab.customer;
import pl.coderslab.dao.customerDao;
import pl.coderslab.dao.employeeDao;
import pl.coderslab.employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pracownicy")
public class pracownicy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        employeeDao employeeDao = new employeeDao();
        List<employee> employees = customerDao.findAll();

        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/pracownicy.jsp")
                .forward(request, response);
    }
}
