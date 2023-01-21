package bdbt_project.SpringApplication.dto;

import bdbt_project.SpringApplication.dbtables.Klient;

public class KlientDTO extends Klient {

    private String haslo;
    private String potwierdzHaslo;

    public KlientDTO() {
        super();
    }

    public KlientDTO(int nr_klienta, String imie,
                     String nazwisko, String data_urodzenia,
                     String pesel, char plec, String email,
                     String nr_telefonu, int nr_adresu,
                     Integer nr_schroniska, String haslo,
                     String potwierdzHaslo) {
        super(nr_klienta, imie, nazwisko, data_urodzenia,
                pesel, plec, email, nr_telefonu, nr_adresu,
                nr_schroniska);

        this.haslo = haslo;
        this.potwierdzHaslo = potwierdzHaslo;
    }

    @Override
    public String toString() {
        return "KlientDTO{" +
                "haslo='" + haslo + '\'' +
                ", potwierdzHaslo='" + potwierdzHaslo + '\'' +
                super.toString() +
                '}';
    }
}
