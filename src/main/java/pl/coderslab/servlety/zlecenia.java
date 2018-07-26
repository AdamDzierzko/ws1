package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
import pl.coderslab.dao.ordersDao;
import pl.coderslab.orders;

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

@WebServlet("/zlecenia")
public class zlecenia extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orders_id = Integer.parseInt(request.getParameter("orders_id"));

        int vehicle_id = 0;
        int employee_id = 0 ;

        String a = request.getParameter("vehicle_id");
        String b = request.getParameter("employee_id");

        if (a != null && a.length() > 0) {
            try {
                vehicle_id = Integer.parseInt(a);
            } catch(Exception e) {

            }
        }

        if (b != null && b.length() > 0) {
            try {
                employee_id = Integer.parseInt(b);
            } catch(Exception e) {

            }
        }

        java.sql.Date planowana_data_rozpoczecia_naprawy = null;
        Date data1 = null;
        try {
            data1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("planowana_data_rozpoczecia_naprawy"));
            planowana_data_rozpoczecia_naprawy = new java.sql.Date(data1.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date data_rozpoczecia_naprawy = null;
        Date data2 = null;
        try {
            data2 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_rozpoczecia_naprawy"));
            data_rozpoczecia_naprawy = new java.sql.Date(data2.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String opis_problemu = request.getParameter("opis_problemu");
        String opis_naprawy = request.getParameter("opis_naprawy");
        String status = request.getParameter("status");

        Double koszt_naprawy_dla_klienta = null;
        String c = request.getParameter("koszt_naprawy_dla_klienta");
        if (c != null && c.length() > 0) {
            try {
                koszt_naprawy_dla_klienta = Double.parseDouble(c);
            } catch(Exception e) {

            }
        }

        Double koszt_wykorzystanych_czesci = null;
        String d = request.getParameter("koszt_wykorzystanych_czesci");
        if (d != null && d.length() > 0) {
            try {
                koszt_wykorzystanych_czesci = Double.parseDouble(d);
            } catch(Exception e) {

            }
        }

        Double koszt_roboczogodziny = null;
        String f = request.getParameter("koszt_roboczogodziny");
        if (f != null && f.length() > 0) {
            try {
                koszt_roboczogodziny = Double.parseDouble(f);
            } catch(Exception e) {

            }
        }

        Double ilosc_roboczogodzin = null;
        String g = request.getParameter("ilosc_roboczogodzin");
        if (g != null && g.length() > 0) {
            try {
                ilosc_roboczogodzin = Double.parseDouble(g);
            } catch(Exception e) {

            }
        }

        String op = request.getParameter("op");

        ordersDao ordersDaos = new ordersDao();
        orders orders = null;

        if ("dodaj".equals(op)) {
            orders = new orders(orders_id, vehicle_id, employee_id, planowana_data_rozpoczecia_naprawy, data_rozpoczecia_naprawy, opis_problemu, opis_naprawy, status, koszt_naprawy_dla_klienta, koszt_wykorzystanych_czesci, koszt_roboczogodziny, ilosc_roboczogodzin);
            ordersDaos.create(orders);
        }
        if ("modyfikuj".equals(op)) {
            orders = new orders(orders_id, vehicle_id, employee_id, planowana_data_rozpoczecia_naprawy, data_rozpoczecia_naprawy, opis_problemu, opis_naprawy, status, koszt_naprawy_dla_klienta, koszt_wykorzystanych_czesci, koszt_roboczogodziny, ilosc_roboczogodzin);
            ordersDaos.update(orders);
        }
        if ("usun".equals(op)) {
            ordersDaos.delete(orders_id);
        }
        response.sendRedirect("http://localhost:8080/zlecenia");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection c = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ordersDao ordersDao = new ordersDao();
        List<orders> orders = ordersDao.findAll();

        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/zlecenia.jsp")
                .forward(request, response);
    }
}

