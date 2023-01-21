package bdbt_project.SpringApplication.utility;

public class SQLInputChecker {
    public static boolean check(String value) {
        for(int i=0; i<value.length(); ++i) {
            if(!Character.isAlphabetic(value.charAt(i))) return false;
        }
        return true;
    }
}
