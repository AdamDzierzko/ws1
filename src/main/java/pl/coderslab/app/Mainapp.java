package pl.coderslab.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mainapp {

    private static final String CREATE_TABLE_customer = "   CREATE TABLE customer\n"+
            "            (\n"+
            "                    customer_id int AUTO_INCREMENT NOT NULL,\n"+
            "                    imie varchar(255),\n"+
            "    nazwisko varchar(255),\n"+
            "    data_urodzenia DATE,\n"+
            "    PRIMARY KEY(customer_id)\n"+
            "    );";

    private static final String CREATE_TABLE_vehicle = "CREATE TABLE vehicle \n" +
            "(\n" +
            "vehicle_id int AUTO_INCREMENT NOT NULL,\n" +
            "customer_id int NOT NULL,\n" +
            "model varchar(255),\n" +
            "rok_produkcji int,\n" +
            "nr_rejestracyjny int,\n" +
            "data_kolejnego_przeglądu DATE,\n" +
            "PRIMARY KEY(vehicle_id),\n" +
            "Foreign key (customer_id) references customer(customer_id) \n" +
            "on delete cascade\n" +
            ");";

    private static final String CREATE_TABLE_employee = "CREATE TABLE employee \n" +
            "(\n" +
            "employee_id int AUTO_INCREMENT NOT NULL,\n" +
            "imie varchar(255),\n" +
            "nazwisko varchar(255),\n" +
            "adres varchar(255),\n" +
            "telefon varchar(255),\n" +
            "notatka varchar(255),\n" +
            "koszt_roboczogodziny DECIMAL(6,2),\n" +
            "PRIMARY KEY(employee_id)\n" +
            ");";

    private static final String CREATE_TABLE_orders = "CREATE TABLE orders \n" +
            "(\n" +
            "orders_id int NOT NULL AUTO_INCREMENT,\n" +
            "vehicle_id int NOT NULL,\n" +
            "employee_id int NOT NULL,\n" +
            "planowana_data_rozpoczecia_naprawy DATE,\n" +
            "data_rozpoczecia_naprawy DATE,\n" +
            "opis_problemu varchar(255),\n" +
            "opis_naprawy varchar(255),\n" +
            "status varchar(255),\n" +
            "koszt_naprawy_dla_klienta DECIMAL(8,2),\n" +
            "koszt_wykorzystanych_części DECIMAL(8,2),\n" +
            "koszt_roboczogodziny DECIMAL(6,2),\n" +
            "ilość_roboczogodzin DECIMAL(6,2),\n" +
            "PRIMARY KEY(orders_id),\n" +
            "Foreign key (vehicle_id) references vehicle(vehicle_id) \n" +
            "on delete cascade,\n" +
            "Foreign key (employee_id) references employee(employee_id) \n" +
            "on delete cascade\n" +
            ");";

    private static final String CREATE_TABLE_status = "CREATE TABLE status\n" +
            "(\n" +
            "orders_id int NOT NULL,\n" +
            "status varchar(255) NOT NULL,\n" +
            "PRIMARY KEY(orders_id),\n" +
            "Foreign key (orders_id) references orders(orders_id) \n" +
            "on delete cascade\n" +
            ");";

}
