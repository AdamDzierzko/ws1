package pl.coderslab.dao;

import pl.coderslab.*;
import pl.coderslab.employee;
import pl.coderslab.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class employeeDao {


    private static final String READ_EMPLOYEE_QUERY = "Select * from employee where employee_id = ?";
    private static final String FIND_ALL_EMPLOYEE_QUERY = "SELECT * FROM employee";
    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO employee(imie,nazwisko,adres,telefon,notatka," +
            "koszt_roboczogodziny) VALUES (?,?,?,?,?,?)";
    private static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employee where employee_id = ?";
    private static final String UPDATE_EMPLOYEE_QUERY = "UPDATE	employee SET imie = ? , nazwisko = ?, " +
            "adres = ?, telefon = ?, notatka = ?, koszt_roboczogodziny = ?  WHERE	customer_id = ?";

    public employee read(Integer employeeId) {
        employee employee = new employee();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_EMPLOYEE_QUERY);

        ) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employee.setEmployee_id(resultSet.getInt("employee_id"));
                    employee.setImie(resultSet.getString("imie"));
                    employee.setNazwisko(resultSet.getString("nazwisko"));
                    employee.setAdres(resultSet.getString("adres"));
                    employee.setTelefon(resultSet.getString("telefon"));
                    employee.setNotatka(resultSet.getString("notatka"));
                    employee.setKoszt_roboczogodziny(resultSet.getDouble("koszt_roboczogodziny"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return employee;
    }

    public List<employee> findAll() {
        List<employee> employeeList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_EMPLOYEE_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                employee employeeToAdd = new employee();
                employeeToAdd.setEmployee_id(resultSet.getInt("employee_id"));
                employeeToAdd.setImie(resultSet.getString("imie"));
                employeeToAdd.setNazwisko(resultSet.getString("nazwisko"));
                employeeToAdd.setAdres(resultSet.getString("adres"));
                employeeToAdd.setTelefon(resultSet.getString("telefon"));
                employeeToAdd.setNotatka(resultSet.getString("notatka"));
                employeeToAdd.setKoszt_roboczogodziny(resultSet.getDouble("koszt_roboczogodziny"));
                employeeList.add(employeeToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return employeeList;

    }

    public employee create(employee employee) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_EMPLOYEE_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, employee.getImie());
            insertStm.setString(2, employee.getNazwisko());
            insertStm.setString(3, employee.getAdres());
            insertStm.setString(4, employee.getTelefon());
            insertStm.setString(5, employee.getNotatka());
            insertStm.setDouble(6, employee.getKoszt_roboczogodziny());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    employee.setEmployee_id(generatedKeys.getInt(1));
                    return employee;
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

    public void delete(Integer employeeId) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_QUERY);) {
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public void update(employee employee) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_QUERY);) {
            statement.setInt(7, employee.getEmployee_id());
            statement.setString(1, employee.getImie());
            statement.setString(2, employee.getNazwisko());
            statement.setString(3, employee.getAdres());
            statement.setString(4, employee.getTelefon());
            statement.setString(5, employee.getNotatka());
            statement.setDouble(6, employee.getKoszt_roboczogodziny());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}
