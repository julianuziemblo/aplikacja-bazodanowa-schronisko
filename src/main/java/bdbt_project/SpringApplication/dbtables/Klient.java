package bdbt_project.SpringApplication.dbtables;

public class Klient {
    private int nr_klienta;
    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private String pesel;
    private char plec;
    private String email;
    private String nr_telefonu;
    private int nr_adresu;
    private Integer nr_schroniska;

    public Klient(){}

    public Klient(int nr_klienta, String imie,
                  String nazwisko, String data_urodzenia,
                  String pesel, char plec, String email,
                  String nr_telefonu, int nr_adresu,
                  Integer nr_schroniska) {
        this.nr_klienta = nr_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_adresu = nr_adresu;
        this.nr_schroniska = nr_schroniska;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
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

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public Integer getNr_schroniska() {
        return nr_schroniska;
    }

    public void setNr_schroniska(Integer nr_schroniska) {
        this.nr_schroniska = nr_schroniska;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nr_klienta=" + nr_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", plec=" + plec +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", nr_adresu=" + nr_adresu +
                ", nr_schroniska=" + nr_schroniska +
                '}';
    }
}
