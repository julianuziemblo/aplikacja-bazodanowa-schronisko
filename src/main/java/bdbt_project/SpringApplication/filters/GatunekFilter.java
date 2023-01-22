package bdbt_project.SpringApplication.filters;

import java.util.ArrayList;
import java.util.List;

public class GatunekFilter implements ValueFilter<String> {
    private String pies;
    private String kot;

    public GatunekFilter(){}

    public GatunekFilter(String pies, String kot) {
        this.pies = pies;
        this.kot = kot;
    }

    @Override
    public List<String> getSelected() {
        var selected = new ArrayList<String>();
        if(pies != null && !pies.equals("")) selected.add(pies);
        if(kot != null && !kot.equals("")) selected.add(kot);
        return selected;
    }

    public String getPies() {
        return pies;
    }

    public void setPies(String pies) {
        this.pies = pies;
    }

    public String getKot() {
        return kot;
    }

    public void setKot(String kot) {
        this.kot = kot;
    }

    @Override
    public String toString() {
        return "GatunekFilter{" +
                "pies='" + pies + '\'' +
                ", kot='" + kot + '\'' +
                '}';
    }
}
