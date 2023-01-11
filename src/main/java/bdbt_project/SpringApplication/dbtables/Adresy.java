package bdbt_project.SpringApplication.dbtables;


public class Adresy {
    private int NR_ADRESU;
    private String KRAJ;
    private String MIASTO;
    private String KOD_POCZTOWY;
    private String ULICA;
    private String NR_DOMU;
    private Integer NR_MIESZKANIA;

    public Adresy(){

    }

    public Adresy(Integer nr_adresu, String kraj,
                  String miasto, String kod_pocztowy,
                  String ulica, String nr_domu,
                  Integer nr_mieszkania) {
        this.NR_ADRESU = nr_adresu;
        this.KRAJ = kraj;
        this.MIASTO = miasto;
        this.KOD_POCZTOWY = kod_pocztowy;
        this.ULICA = ulica;
        this.NR_DOMU = nr_domu;
        this.NR_MIESZKANIA = nr_mieszkania;
    }

    public Integer getNR_ADRESU() {
        return NR_ADRESU;
    }
    public void setNR_ADRESU(Integer NR_ADRESU) {
        this.NR_ADRESU = NR_ADRESU;
    }

    public String getKRAJ() {
        return KRAJ;
    }
    public void setKRAJ(String KRAJ) {
        this.KRAJ = KRAJ;
    }

    public String getMIASTO() {
        return MIASTO;
    }
    public void setMIASTO(String MIASTO) {
        this.MIASTO = MIASTO;
    }

    public String getKOD_POCZTOWY() {
        return KOD_POCZTOWY;
    }
    public void setKOD_POCZTOWY(String KOD_POCZTOWY) {
        this.KOD_POCZTOWY = KOD_POCZTOWY;
    }

    public String getULICA() {
        return ULICA;
    }
    public void setULICA(String ULICA) {
        this.ULICA = ULICA;
    }

    public String getNR_DOMU() {
        return NR_DOMU;
    }
    public void setNR_DOMU(String NR_DOMU) {
        this.NR_DOMU = NR_DOMU;
    }

    public Integer getNR_MIESZKANIA() {
        return NR_MIESZKANIA;
    }
    public void setNR_MIESZKANIA(Integer NR_MIESZKANIA) {
        this.NR_MIESZKANIA = NR_MIESZKANIA;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
