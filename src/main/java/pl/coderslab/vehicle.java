package pl.coderslab;

import java.util.Date;

public class vehicle {

    private int vehicle_id;
    private int customer_id;
    private String model;
    private int rok_produkcji;
    private int nr_rejestracyjny;
    private java.sql.Date data_kolejnego_przeglądu;

    public vehicle() {};

    public vehicle(int vehicle_id, int customer_id, String model, int rok_produkcji, int nr_rejestracyjny, java.sql.Date data_kolejnego_przeglądu) {
        this.vehicle_id = vehicle_id;
        this.customer_id = customer_id;
        this.model = model;
        this.rok_produkcji = rok_produkcji;
        this.nr_rejestracyjny = nr_rejestracyjny;
        this.data_kolejnego_przeglądu = data_kolejnego_przeglądu;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public int getNr_rejestracyjny() {
        return nr_rejestracyjny;
    }

    public void setNr_rejestracyjny(int nr_rejestracyjny) {
        this.nr_rejestracyjny = nr_rejestracyjny;
    }

    public java.sql.Date getData_kolejnego_przeglądu() {
        return data_kolejnego_przeglądu;
    }

    public void setData_kolejnego_przeglądu(java.sql.Date data_kolejnego_przeglądu) {
        this.data_kolejnego_przeglądu = data_kolejnego_przeglądu;
    }
}
