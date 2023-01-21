package bdbt_project.SpringApplication.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtility {
    public static boolean isBlank(String path) throws IOException {
        var br = new BufferedReader(new FileReader(path));
        var res = br.readLine() == null;
        br.close();
        return res;
    }
}
