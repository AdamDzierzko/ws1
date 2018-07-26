package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
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
import java.sql.Connection;
import java.util.List;

@WebServlet("/pracownicy")
public class pracownicy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String adres = request.getParameter("adres");
        String telefon = request.getParameter("telefon");
        String notatka = request.getParameter("notatka");

        Double koszt_roboczogodziny = null;
        String a = request.getParameter("koszt_roboczogodziny");
        if (a != null && a.length() > 0) {
            try {
                koszt_roboczogodziny = Double.parseDouble(a);
            } catch(Exception e) {

            }
        }

        String op = request.getParameter("op");

        employeeDao employeeDaos = new employeeDao();
        employee employee = null;

        if ("dodaj".equals(op)) {
            employee = new employee(employee_id, imie, nazwisko, adres, telefon, notatka, koszt_roboczogodziny);
            employeeDaos.create(employee);
        }
        if ("modyfikuj".equals(op)) {
            employee = new employee(employee_id, imie, nazwisko, adres, telefon, notatka, koszt_roboczogodziny);
            employeeDaos.update(employee);
        }
        if ("usun".equals(op)) {
            employeeDaos.delete(employee_id);
        }
        response.sendRedirect("http://localhost:8080/pracownicy");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection c = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        employeeDao employeeDao = new employeeDao();
        List<employee> employees = employeeDao.findAll();

        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/pracownicy.jsp")
                .forward(request, response);
    }
}
