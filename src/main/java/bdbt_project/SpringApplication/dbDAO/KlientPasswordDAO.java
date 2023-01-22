package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.Application;
import bdbt_project.SpringApplication.dto.KlientPassword;
import bdbt_project.SpringApplication.utility.JSONUtility;
import org.json.simple.parser.ParseException;
import java.io.*;

public class KlientPasswordDAO {
    public KlientPasswordDAO(){}

    public void save(KlientPassword kh) throws IOException, ParseException {
        var path = Application.userAuthPath;
        JSONUtility.write(kh, path);
    }

    // Test
    public static void main(String[] args) throws IOException, ParseException {
        var k = new KlientPassword();
        k.setConfirmPassword("1234");
        k.setPassword("1234");
        var khdao = new KlientPasswordDAO();
        khdao.save(k);
    }
}
