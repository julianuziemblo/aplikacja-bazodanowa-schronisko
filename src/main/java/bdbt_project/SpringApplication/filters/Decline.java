package bdbt_project.SpringApplication.filters;

public class Decline {
    private String id;

    public Decline() {
        id="0";
    }

    public Decline(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Decline{" +
                "id=" + id +
                '}';
    }
}
