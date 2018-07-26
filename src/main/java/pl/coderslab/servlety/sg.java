package pl.coderslab.servlety;

import pl.coderslab.DbUtil;
import pl.coderslab.dao.sgDao;
import pl.coderslab.dao.statusDao;
import pl.coderslab.orders;
import pl.coderslab.status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/sg")
public class sg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection c = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sgDao sgDao = new sgDao();
        List<orders> sg = sgDao.findAll();

        request.setAttribute("sg", sg);

        getServletContext().getRequestDispatcher("/sg.jsp")
                .forward(request, response);
    }
}
