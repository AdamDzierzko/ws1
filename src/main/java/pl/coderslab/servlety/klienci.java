package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
import pl.coderslab.customer;
import pl.coderslab.dao.customerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/klienci")
public class klienci extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        java.sql.Date data_urodzenia = null;
        Date data = null;
        try {
            data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_urodzenia"));
            data_urodzenia = new java.sql.Date(data.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String op = request.getParameter("op");

        customerDao customerDaos = new customerDao();
        customer customer = null;

        if ("dodaj".equals(op)) {
            customer = new customer(customer_id, imie, nazwisko, data_urodzenia);
            customerDaos.create(customer);
        }
        if ("modyfikuj".equals(op)) {
            customer = new customer(customer_id, imie, nazwisko, data_urodzenia);
            customerDaos.update(customer);
        }
        if ("usun".equals(op)) {
            customerDaos.delete(customer_id);
        }
        response.sendRedirect("http://localhost:8080/klienci");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection c = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        customerDao customerDao = new customerDao();
        List<customer> customers = customerDao.findAll();

        request.setAttribute("customer", customers);
        getServletContext().getRequestDispatcher("/klienci.jsp")
                .forward(request, response);
    }

}

