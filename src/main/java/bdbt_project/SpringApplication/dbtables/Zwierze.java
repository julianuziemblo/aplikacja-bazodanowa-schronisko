package bdbt_project.SpringApplication.dbtables;

import java.util.Objects;

public class Zwierze {

    private int nr_zwerzecia;
    private String imie;
    private String gatunek;
    private String rasa;
    private char plec;
    private char rozmiar;
    private double koszt_utrzymania;
    private String umaszczenie;
    private String nazwa_karmy;
    private String data_przyjecia;
    private int nr_schroniska;
    private String photosImagePath;

    public Zwierze(){}

    public Zwierze(int nr_zwierzecia, String imie,
                   String gatunek, String rasa,
                   char plec, char rozmiar,
                   double koszt_utrzymania,
                   String umaszczenie, String nazwa_karmy,
                   String data_przyjecia, int nr_schroniska) {
        this.nr_zwerzecia = nr_zwierzecia;
        this.imie = imie;
        this.gatunek = gatunek;
        this.rasa = rasa;
        this.plec = plec;
        this.rozmiar = rozmiar;
        this.koszt_utrzymania = koszt_utrzymania;
        this.umaszczenie = umaszczenie;
        this.nazwa_karmy = nazwa_karmy;
        this.data_przyjecia = data_przyjecia;
        this.nr_schroniska = nr_schroniska;
    }


    public String getPhotosImagePath() {
        return "src/main/resources/static/assets/animals/" + nr_zwerzecia + ".png";
    }

    public int getNr_zwerzecia() {
        return nr_zwerzecia;
    }

    public void setNr_zwerzecia(int nr_zwerzecia) {
        this.nr_zwerzecia = nr_zwerzecia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRasa() {
        return Objects.requireNonNullElse(this.rasa, "Nieznana");
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getPlec() {
        String sex;
        if(this.plec == 'M') {
            sex = "Samiec";
        } else {
            sex = "Samica";
        }
        return sex;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getRozmiar() {
        String size;
        if(this.rozmiar == 'S') {
            size = "Mały";
        } else if(this.rozmiar == 'M') {
            size = "Średni";
        } else {
            size = "Duży";
        }
        return size;
    }

    public void setRozmiar(char rozmiar) {
        this.rozmiar = rozmiar;
    }

    public double getKoszt_utrzymania() {
        return koszt_utrzymania;
    }

    public void setKoszt_utrzymania(double koszt_utrzymania) {
        this.koszt_utrzymania = koszt_utrzymania;
    }

    public String getUmaszczenie() {
        return umaszczenie;
    }

    public void setUmaszczenie(String umaszczenie) {
        this.umaszczenie = umaszczenie;
    }

    public String getNazwa_karmy() {
        return nazwa_karmy;
    }

    public void setNazwa_karmy(String nazwa_karmy) {
        this.nazwa_karmy = nazwa_karmy;
    }

    public String getData_przyjecia() {
        return data_przyjecia;
    }

    public void setData_przyjecia(String data_przyjecia) {
        this.data_przyjecia = data_przyjecia;
    }

    public int getNr_schroniska() {
        return nr_schroniska;
    }

    public void setNr_schroniska(int nr_schroniska) {
        this.nr_schroniska = nr_schroniska;
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "nr_zwierzecia=" + nr_zwerzecia +
                ", imie='" + imie + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", rasa='" + rasa + '\'' +
                ", plec=" + plec +
                ", rozmiar=" + rozmiar +
                ", koszt_utrzymania=" + koszt_utrzymania +
                ", umaszczenie='" + umaszczenie + '\'' +
                ", nazwa_karmy='" + nazwa_karmy + '\'' +
                ", data_przyjecia='" + data_przyjecia + '\'' +
                ", nr_schroniska=" + nr_schroniska +
                '}';
    }
}
