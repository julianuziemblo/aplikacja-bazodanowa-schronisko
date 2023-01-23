package bdbt_project.SpringApplication.filters;

public class Accept {
    private String id;

    public Accept() {
        id="0";
    }

    public Accept(String id) {
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
        return "Accept{" +
                "id=" + id +
                '}';
    }
}
