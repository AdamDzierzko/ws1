package pl.coderslab.dao;

import pl.coderslab.DbUtil;
import pl.coderslab.orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ordersDao {

    private static final String READ_ORDERS_QUERY = "Select * from orders where orders_id = ?";
    private static final String FIND_ALL_ORDERS_QUERY = "Select * from orders";
    private static final String CREATE_ORDERS_QUERY = "INSERT INTO orders(vehicle_id, employee_id, planowana_data_rozpoczecia_naprawy," +
            "data_rozpoczecia_naprawy, opis_problemu, opis_naprawy, status, koszt_naprawy_dla_klienta," +
            "koszt_wykorzystanych_części,koszt_roboczogodziny,ilość_roboczogodzin) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_ORDERS_QUERY = "DELETE from orders where orders_id = ?";
    private static final String UPDATE_ORDERS_QUERY = "UPDATE orders SET vehicle_id = ? , employee_id = ?, " +
            "planowana_data_rozpoczecia_naprawy = ?, data_rozpoczecia_naprawy = ?, opis_problemu = ?, " +
            " opis_naprawy = ?, status = ?, koszt_naprawy_dla_klienta = ?, koszt_wykorzystanych_części = ?," +
            "koszt_roboczogodziny = ?, ilość_roboczogodzin = ? WHERE orders_id = ?";
    private static final String FIND_EMP = "SELECT orders.orders_id, orders.vehicle_id \n" +
            "FROM orders\n" +
            "WHERE orders.employee_id=?";
    private static final String FIND_AL = "SELECT orders.orders_id, orders.employee_id\n" +
            ", orders.planowana_data_rozpoczecia_naprawy, orders.data_rozpoczecia_naprawy, orders.opis_problemu, orders.opis_naprawy \n" +
            ", orders.status, orders.koszt_naprawy_dla_klienta, orders.koszt_wykorzystanych_części, orders.koszt_roboczogodziny \n" +
            ", orders.ilość_roboczogodzin       \n" +
            "FROM orders\n" +
            "WHERE orders.vehicle_id=?;";
    private static final String FIND_L = "SELECT orders.orders_id, orders.vehicle_id \n" +
            "from customer\n" +
            "JOIN vehicle ON customer.customer_id = vehicle.customer_id\n" +
            "JOIN orders ON vehicle.vehicle_id = orders.vehicle_id\n" +
            "WHERE customer.customer_id = ?;";

    public orders read(Integer ordersId) {
        orders orders = new orders();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_ORDERS_QUERY);

        ) {
            statement.setInt(1, ordersId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    orders.setOrders_id(resultSet.getInt("orders_id"));
                    orders.setVehicle_id(resultSet.getInt("vehicle_id"));
                    orders.setEmployee_id(resultSet.getInt("employee_id"));
                    orders.setPlanowana_data_rozpoczecia_naprawy(resultSet.getDate("planowana_data_rozpoczecia_naprawy"));
                    orders.setData_rozpoczecia_naprawy(resultSet.getDate("data_rozpoczecia_naprawy"));
                    orders.setOpis_problemu(resultSet.getString("opis_problemu"));
                    orders.setOpis_naprawy(resultSet.getString("opis_naprawy"));
                    orders.setKoszt_naprawy_dla_klienta(resultSet.getDouble("koszt_naprawy_dla_klienta"));
                    orders.setKoszt_wykorzystanych_czesci(resultSet.getDouble("koszt_wykorzystanych_części"));
                    orders.setKoszt_roboczogodziny(resultSet.getDouble("koszt_roboczogodziny"));
                    orders.setIlosc_roboczogodzin(resultSet.getDouble("ilość_roboczogodzin"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return orders;
    }

    public List<orders> findAll() {
        List<orders> ordersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_ORDERS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                orders ordersToAdd = new orders();
                ordersToAdd.setOrders_id(resultSet.getInt("orders_id"));
                ordersToAdd.setVehicle_id(resultSet.getInt("vehicle_id"));
                ordersToAdd.setEmployee_id(resultSet.getInt("employee_id"));
                ordersToAdd.setPlanowana_data_rozpoczecia_naprawy(resultSet.getDate("planowana_data_rozpoczecia_naprawy"));
                ordersToAdd.setData_rozpoczecia_naprawy(resultSet.getDate("data_rozpoczecia_naprawy"));
                ordersToAdd.setOpis_problemu(resultSet.getString("opis_problemu"));
                ordersToAdd.setOpis_naprawy(resultSet.getString("opis_naprawy"));
                ordersToAdd.setKoszt_naprawy_dla_klienta(resultSet.getDouble("koszt_naprawy_dla_klienta"));
                ordersToAdd.setKoszt_wykorzystanych_czesci(resultSet.getDouble("koszt_wykorzystanych_części"));
                ordersToAdd.setKoszt_roboczogodziny(resultSet.getDouble("koszt_roboczogodziny"));
                ordersToAdd.setIlosc_roboczogodzin(resultSet.getDouble("ilość_roboczogodzin"));
                ordersList.add(ordersToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return ordersList;

    }

    public orders create(orders orders) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_ORDERS_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setInt(1, orders.getVehicle_id());
            insertStm.setInt(2, orders.getEmployee_id());
            insertStm.setDate(3, (Date) orders.getPlanowana_data_rozpoczecia_naprawy());
            insertStm.setDate(4, (Date) orders.getData_rozpoczecia_naprawy());
            insertStm.setString(5, orders.getOpis_problemu());
            insertStm.setString(6, orders.getOpis_naprawy());
            insertStm.setString(7, orders.getStatus());
            insertStm.setDouble(8, orders.getKoszt_naprawy_dla_klienta());
            insertStm.setDouble(9, orders.getKoszt_wykorzystanych_czesci());
            insertStm.setDouble(10, orders.getKoszt_roboczogodziny());
            insertStm.setDouble(11, orders.getIlosc_roboczogodzin());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    orders.setEmployee_id(generatedKeys.getInt(1));
                    return orders;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return null;
    }

    public void delete(Integer ordersId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDERS_QUERY);) {
            statement.setInt(1, ordersId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public void update(orders orders) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERS_QUERY);) {
            statement.setInt(12, orders.getOrders_id());
            statement.setInt(1, orders.getVehicle_id());
            statement.setInt(2, orders.getEmployee_id());
            statement.setDate(3, (Date) orders.getPlanowana_data_rozpoczecia_naprawy());
            statement.setDate(4, (Date) orders.getData_rozpoczecia_naprawy());
            statement.setString(5, orders.getOpis_problemu());
            statement.setString(6, orders.getOpis_naprawy());
            statement.setString(7, orders.getStatus());
            statement.setDouble(8, orders.getKoszt_naprawy_dla_klienta());
            statement.setDouble(9, orders.getKoszt_wykorzystanych_czesci());
            statement.setDouble(10, orders.getKoszt_roboczogodziny());
            statement.setDouble(11, orders.getIlosc_roboczogodzin());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }

    public List<orders> findA(int employee_id) {
        List<orders> ordersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_EMP);) {
            statement.setInt(1, employee_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    orders ordersToAdd = new orders();
                    ordersToAdd.setOrders_id(resultSet.getInt("orders_id"));
                    ordersToAdd.setVehicle_id(resultSet.getInt("vehicle_id"));
                    ordersList.add(ordersToAdd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return ordersList;

    }

    public List<orders> find(int vehicle_id) {
        List<orders> ordersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_AL);) {
            statement.setInt(1, vehicle_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    orders ordersToAdd = new orders();
                    ordersToAdd.setOrders_id(resultSet.getInt("orders_id"));
                    ordersToAdd.setEmployee_id(resultSet.getInt("employee_id"));
                    ordersToAdd.setPlanowana_data_rozpoczecia_naprawy(resultSet.getDate("planowana_data_rozpoczecia_naprawy"));
                    ordersToAdd.setData_rozpoczecia_naprawy(resultSet.getDate("data_rozpoczecia_naprawy"));
                    ordersToAdd.setOpis_problemu(resultSet.getString("opis_problemu"));
                    ordersToAdd.setOpis_naprawy(resultSet.getString("opis_naprawy"));
                    ordersToAdd.setKoszt_naprawy_dla_klienta(resultSet.getDouble("koszt_naprawy_dla_klienta"));
                    ordersToAdd.setKoszt_wykorzystanych_czesci(resultSet.getDouble("koszt_wykorzystanych_części"));
                    ordersToAdd.setKoszt_roboczogodziny(resultSet.getDouble("koszt_roboczogodziny"));
                    ordersToAdd.setIlosc_roboczogodzin(resultSet.getDouble("ilość_roboczogodzin"));
                    ordersList.add(ordersToAdd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return ordersList;

    }

    public List<orders> findW(int customer_id) {
        List<orders> ordersList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_L);) {
            statement.setInt(1, customer_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    orders ordersToAdd = new orders();
                    ordersToAdd.setOrders_id(resultSet.getInt("orders_id"));
                    ordersToAdd.setVehicle_id(resultSet.getInt("vehicle_id"));
                    ordersList.add(ordersToAdd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return ordersList;

    }


}
