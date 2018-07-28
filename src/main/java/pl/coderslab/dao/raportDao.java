package pl.coderslab.dao;

import pl.coderslab.DbUtil;
import pl.coderslab.employee;
import pl.coderslab.orders;
import pl.coderslab.vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class raportDao {

    private static final String RAPORT_QUERY = "SELECT employee.imie, employee.nazwisko, SUM(ilość_roboczogodzin)\n" +
            "from employee\n" +
            "JOIN orders ON employee.employee_id = orders.employee_id\n" +
            "WHERE (DATE (orders.data_rozpoczecia_naprawy)\n" +
            "BETWEEN ? AND ?)\n" +
            "GROUP BY orders.employee_id;";

    public List<employee> findA(java.sql.Date startdate, java.sql.Date enddate) {
        List<employee> employeeList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(RAPORT_QUERY);) {
            statement.setDate(1,  startdate);
            statement.setDate(2,  enddate);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employee employeeToAdd = new employee();
                    employeeToAdd.setImie(resultSet.getString("imie"));
                    employeeToAdd.setNazwisko(resultSet.getString("nazwisko"));
                    employeeToAdd.setSum(resultSet.getDouble("SUM(ilość_roboczogodzin)"));
                    employeeList.add(employeeToAdd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return employeeList;

    }



}
