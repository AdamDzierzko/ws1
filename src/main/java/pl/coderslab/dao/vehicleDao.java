package pl.coderslab.dao;

import pl.coderslab.*;
import pl.coderslab.vehicle;
import pl.coderslab.vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class vehicleDao {


    private static final String READ_VEHILCE_QUERY = "Select * from vehicle where vehicle_id = ?";
    private static final String FIND_ALL_VEHILCE_QUERY = "SELECT * FROM vehicle";
    private static final String CREATE_VEHILCE_QUERY = "INSERT INTO vehicle(customer_id,model,rok_produkcji,nr_rejestracyjny," +
            "data_kolejnego_przeglądu) VALUES (?,?,?,?,?)";
    private static final String DELETE_VEHILCE_QUERY = "DELETE FROM vehicle where vehicle_id = ?";
    private static final String UPDATE_VEHILCE_QUERY = "UPDATE	vehicle SET customer_id = ? , model = ?, " +
            "rok_produkcji = ?, nr_rejestracyjny = ?, data_kolejnego_przeglądu = ?  WHERE	vehicle_id = ?";

    public vehicle read(Integer vehicleId) {
        vehicle vehicle = new vehicle();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(READ_VEHILCE_QUERY);

        ) {
            statement.setInt(1, vehicleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    vehicle.setVehicle_id(resultSet.getInt("vehicle_id"));
                    vehicle.setCustomer_id(resultSet.getInt("customer_id"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setRok_produkcji(resultSet.getInt("rok_produkcji"));
                    vehicle.setData_kolejnego_przeglądu(resultSet.getDate("data_kolejnego_przeglądu"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return vehicle;
    }

    public List<vehicle> findAll() {
        List<vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_VEHILCE_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                vehicle vehicleToAdd = new vehicle();
                vehicleToAdd.setVehicle_id(resultSet.getInt("vehicle_id"));
                vehicleToAdd.setCustomer_id(resultSet.getInt("customer_id"));
                vehicleToAdd.setModel(resultSet.getString("model"));
                vehicleToAdd.setRok_produkcji(resultSet.getInt("rok_produkcji"));
                vehicleToAdd.setNr_rejestracyjny(resultSet.getInt("nr_rejestracyjny"));
                vehicleToAdd.setData_kolejnego_przeglądu(resultSet.getDate("data_kolejnego_przeglądu"));
                vehicleList.add(vehicleToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return vehicleList;

    }

    public vehicle create(vehicle vehicle) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_VEHILCE_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setInt(1, vehicle.getCustomer_id());
            insertStm.setString(2, vehicle.getModel());
            insertStm.setInt(3, vehicle.getRok_produkcji());
            insertStm.setInt(4, vehicle.getNr_rejestracyjny());
            insertStm.setDate(5, vehicle.getData_kolejnego_przeglądu());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    vehicle.setVehicle_id(generatedKeys.getInt(1));
                    return vehicle;
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

    public void delete(int vehicle_id) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(DELETE_VEHILCE_QUERY);) {
            statement.setInt(1, vehicle_id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }

    public void update(vehicle vehicle) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(UPDATE_VEHILCE_QUERY);) {
            statement.setInt(6, vehicle.getVehicle_id());
            statement.setInt(1, vehicle.getCustomer_id());
            statement.setString(2, vehicle.getModel());
            statement.setInt(3, vehicle.getRok_produkcji());
            statement.setInt(4, vehicle.getNr_rejestracyjny());
            statement.setDate(5, vehicle.getData_kolejnego_przeglądu());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}


