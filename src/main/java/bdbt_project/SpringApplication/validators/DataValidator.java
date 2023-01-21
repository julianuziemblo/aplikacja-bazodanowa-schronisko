package bdbt_project.SpringApplication.validators;

public interface DataValidator<T> {
    public boolean isValid(T object);
}
