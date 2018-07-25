package pl.coderslab;

import java.util.Date;

public class customer {

    private int customer_id;
    private String imie;
    private String nazwisko;
    private java.sql.Date data_urodzenia;


    public customer() {};

    public customer(int customer_id,String imie, String nazwisko, java.sql.Date data_urodzenia) {
        this.customer_id =customer_id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public java.sql.Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(java.sql.Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }
}
