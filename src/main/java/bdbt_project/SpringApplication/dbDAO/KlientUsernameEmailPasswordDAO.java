package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.Application;
import bdbt_project.SpringApplication.dto.KlientUsernameEmailPassword;
import bdbt_project.SpringApplication.utility.JSONUtility;
import org.json.simple.parser.ParseException;
import java.io.*;

public class KlientUsernameEmailPasswordDAO {
    public KlientUsernameEmailPasswordDAO(){}

    public void save(KlientUsernameEmailPassword kh) throws IOException, ParseException {
        var path = Application.userAuthPath;
        JSONUtility.write(kh, path);
    }

    // Test
    public static void main(String[] args) throws IOException, ParseException {
        var k = new KlientUsernameEmailPassword();
        k.setConfirmPassword("1234");
        k.setPassword("1234");
        k.setUsername("jaja");
        var khdao = new KlientUsernameEmailPasswordDAO();
        khdao.save(k);
    }
}
