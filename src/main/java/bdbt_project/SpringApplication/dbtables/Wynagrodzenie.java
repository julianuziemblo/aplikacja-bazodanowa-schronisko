package bdbt_project.SpringApplication.dbtables;

public class Wynagrodzenie {
    private int nr_wynagrodzenia;
    private int nr_pracownika;
    private String data;
    private double kwota;

    public Wynagrodzenie(int nr_wynagrodzenia, int nr_pracownika,
                         String data, double kwota) {
        this.nr_wynagrodzenia = nr_wynagrodzenia;
        this.nr_pracownika = nr_pracownika;
        this.data = data;
        this.kwota = kwota;
    }

    public Wynagrodzenie() {
    }

    public int getNr_wynagrodzenia() {
        return nr_wynagrodzenia;
    }

    public void setNr_wynagrodzenia(int nr_wynagrodzenia) {
        this.nr_wynagrodzenia = nr_wynagrodzenia;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    @Override
    public String toString() {
        return "Wynagrodzenie{" +
                "nr_wynagrodzenia=" + nr_wynagrodzenia +
                ", nr_pracownika=" + nr_pracownika +
                ", data='" + data + '\'' +
                ", kwota=" + kwota +
                '}';
    }
}
