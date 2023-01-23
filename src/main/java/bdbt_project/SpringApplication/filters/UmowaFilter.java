package bdbt_project.SpringApplication.filters;

import bdbt_project.SpringApplication.dbtables.UmowaInfo;

import java.util.ArrayList;
import java.util.List;

public class UmowaFilter implements ValueFilter<String> {
    private String wszystkie;
    private String doAkceptacji;

    public UmowaFilter(){}

    public UmowaFilter(String wszystkie, String doAkceptacji) {
        this.wszystkie = wszystkie;
        this.doAkceptacji = doAkceptacji;
    }

    @Override
    public List<String> getSelected() {
        var selected = new ArrayList<String>();
        if(wszystkie != null && !wszystkie.equals("")) selected.add(wszystkie);
        if(doAkceptacji != null && !doAkceptacji.equals("")) selected.add(doAkceptacji);
        return selected;
    }

    public String getWszystkie() {
        return wszystkie;
    }

    public void setWszystkie(String wszystkie) {
        this.wszystkie = wszystkie;
    }

    public String getDoAkceptacji() {
        return doAkceptacji;
    }

    public void setDoAkceptacji(String doAkceptacji) {
        this.doAkceptacji = doAkceptacji;
    }
}
