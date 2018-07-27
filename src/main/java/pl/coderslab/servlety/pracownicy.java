package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
import pl.coderslab.customer;
import pl.coderslab.dao.customerDao;
import pl.coderslab.dao.employeeDao;
import pl.coderslab.dao.ordersDao;
import pl.coderslab.employee;
import pl.coderslab.orders;

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

        ordersDao ordersDao = new ordersDao();
        orders orders = null;
        int b = 0;

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
        if ("zp".equals(op)) {

            try {
                Connection c = DbUtil.getConn();
            } catch (Exception e) {
                e.printStackTrace();
            }

            employeeDao employeeDao = new employeeDao();
            List<employee> employees = employeeDao.findAll();

            request.setAttribute("employees", employees);

            b = 1;
            request.setAttribute("b", b);

            int d = employee_id;
            request.setAttribute("d", d);

            ordersDao ordersDaos = new ordersDao();
            List<orders> o =  ordersDaos.findA(employee_id);
            request.setAttribute("o", o);

            getServletContext().getRequestDispatcher("/pracownicy.jsp")
                   .forward(request, response);
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
