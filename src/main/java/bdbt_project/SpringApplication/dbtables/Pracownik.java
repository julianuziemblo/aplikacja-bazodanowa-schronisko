package bdbt_project.SpringApplication.dbtables;

public class Pracownik {
    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private String pesel;
    private char plec;
    private String email;
    private String nr_telefonu;
    private String nr_konta;
    private char sposob_wyplaty;
    private String data_zatrudnienia;
    private int nr_schroniska;
    private Integer nr_adresu;
    private int nr_stanowiska;
    public static int ZWYKLY_PRACOWNIK = 1;

    public Pracownik(){}

    public Pracownik(int nr_pracownika, String imie,
                     String nazwisko, String data_urodzenia,
                     String pesel, char plec, String email,
                     String nr_telefonu, String nr_konta,
                     char sposob_wyplaty, String data_zatrudnienia,
                     int nr_schroniska, Integer nr_adresu,
                     int nr_stanowiska) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_konta = nr_konta;
        this.sposob_wyplaty = sposob_wyplaty;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_schroniska = nr_schroniska;
        this.nr_adresu = nr_adresu;
        this.nr_stanowiska = nr_stanowiska;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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
        if(email == null) return "Nie posiada";
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

    public String getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(String nr_konta) {
        this.nr_konta = nr_konta;
    }

    public char getSposob_wyplaty() {
        return sposob_wyplaty;
    }

    public void setSposob_wyplaty(char sposob_wyplaty) {
        this.sposob_wyplaty = sposob_wyplaty;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public int getNr_schroniska() {
        return nr_schroniska;
    }

    public void setNr_schroniska(int nr_schroniska) {
        this.nr_schroniska = nr_schroniska;
    }

    public Integer getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(Integer nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public int getNr_stanowiska() {
        return nr_stanowiska;
    }

    public void setNr_stanowiska(int nr_stanowiska) {
        this.nr_stanowiska = nr_stanowiska;
    }

    public String getImie_nazwisko() {
        return this.imie + " " + this.nazwisko;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", plec=" + plec +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", nr_konta='" + nr_konta + '\'' +
                ", sposob_wyplaty=" + sposob_wyplaty +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", nr_schroniska=" + nr_schroniska +
                ", nr_adresu=" + nr_adresu +
                ", nr_stanowiska=" + nr_stanowiska +
                '}';
    }
}
