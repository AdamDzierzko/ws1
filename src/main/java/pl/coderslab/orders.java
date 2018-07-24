package pl.coderslab;

import java.util.Date;

public class orders {

    private int orders_id;
    private int vehicle_id;
    private int employee_id;
    private Date planowana_data_rozpoczecia_naprawy;
    private Date data_rozpoczecia_naprawy;
    private String opis_problemu;
    private String opis_naprawy;
    private String status;
    private Double koszt_naprawy_dla_klienta;
    private Double koszt_wykorzystanych_części;
    private Double koszt_roboczogodziny;
    private Double ilość_roboczogodzin;

    public orders() {};

    public orders(int vehicle_id, int employee_id, Date planowana_data_rozpoczecia_naprawy, Date data_rozpoczecia_naprawy, String opis_problemu, String opis_naprawy, String status, Double koszt_naprawy_dla_klienta, Double koszt_wykorzystanych_części, Double koszt_roboczogodziny, Double ilość_roboczogodzin) {
        this.vehicle_id = vehicle_id;
        this.employee_id = employee_id;
        this.planowana_data_rozpoczecia_naprawy = planowana_data_rozpoczecia_naprawy;
        this.data_rozpoczecia_naprawy = data_rozpoczecia_naprawy;
        this.opis_problemu = opis_problemu;
        this.opis_naprawy = opis_naprawy;
        this.status = status;
        this.koszt_naprawy_dla_klienta = koszt_naprawy_dla_klienta;
        this.koszt_wykorzystanych_części = koszt_wykorzystanych_części;
        this.koszt_roboczogodziny = koszt_roboczogodziny;
        this.ilość_roboczogodzin = ilość_roboczogodzin;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int order_id) {
        this.orders_id = order_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Date getPlanowana_data_rozpoczecia_naprawy() {
        return planowana_data_rozpoczecia_naprawy;
    }

    public void setPlanowana_data_rozpoczecia_naprawy(Date planowana_data_rozpoczecia_naprawy) {
        this.planowana_data_rozpoczecia_naprawy = planowana_data_rozpoczecia_naprawy;
    }

    public Date getData_rozpoczecia_naprawy() {
        return data_rozpoczecia_naprawy;
    }

    public void setData_rozpoczecia_naprawy(Date data_rozpoczecia_naprawy) {
        this.data_rozpoczecia_naprawy = data_rozpoczecia_naprawy;
    }

    public String getOpis_problemu() {
        return opis_problemu;
    }

    public void setOpis_problemu(String opis_problemu) {
        this.opis_problemu = opis_problemu;
    }

    public String getOpis_naprawy() {
        return opis_naprawy;
    }

    public void setOpis_naprawy(String opis_naprawy) {
        this.opis_naprawy = opis_naprawy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getKoszt_naprawy_dla_klienta() {
        return koszt_naprawy_dla_klienta;
    }

    public void setKoszt_naprawy_dla_klienta(Double koszt_naprawy_dla_klienta) {
        this.koszt_naprawy_dla_klienta = koszt_naprawy_dla_klienta;
    }

    public Double getKoszt_wykorzystanych_części() {
        return koszt_wykorzystanych_części;
    }

    public void setKoszt_wykorzystanych_części(Double koszt_wykorzystanych_części) {
        this.koszt_wykorzystanych_części = koszt_wykorzystanych_części;
    }

    public Double getKoszt_roboczogodziny() {
        return koszt_roboczogodziny;
    }

    public void setKoszt_roboczogodziny(Double koszt_roboczogodziny) {
        this.koszt_roboczogodziny = koszt_roboczogodziny;
    }

    public Double getIlość_roboczogodzin() {
        return ilość_roboczogodzin;
    }

    public void setIlość_roboczogodzin(Double ilość_roboczogodzin) {
        this.ilość_roboczogodzin = ilość_roboczogodzin;
    }
}
