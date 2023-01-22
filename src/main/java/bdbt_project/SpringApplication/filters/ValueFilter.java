package bdbt_project.SpringApplication.filters;

import java.util.List;

public interface ValueFilter<T> {
    public List<T> getSelected();
}
