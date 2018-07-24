package pl.coderslab.dao;

import pl.coderslab.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.customer;
import pl.coderslab.employee;

public class customerDao {

    private static final String READ_CUSTOMER_QUERY = "Select * from customer where customer_id = ?";
    private static final String FIND_ALL_CUSTOMER_QUERY = "SELECT * FROM customer";
    private static final String CREATE_CUSTOMER_QUERY = "INSERT INTO customer(imie,nazwisko,data_urodzenia) VALUES (?,?,?)";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE	customer SET imie = ? , nazwisko = ?, " +
            "data_urodzenia = ? WHERE	customer_id = ?";

    public customer read(Integer customerId) {
        customer customer = new customer();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_CUSTOMER_QUERY);

        ) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    customer.setCustomer_id(resultSet.getInt("customer_id"));
                    customer.setImię(resultSet.getString("imie"));
                    customer.setNazwisko(resultSet.getString("nazwisko"));
                    customer.setData_urodzenia(resultSet.getDate("data_urodzenia"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return customer;
    }

    public static List<employee> findAll() {
        List<customer> customerList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_CUSTOMER_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                customer customerToAdd = new customer();
                customerToAdd.setCustomer_id(resultSet.getInt("customer_id"));
                customerToAdd.setImię(resultSet.getString("imie"));
                customerToAdd.setNazwisko(resultSet.getString("nazwisko"));
                customerToAdd.setData_urodzenia(resultSet.getDate("data_urodzenia"));
                customerList.add(customerToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return customerList;

    }

    public customer create(customer customer) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_CUSTOMER_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, customer.getImię());
            insertStm.setString(2, customer.getNazwisko());
            insertStm.setDate(3, (Date) customer.getData_urodzenia());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    customer.setCustomer_id(generatedKeys.getInt(1));
                    return customer;
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

    public void delete(Integer customerId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_QUERY);) {
            statement.setInt(1, customerId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public void update(customer customer) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_QUERY);) {
            statement.setInt(4, customer.getCustomer_id());
            statement.setString(1, customer.getImię());
            statement.setString(2, customer.getNazwisko());
            statement.setDate(3, (Date) customer.getData_urodzenia());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }


}
