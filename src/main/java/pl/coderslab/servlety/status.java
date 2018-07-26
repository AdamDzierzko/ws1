package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
import pl.coderslab.customer;
import pl.coderslab.dao.statusDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/status")
public class status extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orders_id = Integer.parseInt(request.getParameter("orders_id"));
        String status = request.getParameter("status");

        String op = request.getParameter("op");

        statusDao statusDaos = new statusDao();
        pl.coderslab.status status1 = null;


        if ("dodaj".equals(op)) {
            status1 = new pl.coderslab.status(orders_id, status);
            statusDaos.create(status1);
        }
        if ("modyfikuj".equals(op)) {
            status1 = new pl.coderslab.status(orders_id, status);
            statusDaos.update(status1);
        }
        if ("usun".equals(op)) {
            statusDaos.delete(orders_id);
        }
        response.sendRedirect("http://localhost:8080/status");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection c = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        statusDao statusDao = new statusDao();
        List<pl.coderslab.status> status = statusDao.findAll();

        request.setAttribute("status", status);
        getServletContext().getRequestDispatcher("/status.jsp")
                .forward(request, response);
    }
}

