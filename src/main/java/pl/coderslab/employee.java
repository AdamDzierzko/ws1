package pl.coderslab;

public class employee {

    private int employee_id;
    private String imie;
    private String nazwisko;
    private String adres;
    private String telefon;
    private String notatka;
    private Double koszt_roboczogodziny;

    public employee() {};

    public employee(String imie, String nazwisko, String adres, String telefon, String notatka, Double koszt_roboczogodziny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.telefon = telefon;
        this.notatka = notatka;
        this.koszt_roboczogodziny = koszt_roboczogodziny;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNotatka() {
        return notatka;
    }

    public void setNotatka(String notatka) {
        this.notatka = notatka;
    }

    public Double getKoszt_roboczogodziny() {
        return koszt_roboczogodziny;
    }

    public void setKoszt_roboczogodziny(Double koszt_roboczogodziny) {
        this.koszt_roboczogodziny = koszt_roboczogodziny;
    }
}
