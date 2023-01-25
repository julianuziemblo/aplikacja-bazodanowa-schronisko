package bdbt_project.SpringApplication.dbtables;

import org.springframework.web.multipart.MultipartFile;

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
    private String data_przyjecia_formatted;
    private String photosImagePath;
    private MultipartFile image;
    private boolean czyWSchronisku;
    private String czyWSchroniskuFormatted;

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

    public String getCzyWSchroniskuFormatted() {
        if(czyWSchronisku) return "Tak";
        return "Nie";
    }

    public boolean isCzyWSchronisku() {
        return czyWSchronisku;
    }

    public void setCzyWSchronisku(boolean czyWSchronisku) {
        this.czyWSchronisku = czyWSchronisku;
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

    public String getPlec_formatted() {
        String sex;
        if(this.plec == 'M') {
            sex = "Samiec";
        } else {
            sex = "Samica";
        }
        return sex;
    }

    public char getPlec() {
        return this.plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public char getRozmiar() {
        return this.rozmiar;
    }

    public String getRozmiar_formatted() {
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

    public String getData_przyjecia_formatted() {
        if(Objects.equals(data_przyjecia, "") || data_przyjecia == null) return "-";
        return data_przyjecia.split(" ")[0];
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "nr_zwerzecia=" + nr_zwerzecia +
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
