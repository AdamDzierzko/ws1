package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
import pl.coderslab.dao.employeeDao;
import pl.coderslab.dao.ordersDao;
import pl.coderslab.dao.raportDao;
import pl.coderslab.dao.sgDao;
import pl.coderslab.employee;
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

@WebServlet("/raporty")
public class raporty extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        java.sql.Date startdate = null;
        Date data1 = null;
        try {
            data1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startdate"));
            startdate = new java.sql.Date(data1.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date enddate = null;
        Date data2 = null;
        try {
            data2 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enddate"));
            enddate = new java.sql.Date(data2.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Connection f = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int a = 1;
        request.setAttribute("a", a);

        raportDao raportDaos = new raportDao();
        List<employee> o =  raportDaos.findA(startdate, enddate);
        request.setAttribute("o", o);

        getServletContext().getRequestDispatcher("/raporty.jsp")
                .forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection c = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }



        getServletContext().getRequestDispatcher("/raporty.jsp")
                .forward(request, response);
    }
}
