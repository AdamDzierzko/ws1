package pl.coderslab.dao;

import pl.coderslab.*;
import pl.coderslab.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sgDao {

    private static final String SG_QUERY = "SELECT orders.orders_id, orders.employee_id, orders.vehicle_id \n" +
            "FROM orders\n" +
            "WHERE orders.status='w_naprawie';";


    public List<orders> findAll() {
        List<orders> ordersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(SG_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                orders ordersToAdd = new orders();
                ordersToAdd.setOrders_id(resultSet.getInt("orders_id"));
                ordersToAdd.setEmployee_id(resultSet.getInt("employee_id"));
                ordersToAdd.setVehicle_id(resultSet.getInt("vehicle_id"));
                ordersList.add(ordersToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return ordersList;
    }
}
