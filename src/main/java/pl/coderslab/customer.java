package pl.coderslab;

import java.util.Date;

public class customer {

    private int customer_id;
    private String imie;
    private String nazwisko;
    private Date data_urodzenia;


    public customer() {};

    public customer(String imię, String nazwisko, Date data_urodzenia) {
        this.imie = imię;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getImię() {
        return imie;
    }

    public void setImię(String imię) {
        this.imie = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }
}
