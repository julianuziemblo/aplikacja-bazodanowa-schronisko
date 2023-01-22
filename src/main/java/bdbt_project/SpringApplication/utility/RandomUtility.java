package bdbt_project.SpringApplication.utility;

import java.util.List;

public class RandomUtility {
    public static <T> T choice(List<T> list) {
        var rand = new java.util.Random();
        var index = rand.nextInt(list.size()-1);
        return list.get(index);
    }
}
