package bdbt_project.SpringApplication.dbtables;

import java.util.Objects;

public class Umowa {

    private int nr_umowy;
    /**
     * Rodzaj in ("P"- "Próbna", "T"- "Tymczasowa", "N" - na czas Nieokreślony)
     */
    private char rodzaj;
    private String data_podpisu;
    private String data_waznosci;
    private int nr_zwerzecia;
    private int nr_klienta;
    private int nr_pracownika;
    private String rodzajFormatted;

    public Umowa(){}

    public Umowa(int nr_umowy, char rodzaj,
                 String data_podpisu, String data_waznosci,
                 int nr_zwerzecia, int nr_klienta,
                 int nr_pracownika) {
        this.nr_umowy = nr_umowy;
        this.rodzaj = rodzaj;
        this.data_podpisu = data_podpisu;
        this.data_waznosci = data_waznosci;
        this.nr_zwerzecia = nr_zwerzecia;
        this.nr_klienta = nr_klienta;
        this.nr_pracownika = nr_pracownika;
        this.rodzajFormatted = getRodzajFormatted();
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

    public String getRodzajFormatted() {
        if(rodzaj == 'P') return "Oczekująca";
        else if(rodzaj == 'T') return "Zatwierdzono: umowa tymczasowa";
        else return "Zatwierdzono: na czas nieokreślony";
    }

    public void setRodzaj(char rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getData_podpisu() {
        if(Objects.equals(data_podpisu, "") || data_podpisu == null) return "-";
        return data_podpisu.split(" ")[0];
    }

    public void setData_podpisu(String data_podpisu) {
        this.data_podpisu = data_podpisu;
    }

    public String getData_waznosci() {
        if(Objects.equals(data_waznosci, "") || data_waznosci == null) return "-";
        return data_waznosci.split(" ")[0];
    }

    public void setData_waznosci(String data_waznosci) {
        this.data_waznosci = data_waznosci;
    }

    public int getNr_zwerzecia() {
        return nr_zwerzecia;
    }

    public void setNr_zwerzecia(int nr_zwerzecia) {
        this.nr_zwerzecia = nr_zwerzecia;
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
                ", nr_zwierzecia=" + nr_zwerzecia +
                ", nr_klienta=" + nr_klienta +
                ", nr_pracownika=" + nr_pracownika +
                '}';
    }
}
