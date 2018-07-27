package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
import pl.coderslab.dao.employeeDao;
import pl.coderslab.dao.ordersDao;
import pl.coderslab.dao.vehicleDao;
import pl.coderslab.employee;
import pl.coderslab.orders;
import pl.coderslab.vehicle;

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

@WebServlet("/pojazdy")
public class pojazdy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
        String model = request.getParameter("model");

        int customer_id = 0;
        int rok_produkcji = 0 ;
        int nr_rejestracyjny = 0 ;

        String a = request.getParameter("customer_id");

        if (a != null && a.length() > 0) {
            try {
                customer_id = Integer.parseInt(a);
            } catch(Exception e) {

            }
        }

        String b = request.getParameter("rok_produkcji");

        if (b != null && b.length() > 0) {
            try {
                rok_produkcji = Integer.parseInt(b);
            } catch(Exception e) {

            }
        }

        String c = request.getParameter("nr_rejestracyjny");

        if (c != null && c.length() > 0) {
            try {
                nr_rejestracyjny = Integer.parseInt(c);
            } catch(Exception e) {

            }
        }

 java.sql.Date data_kolejnego_przegladu = null;
        Date data = null;
        try {
            data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_kolejnego_przegladu"));
            data_kolejnego_przegladu = new java.sql.Date(data.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
//            response.getWriter().append("aaa");
        }

        String op = request.getParameter("op");

        vehicleDao vehicleDaos = new vehicleDao();
        vehicle vehicle = null;

        int g = 0;

        if ("dodaj".equals(op)) {
            vehicle = new vehicle(vehicle_id, customer_id, model, rok_produkcji, nr_rejestracyjny, data_kolejnego_przegladu);
            vehicleDaos.create(vehicle);
        }
        if ("modyfikuj".equals(op)) {
            vehicle = new vehicle(vehicle_id, customer_id, model, rok_produkcji, nr_rejestracyjny, data_kolejnego_przegladu);
            vehicleDaos.update(vehicle);
        }
        if ("usun".equals(op)) {
            vehicleDaos.delete(vehicle_id);
        }
        if ("ln".equals(op)) {

            try {
                Connection f = DbUtil.getConn();
            } catch (Exception e) {
                e.printStackTrace();
            }

            vehicleDao vehicleDao = new vehicleDao();
            List<vehicle> vehicles = vehicleDao.findAll();

            request.setAttribute("vehicles", vehicles);

            g = 1;
            request.setAttribute("g", g);

            int d = vehicle_id;
            request.setAttribute("d", d);

            ordersDao ordersDaos = new ordersDao();
            List<orders> o =  ordersDaos.find(vehicle_id);
            request.setAttribute("o", o);

            getServletContext().getRequestDispatcher("/pojazdy.jsp")
                    .forward(request, response);
        }
        response.sendRedirect("http://localhost:8080/pojazdy");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection c = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        vehicleDao vehicleDao = new vehicleDao();
        List<vehicle> vehicles = vehicleDao.findAll();

        request.setAttribute("vehicles", vehicles);
        getServletContext().getRequestDispatcher("/pojazdy.jsp")
                .forward(request, response);
    }
}
