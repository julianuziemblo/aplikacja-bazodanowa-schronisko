package bdbt_project.SpringApplication.dbDAO;

import bdbt_project.SpringApplication.Application;
import bdbt_project.SpringApplication.dto.KlientHaslo;
import bdbt_project.SpringApplication.utility.JSONUtility;
import org.json.simple.parser.ParseException;
import java.io.*;

public class KlientHasloDAO {
    public KlientHasloDAO(){}

    public void save(KlientHaslo kh) throws IOException, ParseException {
        var path = Application.userAuthPath;
        JSONUtility.write(kh, path);
    }

    public static void main(String[] args) throws IOException, ParseException {
        var k = new KlientHaslo();
        k.setPotwierdzHaslo("1234");
        k.setHaslo("1234");
        k.setUsername("jaja@wp.pl");
        var khdao = new KlientHasloDAO();
        khdao.save(k);
    }
}
