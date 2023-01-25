package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.Application;
import bdbt_project.SpringApplication.dto.KlientPassword;
import bdbt_project.SpringApplication.utility.JSONUtility;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Objects;

public class KlientPasswordDAO {
    public KlientPasswordDAO(){}

    public void save(KlientPassword kh) throws IOException, ParseException {
        var path = Application.userAuthPath;
        JSONUtility.write(kh, path);
    }

    public KlientPassword updateWhereNotNull(KlientPassword current, KlientPassword newK) {
        if(newK.getPassword() != null && !Objects.equals(newK.getPassword(), "")) current.setPassword(newK.getPassword());
        if(newK.getConfirmPassword() != null && !Objects.equals(newK.getConfirmPassword(), "")) current.setConfirmPassword(newK.getConfirmPassword());
        return current;
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
