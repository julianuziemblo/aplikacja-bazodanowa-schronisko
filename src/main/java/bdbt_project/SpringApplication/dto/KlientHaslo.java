package bdbt_project.SpringApplication.dto;

public class KlientHaslo {

    private String haslo;
    private String potwierdzHaslo;
    private String username;

    public KlientHaslo() {
    }

    public KlientHaslo(String username, String haslo, String potwierdzHaslo) {
        this.username = username;
        this.haslo = haslo;
        this.potwierdzHaslo = potwierdzHaslo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getPotwierdzHaslo() {
        return potwierdzHaslo;
    }

    public void setPotwierdzHaslo(String potwierdzHaslo) {
        this.potwierdzHaslo = potwierdzHaslo;
    }

    @Override
    public String toString() {
        return "KlientHaslo{" +
                "haslo='" + haslo + '\'' +
                ", potwierdzHaslo='" + potwierdzHaslo + '\'' +
                '}';
    }
}
