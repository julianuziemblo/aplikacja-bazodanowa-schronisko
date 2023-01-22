package bdbt_project.SpringApplication.dbtables;

public class Umowa {
    private int nr_umowy;
    private char rodzaj;
    private String data_podpisu;
    private String data_waznosci;
    private int nr_zwierzecia;
    private int nr_klienta;
    private int nr_pracownika;

    public Umowa(){}

    public Umowa(int nr_umowy, char rodzaj,
                 String data_podpisu, String data_waznosci,
                 int nr_zwierzecia, int nr_klienta,
                 int nr_pracownika) {
        this.nr_umowy = nr_umowy;
        this.rodzaj = rodzaj;
        this.data_podpisu = data_podpisu;
        this.data_waznosci = data_waznosci;
        this.nr_zwierzecia = nr_zwierzecia;
        this.nr_klienta = nr_klienta;
        this.nr_pracownika = nr_pracownika;
    }

    public int getNr_umowy() {
        return nr_umowy;
    }

    public void setNr_umowy(int nr_umowy) {
        this.nr_umowy = nr_umowy;
    }

    public char getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(char rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getData_podpisu() {
        return data_podpisu;
    }

    public void setData_podpisu(String data_podpisu) {
        this.data_podpisu = data_podpisu;
    }

    public String getData_waznosci() {
        return data_waznosci;
    }

    public void setData_waznosci(String data_waznosci) {
        this.data_waznosci = data_waznosci;
    }

    public int getNr_zwierzecia() {
        return nr_zwierzecia;
    }

    public void setNr_zwierzecia(int nr_zwierzecia) {
        this.nr_zwierzecia = nr_zwierzecia;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    @Override
    public String toString() {
        return "Umowa{" +
                "nr_umowy=" + nr_umowy +
                ", rodzaj=" + rodzaj +
                ", data_podpisu='" + data_podpisu + '\'' +
                ", data_waznosci='" + data_waznosci + '\'' +
                ", nr_zwierzecia=" + nr_zwierzecia +
                ", nr_klienta=" + nr_klienta +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}
