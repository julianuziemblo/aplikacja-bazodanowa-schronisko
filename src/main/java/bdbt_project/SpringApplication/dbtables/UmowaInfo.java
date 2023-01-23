package bdbt_project.SpringApplication.dbtables;

public class UmowaInfo extends Umowa {
    private String imie;
    private String imie_nazwisko;
    private String imie_nazwisko_klient;

    public UmowaInfo(){
        super();
    }

    public UmowaInfo(String imie, String imie_nazwisko, String imie_nazwisko_klient) {
        this.imie = imie;
        this.imie_nazwisko = imie_nazwisko;
    }

    public UmowaInfo(Umowa umowa, String imie, String imie_nazwisko) {
        super(umowa.getNr_umowy(), umowa.getRodzaj(),
                umowa.getData_podpisu(), umowa.getData_waznosci(),
                umowa.getNr_zwerzecia(), umowa.getNr_klienta(),
                umowa.getNr_pracownika());
        this.imie = imie;
        this.imie_nazwisko = imie_nazwisko;
    }

    public UmowaInfo(Umowa umowa, String imie, String imie_nazwisko, String imie_nazwisko_klient) {
        super(umowa.getNr_umowy(), umowa.getRodzaj(),
                umowa.getData_podpisu(), umowa.getData_waznosci(),
                umowa.getNr_zwerzecia(), umowa.getNr_klienta(),
                umowa.getNr_pracownika());
        this.imie = imie;
        this.imie_nazwisko = imie_nazwisko;
        this.imie_nazwisko_klient = imie_nazwisko_klient;
    }

    public UmowaInfo(int nr_umowy, char rodzaj, String data_podpisu,
                     String data_waznosci, int nr_zwerzecia,
                     int nr_klienta, int nr_pracownika, String imie,
                     String imie_nazwisko, String imie_nazwisko_klient) {
        super(nr_umowy, rodzaj, data_podpisu, data_waznosci, nr_zwerzecia, nr_klienta, nr_pracownika);
        this.imie = imie;
        this.imie_nazwisko = imie_nazwisko;
        this.imie_nazwisko_klient = imie_nazwisko_klient;
    }

    public UmowaInfo(int nr_umowy, char rodzaj, String data_podpisu,
                     String data_waznosci, int nr_zwerzecia,
                     int nr_klienta, int nr_pracownika, String imie_nazwisko_klient) {
        super(nr_umowy, rodzaj, data_podpisu, data_waznosci, nr_zwerzecia, nr_klienta, nr_pracownika);
        this.imie_nazwisko_klient = imie_nazwisko_klient;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getImie_nazwisko() {
        return imie_nazwisko;
    }

    public void setImie_nazwisko(String imie_nazwisko) {
        this.imie_nazwisko = imie_nazwisko;
    }

    public String getImie_nazwisko_klient() {
        return imie_nazwisko_klient;
    }

    public void setImie_nazwisko_klient(String imie_nazwisko_klient) {
        this.imie_nazwisko_klient = imie_nazwisko_klient;
    }

    @Override
    public String toString() {
        return "UmowaInfo{" +
                "imie='" + imie + '\'' +
                ", imie_nazwisko='" + imie_nazwisko + '\'' +
                ", imie_nazwisko_klient='" + imie_nazwisko_klient + '\'' + super.toString() + '\'' +
                '}';
    }

//    // Test
//    public static void main(String[] args) {
//        var umowaInfo = new UmowaInfo(1, 'T', "data_podpisu", "data_waznosci",
//                2, 3, 4, "imie", "nazwisko");
//        System.out.println(umowaInfo.getData_podpisu());
//    }
}
