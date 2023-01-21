package bdbt_project.SpringApplication.validators;

import bdbt_project.SpringApplication.dbtables.Klient;

public class KlientValidator implements DataValidator<Klient> {

    @Override
    public boolean isValid(Klient klient) {
        return false;
    }
}
