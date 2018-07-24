package pl.coderslab.dao;

import pl.coderslab.*;
import pl.coderslab.status;
import pl.coderslab.status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class statusDao {

    private static final String READ_STATUS_QUERY = "Select * from status where orders_id = ?";
    private static final String FIND_ALL_STATUS_QUERY = "Select * from status ";
    private static final String CREATE_STATUS_QUERY = "INSERT INTO status(orders_id,status) VALUES (?,?)";
    private static final String DELETE_STATUS_QUERY = "DELETE FROM status where id = ?";
    private static final String UPDATE_STATUS_QUERY = "UPDATE status SET status = ? WHERE	orders_id = ?";

    public status read(Integer vehicleId) {
        status status = new status();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_STATUS_QUERY);

        ) {
            statement.setInt(1, vehicleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    status.setOrders_id(resultSet.getInt("orders_id"));
                    status.setStatus(resultSet.getString("status"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return status;
    }

    public List<status> findAll() {
        List<status> statusList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_STATUS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                status statusToAdd = new status();
                statusToAdd.setOrders_id(resultSet.getInt("orders_id"));
                statusToAdd.setStatus(resultSet.getString("status"));
                statusList.add(statusToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return statusList;

    }

    public status create(status status) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_STATUS_QUERY);) {
            insertStm.setInt(1, status.getOrders_id());
            insertStm.setString(2, status.getStatus());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return null;
    }

    public void delete(Integer statusId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(DELETE_STATUS_QUERY);) {
            statement.setInt(1, statusId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public void update(status status) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS_QUERY);) {
            statement.setInt(2, status.getOrders_id());
            statement.setString(1, status.getStatus());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}

