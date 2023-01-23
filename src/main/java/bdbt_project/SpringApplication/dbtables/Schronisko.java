package bdbt_project.SpringApplication.dbtables;

public class Schronisko {
    private int nr_schroniska;
    private String nazwa;
    private String data_zalozenia;
    private int nr_adresu;

    public Schronisko(){}

    public Schronisko(int nr_schroniska, String nazwa,
                      String data_zalozenia, int nr_adresu) {
        this.nr_schroniska = nr_schroniska;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_schroniska() {
        return nr_schroniska;
    }

    public void setNr_schroniska(int nr_schroniska) {
        this.nr_schroniska = nr_schroniska;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData_zalozenia() {
        return data_zalozenia.split(" ")[0];
    }

    public void setData_zalozenia(String data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Schronisko{" +
                "nr_schroniska=" + nr_schroniska +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia='" + data_zalozenia + '\'' +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}
